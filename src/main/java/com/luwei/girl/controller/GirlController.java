package com.luwei.girl.controller;

import com.luwei.girl.domain.Girl;
import com.luwei.girl.domain.Result;
import com.luwei.girl.repository.GirlRepository;
import com.luwei.girl.service.GirlService;
import com.luwei.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/girl")
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
    /*
    * 查询所有女生列别
    *@return
    * */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        logger.info("girlList");
        return girlRepository.findAll();
    }

    @GetMapping(value="/index")
    public String index(Model model){
        List<Girl> girlList = girlRepository.findAll();
        model.addAttribute("girlList",girlList);
//        model.addAttribute("test","test");
//        System.out.println(girlList);
        System.out.println("test the result");
        return "index";
    }

    /*
    * 添加女生信息
    * */

    @PostMapping(value = "/add")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        System.out.println("++++++++++++++++++++++");
        if(bindingResult.hasErrors()){

//            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
//            result.setData(null);
//            return null;
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
//        Girl girl = new Girl();
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        girl.setMoney(girl.getMoney());
        System.out.println(girl.getCupSize());
//        Result result = new Result();
//        result.setCode(0);
//        result.setMsg("成功");
//        result.setData(girlRepository.save(girl));
        return ResultUtil.success(girlRepository.save(girl));
    }

    /*
    * 查找一个女生的信息
    * */
    @GetMapping(value="/girl/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }
    @GetMapping(value="/girl/age/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }
    /*
    * 更新一个女生的信息
    * */
    @PutMapping(value = "/girl/{id}")
    public Girl girlPutOne(@PathVariable("id")Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);
        return girlRepository.save(girl);

    }
    @DeleteMapping(value = "/girl/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
//        Girl girl1 = girlRepository.getOne(id);
        girlRepository.delete(id);
    }

    @PostMapping(value = "/girl/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}

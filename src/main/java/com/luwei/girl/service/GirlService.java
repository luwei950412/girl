package com.luwei.girl.service;

import com.luwei.girl.domain.Girl;
import com.luwei.girl.enums.ResultEnum;
import com.luwei.girl.exception.GirlException;
import com.luwei.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author lw
 * @create 15 15:33
 * @desc
 **/
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(19);
        girlB.setCupSize("BBBB");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        System.out.println(id);
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            throw  new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age >10 && age <16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }


    /*
    * 通过id来查询一个女生的信息，用于测试使用
    * */
    public Girl getOne(Integer id){
        return girlRepository.findOne(id);
    }
}

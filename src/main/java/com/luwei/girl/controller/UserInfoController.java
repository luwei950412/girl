package com.luwei.girl.controller;

import com.luwei.girl.domain.UserInfo;
import com.luwei.girl.service.UserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * created by  luwei
 * 2017-10-30 14:13.
 **/
@Controller
@RequestMapping(value = "/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "/register")
    public String register(){
        return "userInfo/register";
    }


    @RequestMapping(value = "/userAdd")
    @RequiresPermissions("userInfo:add")
    public String add(){
//        System.out.println(userInfo.getUsername());
//        userInfoService.addUser(userInfo);
//        return "userInfo/login";
        return "userInfo/userInfoAdd";
    }


    @GetMapping(value = "/getByName")
    public String getByUsername(@PathVariable(value = "username") String username, Model model){
        UserInfo userInfo= userInfoService.findByUsername(username);
        model.addAttribute("userInfo",userInfo);
        return "userInfo/show";
    }

}

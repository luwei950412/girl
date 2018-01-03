package com.luwei.girl.service;

import com.luwei.girl.domain.UserInfo;
import com.luwei.girl.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by  luwei
 * 2017-10-30 14:23.
 **/
@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo addUser(UserInfo userInfo){
        return userInfoRepository.save(userInfo);
    }

    public UserInfo findByUsername(String username){

        return userInfoRepository.findByUsername(username);
    }
}

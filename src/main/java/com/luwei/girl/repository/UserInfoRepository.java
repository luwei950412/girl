package com.luwei.girl.repository;
import com.luwei.girl.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by  luwei
 * 2017-10-30 14:24.
 **/
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
    public UserInfo findByUsername(String username);
}

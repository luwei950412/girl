package com.luwei.girl;

import com.luwei.girl.domain.Girl;
import com.luwei.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * created by  luwei
 * 2017-10-16 20:29.
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    public void findOne(){
        Girl girl = girlService.getOne(1);
        Assert.assertEquals(new Integer(15),girl.getAge());
    }
}

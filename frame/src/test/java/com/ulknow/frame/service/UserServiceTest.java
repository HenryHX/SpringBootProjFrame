package com.ulknow.frame.service;

import com.ulknow.frame.domain.UserDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Administrator
 * 2019-01-17
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void selectByPage() {
        UserDO userDO = userService.selectByKey(1L);
        Assert.assertThat(userDO.getUsername(), is("zhang"));
    }
}
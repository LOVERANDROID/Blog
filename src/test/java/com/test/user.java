package com.test;

import com.blog.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class user {
    @Autowired
    UserMapper userMapper;

    @Test
    public void userTest1(){
        System.out.println(userMapper.selectByPrimaryKey(1).toString());
    }
}

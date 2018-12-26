package com.blog.service;

import com.blog.dao.UserMapper;
import com.blog.model.User;
import com.blog.model.UserExample;
import com.blog.model.UserExample.Criteria;
import com.blog.service.impl.LoginServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginServiceImpl implements LoginServiceI {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean checkUserName(String username) {
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo("test");
        List<User> list = userMapper.selectByExample(example);
        if (list.size() != 0)
            return true;
        return false;
    }

    @Override
    public boolean checkPassword(String password) {
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andPasswordEqualTo("123");
        List<User> list = userMapper.selectByExample(example);
        if (list.size() != 0)
            return true;
        return false;
    }

    @Override
    public boolean chechUser(String username, String password) {
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        example.or().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> list = userMapper.selectByExample(example);
        if (list.size() != 0)
            return true;
        return false;
    }
}

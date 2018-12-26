package com.blog.controller;

import com.blog.model.Message;
import com.blog.model.User;
import com.blog.service.impl.LoginServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserContoller {

    @Autowired
    LoginServiceI loginServiceI;

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Message getSingleUse(User user) {
        boolean b = loginServiceI.chechUser(user.getUsername(), user.getPassword());
        if (b)
            return Message.success().add("userInfo", user);
        return Message.failed();
    }
}

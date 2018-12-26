package com.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml", "classpath:/springmvc/dispatcherServlet.xml"})
public class UserLogin {

    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @Before
    public void initMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test() throws Exception {
        MvcResult result =  mockMvc.perform(MockMvcRequestBuilders.get("/user").param("username", "test").param("password", "123")).andReturn();
        MockHttpServletRequest request = result.getRequest();

        //User user = (User)request.getAttribute("userInfo");
        //System.out.println(user.toString());
    }
}

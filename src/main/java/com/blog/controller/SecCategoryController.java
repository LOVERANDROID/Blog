package com.blog.controller;

import com.blog.model.Message;
import com.blog.model.SecondCategory;
import com.blog.service.impl.SecCtegoryServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/secCategory")
public class SecCategoryController {
    @Autowired
    SecCtegoryServiceI secCtegoryService;

    @ResponseBody
    @RequestMapping("/allCategories")
    public Message getAllSecCategories(){
        return Message.success();
    }

    /**
     * 根据上一级分类id获取该id下所有的子类
     * @param categoryId 上一级分类id
     * @return 该id下子类信息
     */
    @ResponseBody
    @RequestMapping("/someCategories/{categoryId}")
    public Message getCategoriesByFirstId(@PathVariable("categoryId") int categoryId){
        List<SecondCategory> second = secCtegoryService.getCategoriesByFirstId(categoryId);
        return Message.success().add("secondCategories", second);
    }

    /**
     * 根据二级分类的id查询该分类的信息
     * @param id 二级分类的id
     * @return 该分类的信息
     */
    @ResponseBody
    @RequestMapping("/category/{id}")
    public Message getCategoryById(@PathVariable("id")int id){
        SecondCategory category = secCtegoryService.getCategoryById(id);
        return Message.success().add("secategory", category);
    }
}

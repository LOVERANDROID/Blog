package com.blog.controller;

import com.blog.model.Category;
import com.blog.model.Message;
import com.blog.service.impl.CategoryServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryServiceI categoryService;

    /**
     * 显示所有的分类信息
     * @return
     */
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    @ResponseBody
    public Message getAllCategories(){
        List<Category> list = categoryService.getAllCategories();
        return Message.success().add("categoryList", list);
    }

    /**
     * 获取单个category
     * @param categoryId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
    public Message getSingleCategory(@PathVariable("categoryId") int categoryId){
        Category category = categoryService.getCategory(categoryId);
        return Message.success().add("category", category);
    }

    /**
     * 更新分类表
     * @param category 分类实体
     */
    public Message updateBlogNumInCategories(Category category){
        categoryService.updateCategory(category);
        return Message.success();
    }
    //todo:新建分类信息
    //todo:新建子类分类信息
}

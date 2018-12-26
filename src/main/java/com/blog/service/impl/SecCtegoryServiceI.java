package com.blog.service.impl;

import com.blog.model.SecondCategory;

import java.util.List;

public interface SecCtegoryServiceI {
    /**
     * 根据上一级分类id获取该id下所有的分类
     * @param categoryId 上一级分类id
     * @return 该id下所有的分类
     */
    List<SecondCategory> getCategoriesByFirstId(int categoryId);

    /**
     * 根据二级分类的id查询该分类的信息
     * @param id 二级分类的id
     * @return 该分类的信息
     */
    SecondCategory getCategoryById(int id);
}

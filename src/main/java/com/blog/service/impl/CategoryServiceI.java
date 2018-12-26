package com.blog.service.impl;

import com.blog.model.Category;

import java.util.List;

public interface CategoryServiceI {

    /**
     * 查询所有分类信息
     * @return
     */
    List<Category> getAllCategories();

    /**
     * 根据id获取category
     * @param categoryId
     * @return
     */
    Category getCategory(int categoryId);

    /**
     * 根据一级分类id更新分类表信息
     * @param category
     */
    void updateCategory(Category category);
}

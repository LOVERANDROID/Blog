package com.blog.service;

import com.blog.dao.CategoryMapper;
import com.blog.model.Category;
import com.blog.service.impl.CategoryServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryServiceI {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategories() {
        List<Category> list = categoryMapper.selectByExample(null);
        return list;
    }

    @Override
    public Category getCategory(int categoryId) {
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        return category;
    }

    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }
}

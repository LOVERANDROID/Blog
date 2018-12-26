package com.blog.service;

import com.blog.dao.SecondCategoryMapper;
import com.blog.model.SecondCategory;
import com.blog.model.SecondCategoryExample;
import com.blog.model.SecondCategoryExample.Criteria;
import com.blog.service.impl.SecCtegoryServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecCategoryServiceImpl implements SecCtegoryServiceI {
    @Autowired
    SecondCategoryMapper secondCategoryMapper;

    @Override
    public List<SecondCategory> getCategoriesByFirstId(int categoryId) {
        SecondCategoryExample example = new SecondCategoryExample();
        Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        List<SecondCategory> list = secondCategoryMapper.selectByExample(example);
        return list;
    }

    @Override
    public SecondCategory getCategoryById(int id) {
        return secondCategoryMapper.selectByPrimaryKey(id);
    }
}

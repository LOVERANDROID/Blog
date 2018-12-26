package com.blog.service;

import com.blog.dao.ContentMapper;
import com.blog.model.Content;
import com.blog.model.ContentExample;
import com.blog.model.ContentExample.Criteria;
import com.blog.service.impl.ContentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentServiceI {
    @Autowired
    ContentMapper contentMapper;

    @Override
    public List<Content> getAllContents() {
        List<Content> list = contentMapper.selectByExample(null);
        return list;
    }

    @Override
    public void deleteContentById(int blogId) {
        contentMapper.deleteByPrimaryKey(blogId);
    }

    @Override
    public void saveBlogOrReleaseBlog(Content content) {
        contentMapper.insertSelective(content);
    }

    @Override
    public Content getSingleBlog(int blogId) {
        Content content = contentMapper.selectByPrimaryKey(blogId);
        return content;
    }

    @Override
    public void updateBlogById(Content content) {
        contentMapper.updateByPrimaryKeySelective(content);
    }

    @Override
    public long countByCategoryId(int categoryId) {
        ContentExample example = new ContentExample();
        Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        return contentMapper.countByExample(example);
    }

    @Override
    public List<Content> getContentsByCategoryId(int categoryId) {
        ContentExample example = new ContentExample();
        Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        return contentMapper.selectByExample(example);
    }
}

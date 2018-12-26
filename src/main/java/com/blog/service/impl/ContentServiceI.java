package com.blog.service.impl;

import com.blog.model.Content;

import java.util.List;

public interface ContentServiceI {
    /**
     * 获取所有的博客
     * @return
     */
    List<Content> getAllContents();

    /**
     * 根据删除博客
     * @param blogId
     */
    void deleteContentById(int blogId);

    /**
     * 保存博客
     * @param content
     */
    void saveBlogOrReleaseBlog(Content content);

    /**
     * 根据获取单个博客内容
     * @param blogId
     * @return
     */
    Content getSingleBlog(int blogId);

    /**
     * 根据id进行更新博客
     * @param content
     */
    void updateBlogById(Content content);

    /**
     * 根据分类id统计该分类下的博客数
     * @param categoryId 分类id
     * @return 该id下的博客数
     */
    long countByCategoryId(int categoryId);

    /**
     * 通过一级分类id获取该分类下所有的博客
     * @param categoryId 一级分类id
     * @return 返回该id下的所有博客
     */
    List<Content> getContentsByCategoryId(int categoryId);
}

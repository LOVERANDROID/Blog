package com.blog.service.impl;

import com.blog.model.Comment;

import java.util.List;

public interface CommentServiceI {
    /**
     * 获取评论
     * @return -List<Comment>
     */
    List<Comment> getComments(int blogId);

    /**
     * 根据评论id删除某一条评论
     * @param commentId -评论id
     */
    void deleteCommentById(int commentId);

    /**
     * 根据博客id删除该博客下的所有评论
     * @param blogId -博客id
     */
    void deleteCommentByBlogId(int blogId);

    /**
     * 添加新评论
     * @param comment -评论实体类
     */
    void addComment(Comment comment);

    /**
     * 根据博客id统计博客下的评论数
     * @param blogId 博客id
     * @return 该博客下的评论数
     */
    long countByBlogId(int blogId);
}

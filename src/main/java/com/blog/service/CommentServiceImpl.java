package com.blog.service;

import com.blog.dao.CommentMapper;
import com.blog.model.Comment;
import com.blog.model.CommentExample;
import com.blog.model.CommentExample.Criteria;
import com.blog.service.impl.CommentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentServiceI {
    private final CommentMapper commentMapper;
    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<Comment> getComments(int blogId) {
        CommentExample example = new CommentExample();
        Criteria criteria = example.createCriteria();
        criteria.andBlogIdEqualTo(blogId);
        return commentMapper.selectByExample(example);
    }

    @Override
    public void deleteCommentById(int commentId) {
        CommentExample example = new CommentExample();
        Criteria criteria = example.createCriteria();
        criteria.andCommentIdEqualTo(commentId);
        commentMapper.deleteByExample(example);
    }

    @Override
    public void deleteCommentByBlogId(int blogId) {
        CommentExample example = new CommentExample();
        Criteria criteria = example.createCriteria();
        criteria.andBlogIdEqualTo(blogId);
        commentMapper.deleteByExample(example);
    }

    @Override
    public void addComment(Comment comment) {
        commentMapper.insertSelective(comment);
    }

    @Override
    public long countByBlogId(int blogId) {
        CommentExample example = new CommentExample();
        Criteria criteria = example.createCriteria();
        criteria.andBlogIdEqualTo(blogId);
        return commentMapper.countByExample(example);

    }
}

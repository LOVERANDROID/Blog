package com.blog.controller;

import com.blog.model.Comment;
import com.blog.model.Message;
import com.blog.service.impl.CommentServiceI;
import com.blog.service.impl.ContentServiceI;
import com.blog.utils.GetDateAndFormat;
import com.blog.utils.GetIP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    CommentServiceI commentService;

    @Autowired
    ContentServiceI contentService;

    /**
     * 获取博客的评论
     *
     * @param blogId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/comments/{blogId}", method = RequestMethod.GET)
    public Message getAllComments(@PathVariable("blogId") int blogId) {
        List<Comment> comments = commentService.getComments(blogId);
        return Message.success().add("comments", comments);
    }

    /**
     * 新加评论,同时更新博客表中的评论数量
     *
     * @param comment
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public Message addComment(@RequestParam("blogId") int blogId, Comment comment, HttpServletRequest request) {
        String ip = GetIP.getIP(request);
        String time = GetDateAndFormat.getDate();
        comment.setCommentIp(ip);
        comment.setCreateTime(time);
        commentService.addComment(comment);
        return Message.success();
    }

    /**
     * 在某个博客的评论列表中删除某条评论
     * 需要根据评论id删除该评论
     *
     * @param commentId 评论id
     * @return 返回处理信息
     */
    @ResponseBody
    @RequestMapping(value = "/comments/{commentId}", method = RequestMethod.DELETE)
    public Message deleteComment(@PathVariable("commentId") int commentId, @RequestParam("blogId") int blogId) {
        commentService.deleteCommentById(commentId);
        return Message.success();
    }

    /**
     * 删除某条博客下的所有评论
     *
     * @param blogId -博客id
     */
    void deleteCommentsByBlogId(int blogId) {
        commentService.deleteCommentByBlogId(blogId);
    }

}

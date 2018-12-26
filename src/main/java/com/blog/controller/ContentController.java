package com.blog.controller;

import com.blog.model.Category;
import com.blog.model.Content;
import com.blog.model.Message;
import com.blog.service.impl.ContentServiceI;
import com.blog.utils.FileUtil;
import com.blog.utils.GetDateAndFormat;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ContentController {
    @Autowired
    ContentServiceI contentService;
    @Autowired
    CategoryController categoryController;
    @Autowired
    CommentController commentController;

    /**
     * 分页查询所有博客
     * @param pageNum -
     * @return -
     */
    //todo:查询需要根据登录状态进行查询，登录和未登录查询的博客不一样，根据permission字段判断
    //todo:首页显示博客列表可以不用查询所有字段，
    @RequestMapping(value = "/contents", method = RequestMethod.GET)
    @ResponseBody
    public Message getAllContentsWithPage(@RequestParam(value = "page", defaultValue = "1") int pageNum) {
        PageHelper.startPage(pageNum, 4);
        List<Content> list = contentService.getAllContents();
        PageInfo<Content> pageInfo = new PageInfo<>(list, 4);
        return Message.success().add("pageInfo", pageInfo);
    }

    /**
     * 通过一级分类id获取该分类下所有的博客
     * @param categoryId 一级分类id
     * @return 返回该id下的所有博客
     */
    @ResponseBody
    @RequestMapping("/contents/contents_with_categoryid/{categoryId}")
    public Message getContentsByCategoryId(@PathVariable("categoryId")int categoryId){
        List<Content> list = contentService.getContentsByCategoryId(categoryId);
        return Message.success().add("blog_title_list", list);
    }

    /**
     * 根据id删除博客，同时删除与该博客相关联的文件，评论
     * @param blogId -
     * @return -
     */
    @ResponseBody
    @RequestMapping(value = "/contents/{blogId}", method = RequestMethod.DELETE)
    public Message deleteContent(@PathVariable("blogId") int blogId, HttpServletRequest request) {
        try {
            //删除文件
            String filename = contentService.getSingleBlog(blogId).getBlogContent();
            FileUtil.DeleteFile(FileUtil.BLOG_SAVE_PATH, filename);
            //删除评论
            commentController.deleteCommentsByBlogId(blogId);
            //删除博客
            contentService.deleteContentById(blogId);
            return Message.success();
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return Message.failed();
        }
    }

    /**
     * 保存博客
     * @param content -博客额实体类
     * @param request -
     * @return -
     * @throws IOException -
     */
    @ResponseBody
    @RequestMapping(value = "/addContent", method = RequestMethod.POST)
    public Message createContent(Content content, HttpServletRequest request) throws IOException {
        //获取实体类中的blogContent
        String blogContent = content.getBlogContent();
        //拼凑数据库保存的文件名
        String filename = GetDateAndFormat.getTimeWithSimpleFormat() + ".md";
        //获取创建时间
        String createTime = GetDateAndFormat.getDate();
        content.setCreateTime(createTime);
        content.setBlogContent(filename);
        //获取保存文件的路径
        //文件操作方法
        FileUtil.OutPutString(blogContent, FileUtil.BLOG_SAVE_PATH, filename);
        contentService.saveBlogOrReleaseBlog(content);
        return Message.success();
    }

    /**
     * 根据id查询博客内容
     * @param blogId -
     * @param request -
     * @return -
     */
    //@ResponseBody
    @RequestMapping(value = "/content/{blogId}", method = RequestMethod.GET)
    public String getSingeBlogContent(@PathVariable("blogId") int blogId, HttpServletRequest request, Model model) {
        Map<String, Object> map = getSingleBlogInfo(blogId, request);
        //return new ModelAndView("blog_detail", map);
        model.addAttribute("map", map);
        return "blog_detail";
    }

    /**
     * 进入博客编辑页
     *
     * @param blogId -
     * @param request -
     * @return -
     */
    @RequestMapping(value = "/getcontent/{blogId}", method = RequestMethod.GET)
    public ModelAndView gotoEditPageWithId(@PathVariable("blogId") int blogId, HttpServletRequest request) {
        Map<String, Object> map = getSingleBlogInfo(blogId, request);
        return new ModelAndView("edit_blog", map);
    }

    /**
     * 更新博客
     * @param filename -
     * @param blogId -
     * @param content -
     * @param request -
     * @return -
     * @throws IOException -
     */
    @ResponseBody
    @RequestMapping(value = "/content/{blogId}", method = RequestMethod.PUT)
    public Message updateBlogById(@RequestParam("filename") String filename, @PathVariable("blogId") int blogId, Content content, HttpServletRequest request) throws IOException {
        //获取实体类中的blogContent
        String blogContent = content.getBlogContent();
        //拼凑数据库保存的文件名
        content.setBlogContent(filename);
        //获取保存文件的路径
        //文件操作方法
        FileUtil.OutPutString(blogContent, FileUtil.BLOG_SAVE_PATH, filename);
        String updateTime = GetDateAndFormat.getDate();
        content.setUpdateTime(updateTime);
        content.setBlogId(blogId);
        contentService.updateBlogById(content);
        return Message.success();
    }

    //查询单个博客时的操作
    private Map<String, Object> getSingleBlogInfo(int blogId, HttpServletRequest request) {
        Map<String, Object> map = null;
        try {
            Content content = contentService.getSingleBlog(blogId);
            //根据从数据库中读取的文件名，从相应文件中读取博客内容
            String filename = content.getBlogContent();
            StringBuffer blogContent = FileUtil.InputString(FileUtil.BLOG_SAVE_PATH, filename);
            //根据categoryId获取category信息
            Category category = (Category) categoryController.getSingleCategory(content.getCategoryId()).getMap().get("category");

            map = new HashMap<>();
            map.put("blogInfo", content);
            map.put("content", blogContent);
            map.put("category", category);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}

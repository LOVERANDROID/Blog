<%--
  Created by IntelliJ IDEA.
  User: 10994
  Date: 2018/12/19
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.10.2.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4" id="category-list">
            <hr>
            <div onmouseover="this.style.background='#f5f5f5'" onmouseout="this.style.background='#ffffff'">
                <p style="padding: 10px">
                    <a href="javascript:void(0)" onclick="newCategory()">新建分类</a>
                </p>
            </div>
        </div>
        <div class="col-md-4" id="secCategory-list">
            <hr>
            <div onmouseover="this.style.background='#f5f5f5'" onmouseout="this.style.background='#ffffff'">
                <p style="padding: 10px">新建分类</p>
            </div>
        </div>
        <div class="col-md-4" id="blog-title-list">
            <hr>
            <div onmouseover="this.style.background='#f5f5f5'" onmouseout="this.style.background='#ffffff'">
                <p style="padding: 10px">
                    <a href="add_blog.jsp">新建文章</a>
                </p>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    var appPath = '${pageContext.request.contextPath}';
    $(function () {
        getCategory();
        itemOnClick();
    });
    /**
     * 查询一级分类信息的ajax
     */
    function getCategory() {
        $.ajax({
            url: appPath + "/category",
            type: "get",
            success: function (result) {
                if (result.code === 1) {
                    build_categoryList(result);
                }
            }
        });
    }
    /**
     * 显示一级分类信息
     * @param result ajax的返回数据
     */
    function build_categoryList(result) {
        $(".category-item").empty();
        var temp = result.map.categoryList;
        var newItem = $("<div></div>").append("<p style='padding: 10px'>新建分类</p>");
        $.each(temp, function (index, item) {
            var _item = $("<div onmouseover=\"this.style.background='#f5f5f5'\" onmouseout=\"this.style.background='#ffffff'\"></div>")
                .attr("category-id", item.categoryId).addClass("category-item")
                .append($("<p style='padding: 10px'></p>").append($("<a href='javascript:void(0)'></a>").append(item.categoryName)));
            $("#category-list").append(_item);
        });
    }

    /**
     * 发起查询二级列表的ajax
     * @param categoryId 被选中的一级分类的分类id，默认为列表中的第一个
     */
    function getSecCategory(categoryId) {
        //var firstCategoryId = 1;
        $.ajax({
            url:appPath+"/secCategory/someCategories/"+categoryId,
            type:"get",
            success:function (result) {
                build_secCategoryList(result);
            }
        });
    }

    /**
     * 构建二级分类列表
     * @param result 查询二级分类的返回信息
     */
    function build_secCategoryList(result) {
        $(".sec-category-item").empty();
        var temp = result.map.secondCategories;
        var newItem = $("<div></div>").append("<p style='padding: 10px'>新建分类</p>");
        $.each(temp, function (index, item) {
            var _item = $("<div onmouseover=\"this.style.background='#f5f5f5'\" onmouseout=\"this.style.background='#ffffff'\"></div>")
                .attr("secondcategory-id", item.secCategoryId).addClass("sec-category-item")
                .append($("<p style='padding: 10px'></p>").append($("<a href='javascript:void(0)'></a>").append(item.secCategoryName)));
            $("#secCategory-list").append(_item);
        });
    }

    /**
     *根据一级分类id获取该分类下的所有博客列表
     * @param 一级分类id
     */
    function getBlog(categoryId) {
        $.ajax({
            url:appPath+"/contents/contents_with_categoryid/"+categoryId,
            type:"get",
            success:function (result) {
                build_blogList(result);
            }
        })
    }

    /**
     * 构建博客列表
     * @param result
     */
    function build_blogList(result) {
        $(".blog-title-item").empty();
        var temp = result.map.blog_title_list;
        $.each(temp, function (index, item) {
            var _item = $("<div onmouseover=\"this.style.background='#f5f5f5'\" onmouseout=\"this.style.background='#ffffff'\"></div>")
                .attr("blog-id", item.blogId).addClass("blog-title-item")
                .append($("<p style='padding: 10px'></p>").append($("<a href='"+appPath+"/content/"+item.blogId+"'></a>").append(item.blogTitle)));
            $("#blog-title-list").append(_item);
        });
    }

    /**
     * 列表的点击事件
     */
    function itemOnClick() {
        $("#category-list").on("click", ".category-item", function () {
            var categoryId = $(this).attr("category-id");
            getSecCategory(categoryId);
            getBlog(categoryId);
        });

        $("#secCategory-list").on("click", ".sec-category-item", function () {
            alert(this);
        });

        /*
        $("#blog-title-list").on("click", ".blog-title-item", function () {
            var blogId = $(this).attr("blog-id");
            getBlogDetailAjax(appPath, blogId);
        });
        */
    }

    function newCategory() {
        var _item = $("<div onmouseover=\"this.style.background='#f5f5f5'\" onmouseout=\"this.style.background='#ffffff'\"></div>")
            .attr("category-id", 10).addClass("category-item")
            .append($("<p style='padding: 10px'></p>").append($("<a href='javascript:void(0)'></a>").append("111111")));
      $("#category-list").append(_item)
    }
</script>
<script src="${pageContext.request.contextPath}/static/js/common.js"></script>
</html>

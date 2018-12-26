<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>博客首页</title>
    <script src="static/js/jquery-1.10.2.js"></script>
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="static/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="WEB-INF/jsp/topbar.jsp"/>
<jsp:include page="WEB-INF/jsp/login.jsp"/>
<!-- Main Content -->
<div class="container">
    <div class="row">
        <div class="col-md-12 col-lg-8 col-lg-offset-2" id="blog-list">

        </div>
        <div class="col-md-12 col-lg-4 col-lg-offset-4" id="page-bar">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                </ul>
            </nav>
        </div>
    </div>
</div>
<hr>

<jsp:include page="WEB-INF/jsp/footer.jsp"/>

</body>
<script type="text/javascript">
    //显示登录框
    function showLoginModal() {
        $("#loginModal").modal({
            backdrop: 'static',
            keyboard: false
        });
    }

    $("#topBar-loginBtn").click(function login() {
        showLoginModal();
    });
    //登录发起的ajax
    $("#loginBtn").click(function () {
        var userData = $("#loginForm").serialize();
        $.ajax({
            url: appPath + "/user",
            data: userData,
            type: "post",
            success: function (result) {
                if (result.code === 1) {
                    $("#loginBtn").removeClass("btn-default").addClass("btn-success").text("登录中...");
                    $("#topBar-loginBtn").addClass("hidden");
                    $("#login-img").removeClass("hidden")
                } else {
                    showLoginModal();
                }
            }
        })
    });
</script>

<script type="text/javascript">
    var appPath = '${pageContext.request.contextPath}';
    var currentPage;
    $(function () {
        to_page(1);
        delete_blog();
    });

    /**
     * 创建列表
     * @param result
     */
    function build_list(result) {
        $("#blog-list").empty();
        var data = result.map.pageInfo.list;
        $.each(data, function (index, item) {
            var title = $("<h1></h1>").addClass("post-title").text(item.blogTitle);
            var _abstract = $("<h3></h3>").addClass("post-subtitle").text(item.blogAbstract);
            var listItem = $("<div></div>").addClass("post-preview");
            var _time = $("<span></span>").addClass("post-meta").text("发表于" + item.createTime);
            var _comments = $("<a href='javascript:void(0)'></a>").text("评论");
            var _deleteBlog = $("<a href='javascript:void(0)'></a>").attr("delete-id", item.blogId).addClass("delete-btn").text("删除文章");
            //$("<a href='" + appPath + "/content/" + item.blogId + "'></a>").append(title)
            $("<a href='"+appPath+"/content/"+item.blogId+"'></a>").append(title)
                .append(_abstract)
                .appendTo(listItem)
                .attr("blog-id", item.blogId)
                .addClass("blog-list-item");
            listItem.append(_time).appendTo($("#blog-list")).append("<p></p>")
                .append(_comments).append(" ").append(_deleteBlog).append("<hr>");
        });
    }

    /**
     * 发起分页查询的请求
     * @param page
     */
    function to_page(page) {
        $.ajax({
            url: appPath + "/contents",
            data: {page: page},
            type: "get",
            success: function (result) {
                if (result.code === 1) {
                    build_list(result);
                    build_pageBar(result);
                }
            }
        });
    }

    /**
     * 创建分页条
     * @param result
     */
    function build_pageBar(result) {
        var position = $("#page-bar nav ul");
        $(position).empty();
        var _pageInfo = result.map.pageInfo;
        var _pages = _pageInfo.navigatepageNums;
        var _currentPage = _pageInfo.pageNum;
        currentPage = _currentPage;
        var _totalPage = _pageInfo.pages;
        var firstPage = $("<li></li>").append($("<a href='#'></a>").text("首页")).attr("onclick", "to_page(1)");
        var lastPage = $("<li></li>").append($("<a href='#'></a>").text("尾页")).attr("onclick", "to_page(" + _totalPage + ")");
        var previous = $("<li></li>").append($("<a href='#'></a>").append("&laquo;")).attr("onclick", "to_page(" + (_currentPage - 1) + ")");
        var next = $("<li></li>").append($("<a href='#'></a>").append("&raquo;")).attr("onclick", "to_page(" + (_currentPage + 1) + ")");
        $(position).append(firstPage).append(previous);
        $.each(_pages, function (index, item) {
            var temp = $("<li></li>").append($("<a href='#'></a>").append(item)).attr("onclick", "to_page(" + item + ")");
            $(position).append(temp);
            if (item === _currentPage)
                temp.addClass("active");
        });
        $(position).append(next).append(lastPage);
        //如果在第一页，"首页和上一页禁用"
        if (_pageInfo.isFirstPage) {
            firstPage.addClass("disabled").removeAttr("onclick").find("a").removeAttr("href");
            previous.addClass("disabled").removeAttr("onclick").find("a").removeAttr("href");
        }
        //如果在最后一页，"尾页和下一页禁用"
        if (_pageInfo.isLastPage) {
            lastPage.addClass("disabled").removeAttr("onclick").find("a").removeAttr("href");
            next.addClass("disabled").removeAttr("onclick").find("a").removeAttr("href");
        }
    }

    /**
     * 删除文章
     */
    function delete_blog() {
        $("#blog-list").on("click", ".delete-btn", function () {
            if (confirm("确认删除？")) {
                var id = $(this).attr("delete-id");
                $.ajax({
                    url: appPath + "/contents/" + id,
                    type: "delete",
                    success: function (result) {
                        if (result.code === 1)
                            to_page(currentPage);
                        else
                            alert(result.msg);
                    }
                });
            }
        });
    }

    /**
     * 博客列表的item的点击事件
     */
    function itemOnClick() {
        $("#blog-list").on("click", ".blog-list-item", function () {
            var blogId = $(this).attr("blog-id");
            alert(blogId);
            getBlogDetailAjax(appPath, blogId);
        });
    }

</script>
<script src="${pageContext.request.contextPath}/static/js/common.js"></script>
</html>

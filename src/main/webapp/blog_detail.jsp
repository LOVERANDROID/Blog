<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${map.blogInfo.blogTitle}</title>
    <!--editormd的js-->
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.10.2.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/markdown/editormd.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/lib/markdown/marked.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/lib/markdown/prettify.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/lib/markdown/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/lib/markdown/underscore.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/lib/markdown/sequence-diagram.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/lib/markdown/flowchart.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/lib/markdown/jquery.flowchart.min.js"></script>

    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.js"></script>
    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <%--自定义属性--%>
    <link href="${pageContext.request.contextPath}/static/css/blog.css"/>

    <script type="text/javascript">
        $(function () {
            var testEditor;
            testEditor = editormd.markdownToHTML("content-editormd", {
                //markdown: $scope.apidetails.content,
                htmlDecode: "style,script,iframe",  // you can filter tags decode
                emoji: true,
                taskList: true,
                tex: true,  // 默认不解析
                flowChart: true,  // 默认不解析
                sequenceDiagram: true // 默认不解析
            });
        });
    </script>
</head>
<body>
<!-- Page Header -->
<header class="intro-header">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 offset-lg-2 col-md-10 offset-md-1">
                <div class="post-heading">
                    <h1>${map.blogInfo.blogTitle}</h1>
                    <h2 class="subheading">${map.blogInfo.blogAbstract}</h2>
                    <span class="meta">${map.blogInfo.createTime}</span>
                    <button class="btn btn-default" id="saveOrReleaseBtn" hidden="hidden">保存</button>
                    <span class="meta" id="category"></span>
                    <span class="meta" id="secategory"></span>
                    <a href="${pageContext.request.contextPath}/getcontent/${map.blogInfo.blogId}"><span
                            class="meta">编辑</span></a>

                </div>
            </div>
        </div>
    </div>
</header>
<!-- Post Content -->
<article>
    <div class="container">
        <div class="row">
            <div id="content-editormd" class="col-lg-8 offset-lg-2 col-md-10 offset-md-1">
                <textarea>${map.content}</textarea>
            </div>
        </div>
        <div class="row">
            <span>评论</span>
            <hr>
            <div class="post-preview col-lg-8 offset-lg-2 col-md-10 offset-md-1" id="comments">

            </div>
            <div class="post-preview col-lg-8 offset-lg-2 col-md-10 offset-md-1">
                <form id="comment-form" method="post">
                    <div class="input-group">
                        <input type="text" class="form-control" name="commentView" id="input-comments"
                               onblur="validateComments()"/>

                        </span>
                    </div>
                </form>
                <button class="btn btn-default" id="releaseCommentBtn" onclick="add_comment()">发表</button>
            </div>
            <hr>
        </div>
    </div>

</article>

<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 offset-lg-2 col-md-10 offset-md-1">
                <p class="copyright text-muted">Copyright &copy; Your Website 2017</p>
            </div>
        </div>
    </div>
</footer>


</body>
<SCRIPT TYPE="text/javascript">
    var appPath = '${pageContext.request.contextPath}';
    $(function () {
        changeSaveOrRelease();
        getComments_ajax();
        getCategoryByBlogId();
    });

    //根据permission的值改变发表或者保存的状态
    function changeSaveOrRelease() {
        var permission = ${map.blogInfo.permission};
        if (permission === 1) {
            $("#saveOrReleaseBtn").removeAttr("hidden").text("设为私密");
        } else if (permission === 0) {
            $("#saveOrReleaseBtn").removeAttr("hidden").text("发表");
        }
    }

    //发送查询评论的请求
    function getComments_ajax() {
        var blogId = ${map.blogInfo.blogId};
        $.ajax({
            url: appPath + "/comments/" + blogId,
            type: "get",
            success: function (result) {
                if (result.code === 1) {
                    build_commentList(result);
                }
            }
        });
    }

    //构建评论列表
    function build_commentList(result) {
        $("#comments").empty();
        var _data = result.map.comments;
        console.log(_data);
        $.each(_data, function (index, item) {
            var _commentView = $("<p></p>").addClass("post-meta");
            var _commentIp = $("<spanp></spanp>").addClass("post-meta");
            var _commentTime = $("<span></span>").addClass("post-meta");
            var _operate = $("<a href=''></a>").text("删除");
            var listItem = $("<div></div>").addClass("comment-list-item");
            listItem.append(_commentIp.text("#" + (index + 1) + "楼 " + item.commentIp))
                .append(_commentView.text(item.commentView))
                .append(_commentTime.text(item.createTime))
                .append(_operate.attr("delete-id", item.commentId).addClass("delete-a"));
            $("#comments").append(listItem.append("<hr>"));
        });

    }

    /**
     * 删除评论
     */
    function delete_comment() {
        var commentId = $(".comment-list-item").find("a").attr("delete-id");
        //if (confirm("确认删除该评论？")) {
        $.ajax({
            url: appPath + "/comments/" + commentId + "?blogId=${map.blogInfo.blogId}",
            type: "delete",
            success: function (result) {
                if (result.code === 1) {
                    getComments_ajax();
                    //$(this).parent().remove();
                }
            }
        });
        //}

    }

    /**
     * 发表评论
     */
    function add_comment() {
        var formData = $("#comment-form").serialize();
        var blogId = ${map.blogInfo.blogId};
        $.ajax({
            url: appPath + "/comments",
            data: formData + "&blogId=" + blogId,
            type: "post",
            success: function (result) {
                if (result.code === 1) {
                    getComments_ajax();
                    $("#comment-form")[0].reset();
                }
            }
        });
    }

    /**
     *  判断评论输入框是否为空
     */
    //todo:合法性判断
    function validateComments() {
        var intputComment = $("#input-comments").val();
        if (intputComment.length > 0) {
            $("#releaseCommentBtn").removeClass("disabled");
        } else {
            $("#releaseCommentBtn").addClass("disabled");
        }
    }

    /**
     * 显示博客所在的分类
     */
    function getCategoryByBlogId() {
        var categoryId = ${map.blogInfo.categoryId};
        var secCategoryId = ${map.blogInfo.secategoryId};
        if (categoryId === 0) {
            $("#category").text("未分类");
        } else {
            $.ajax({
                url: appPath + "/category/" + categoryId,
                type: "get",
                success: function (result) {
                    if (result.code === 1)
                        $("#category").text("分类：" + result.map.category.categoryName);
                }
            });
        }
        if (secCategoryId === 0){
            $("#secategory").text("未分类");
        } else {
            $.ajax({
                url: appPath + "/secCategory/category/" + categoryId,
                type: "get",
                success: function (result) {
                    if (result.code === 1)
                        $("#category").text("分类：" + result.map.secategory.secCategoryName);
                }
            });
        }
    }
</SCRIPT>

<script type="text/javascript">
    $(function () {
        $("#comments").on("click", ".delete-a", function () {
            delete_comment();
        })
    });

</script>

</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>[编辑] ${requestScope.blogInfo.blogTitle}</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.10.2.js"></script>
    <link href="${pageContext.request.contextPath}/static/css/markdown/editormd.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/markdown/editormd.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        var markdownEditor;
        $(function () {
            markdownEditor = editormd("markdown-editor", {
                placeholder: '本编辑器支持Markdown编辑，左边编写，右边预览',  //默认显示的文字，这里就不解释了
                width: "auto",
                height: "auto",
                syncScrolling: "single",
                path: "${pageContext.request.contextPath}/static/lib/markdown/",   //你的path路径（原资源文件中lib包在我们项目中所放的位置）
                // theme: "dark",//工具栏主题
                // previewTheme: "dark",//预览主题
                // editorTheme: "pastel-on-dark",//编辑主题
                saveHTMLToTextarea: true,
                //emoji: false,
                taskList: true,
                tocm: true,         // Using [TOCM]
                tex: true,                   // 开启科学公式TeX语言支持，默认关闭
                flowChart: true,             // 开启流程图支持，默认关闭
                sequenceDiagram: true       // 开启时序/序列图支持，默认关闭,
            });
            //testEditor.getMarkdown(); 获取markdown格式的文本
        });
    </script>

</head>
<body>
<form class="form-horizontal" id="newBlogForm">
    <div class="form-group">
        <label for="blog-title" class="col-sm-2 control-label">标题</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="blog-title" name="blogTitle"
                   value="${requestScope.blogInfo.blogTitle}">
        </div>
    </div>
    <div class="form-group">
        <label for="blog-abstract" class="col-sm-2 control-label">副标题</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="blog-abstract" name="blogAbstract"
                   value="${requestScope.blogInfo.blogAbstract}">
        </div>
    </div>

    <div class="form-group">
        <label for="category" class="col-sm-2 control-label">选择分类</label>
        <div class="col-sm-10">
            <select class="form-control" id="category" name="categoryId">
            </select>
        </div>
    </div>
</form>
<button class="btn btn-primary" id="saveBlogBtn">保存文章</button>
<button class="btn btn-info" id="releaseBlogBtn">发表文章</button>
<input type="hidden" name="filename" id="filename" value="${requestScope.blogInfo.blogContent}">
<div id="markdown-editor">
    <label></label>
    <textarea style="display: none;" class="form-control" id="content-editormd-markdown-doc"
              name="content-editormd-markdown-doc">${requestScope.content}</textarea>
</div>
</body>
<script type="text/javascript">
    var appPath = '${pageContext.request.contextPath}';
    $(function () {
        getCategory();
    });

    /**
     * 查询分类信息的ajax
     */
    function getCategory() {
        $.ajax({
            url: appPath + "/category/",
            type: "get",
            success: function (result) {
                if (result.code === 1) {
                    build_categoryList(result);
                }
            }
        });
    }

    /**
     * 显示分类信息
     * @param result ajax的返回数据
     */
    function build_categoryList(result) {
        var temp = result.map.categoryList;
        $.each(temp, function (index, item) {
            var _item = $("<option></option>").attr("value", item.categoryId).text(item.categoryName);
            if (item.categoryId === ${requestScope.category.categoryId})
                _item.attr("selected", "selected");
            $("#category").append(_item);
        })
    }
</script>

<script type="text/javascript">
    /**
     * 点击保存，仅自己可见
     */
    $("#saveBlogBtn").click(function () {
        saveBlog_ajax(0)
    });

    /**
     * 点击发表，所有用户都可见
     */
    $("#releaseBlogBtn").click(function () {
        saveBlog_ajax(1)
    });

    /**
     * 保存博客的请求
     * @param permission 保存（1）和发表（0）的区分标志
     */
    function saveBlog_ajax(permission) {
        var temp = $(document).find("form").serialize() + "&permission=" + permission + "&blogContent=" + markdownEditor.getMarkdown();
        $.ajax({
            url: appPath + "/content/${requestScope.blogInfo.blogId}",
            data: temp+"&filename="+$('#filename').val(),
            type: "put",
            success: function (result) {
                if (result.code === 1) {
                    //清楚表单内容
                    $("#newBlogForm")[0].reset();
                    if (permission === 1) {
                        alert("发表成功");
                    } else {
                        alert("保存成功");
                    }
                    //$(window).attr("location", appPath+"/content/${requestScope.blogInfo.blogId}");
                    window.location = appPath+"/content/${requestScope.blogInfo.blogId}";

                }
            }
        });
    }
</script>
</html>

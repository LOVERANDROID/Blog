function getBlogDetailAjax(appPath, blogId){
    $.ajax({
        url: appPath + "/content_with_blogid/" + blogId,
        type: "get",
        success: function (result) {
            alert("test:"+result);
            if (result.code === 1) {
                location.href = appPath+"/blog_detail.jsp";
            }
        }
    });
}
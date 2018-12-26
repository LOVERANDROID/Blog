<%--
  Created by IntelliJ IDEA.
  User: 10994
  Date: 2018/12/20
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="static/js/jquery-1.10.2.js"></script>
</head>
<body>
<select id="test">
    <option value="1">one</option>
    <option value="2">two</option>
    <option value="3">three</option>
    <option value="4">four</option>
    <option value="5">five</option>
</select>
</body>
<script type="text/javascript">
    var _option = document.getElementById("test");
    var _index = _option.selectedIndex;
    var str = _option.options[_index].value;
    alert("aaaa:"+str);
</script>
<script type="text/javascript">
    var str = $("#test option:selected").val();
    alert(str);
</script>
</html>

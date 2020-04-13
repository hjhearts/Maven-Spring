<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-04-13
  Time: 오전 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.min.js"></script>
<script>
    var cnt = 1;
    function fn_addFile(){
        $('#d_file').append('<br><input type="file" name="file' + cnt + '"/>');
        cnt++;
    }
</script>
    <form method="post" action="${contextPath}/upload" enctype="multipart/form-data">
        <label>아이디:</label>
        <input type="text" name="id"/><br/>
        <label>이름</label>
        <input type="text" name="name"/><br/>
        <button type="button" onclick="fn_addFile()">파일 추가</button>
        <div id="d_file"></div>
        <input type="submit" value="업로드"/>
    </form>
</body>
</html>

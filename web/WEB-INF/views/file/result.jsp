<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-04-13
  Time: 오전 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>업로드 완료</h1>
    <label>아이디</label>
    <input type="text" name="id" value="${map.id}}" readonly/><br/>
    <label>이름</label>
    <input type="text" name="name" value="${map.name}" readonly/><br/>
    <div class="result-images">
        <c:forEach var="imageFileName" items="${map.fileList}">
            <a href="${contextPath}/download?imageFileName=${imageFileName}">
                <img src="${contextPath}/download?imageFileName=${imageFileName}"/></a>
            <br/><br/>
        </c:forEach>
    </div>
    <a href="${contextPath}/form">다시 업로드 하기</a>
</body>
</html>

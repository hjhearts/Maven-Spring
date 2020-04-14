<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-04-09
  Time: 오후 5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>사이드</title>
    <style>
        .no-underline{text-decoration: none}
    </style>
</head>
<body>
    <h1>사이드 메뉴</h1>
    <h1>
        <a href="${contextPath}/member/listMembers.do" class="no-underline">회원관리</a><br/>
        <a href="${contextPath}/board/listArticles.do" class="no-underline">게시판 관리</a><br/>
        <a href="${contextPath}/#" class="no-underline">상품 관리</a>
    </h1>
</body>
</html>

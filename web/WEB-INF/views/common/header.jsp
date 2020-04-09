<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-04-09
  Time: 오후 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("utf-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>상단부</title>
    <style>
        #myFont{font-size: 30px}
    </style>
</head>
<body>
    <table style="border:0; width:100%">
        <tr>
            <td>
                <a href="${contextPath}/main.do">
                    <img src="${contextPath}/resources/image/duke_swing.gif" alt=""/>
                </a>
            </td>
            <td>
                <h1><span id="myFont">스프링실습 홈페이지</span></h1>
            </td>
            <td>
                <a href="#"><h3>로그인</h3></a>
            </td>
        </tr>
    </table>
</body>
</html>

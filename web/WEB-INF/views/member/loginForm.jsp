<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-04-09
  Time: 오후 1:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/member/login.do">
    <table>
        <tr>
            <td><label>아이디</label></td>
            <td><input type="text" name="id"/></td>
        </tr>
        <tr>
            <td><label>패스워드</label></td>
            <td><input type="password" name="pwd"/></td>
        </tr>
    </table>
    <input type="submit" value="로그인"/>
</form>
</body>
</html>

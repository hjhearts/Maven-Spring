<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-04-09
  Time: 오후 5:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><tiles:insertAttribute name="title"/></title>
</head>
<body>
    <div id="container">
        <div id="header">
            <tiles:insertAttribute name="header"/>
        </div>
        <div id="sidebar-left">
            <tiles:insertAttribute name="side"/>
        </div>
        <div id="content">
            <tiles:insertAttribute name="body"/>
        </div>
        <div id="footer">
            <tiles:insertAttribute name="footer"/>
        </div>
    </div>
</body>
</html>

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
    <style>
        #container {
            width: 100%;
            margin: 0 auto;
            text-align:center;
            border: 0 solid #bcbcbc;
        }
        #header {
            padding: 5px;
            margin-bottom: 5px;
            border: 0px solid #bcbcbc;
            background-color: lightgreen;
        }
        #sidebar-left {
            width: 15%;
            height:700px;
            padding: 5px;
            margin-right: 5px;
            margin-bottom: 5px;
            float: left;
            background-color: yellow;
            border: 0 solid #bcbcbc;
            font-size:10px;
        }
        #content {
            width: 75%;
            padding: 5px;
            margin-right: 5px;
            float: left;
            border: 0 solid #bcbcbc;
        }
        #footer {
            clear: both;
            padding: 5px;
            border: 0px solid #bcbcbc;
            background-color: lightblue;
        }

    </style>
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

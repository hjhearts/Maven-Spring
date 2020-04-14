<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-04-13
  Time: 오후 5:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.min.js"></script>
    <script>
        $(function(){
            $('#checkJSON').on('click', function(){
                var article = {
                    articleNO:'114',
                    writer:'박지성',
                    title:'hello',
                    content:'this is content'
                };
                $.ajax({
                    type:'post',
                    url:'${contextPath}/boards',
                    contentType:"application/json",
                    data:JSON.stringify(article),
                    success:function(data, textStatus){
                    },
                    error:function(d, ts){
                        alert('Error');
                    }
                });
            });
        });
    </script>
</head>
<body>
    <input type="button" id="checkJSON" value="새글 등록"/>
    <div id="output"></div>
</body>
</html>

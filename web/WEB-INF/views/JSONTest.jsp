<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-04-13
  Time: 오후 5:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.min.js"></script>
    <script>
        $(function(){
            $('#checkJSON').on('click', function(){
                var member = {
                    id:'park',
                    pwd:'1234',
                    name:'jisungpark',
                    email:'twohearts@korea.kr'
                };
                $.ajax({
                    type:'post',
                    url:'${pageContext.request.contextPath}/test/info',
                    contentType:"application/json",
                    data:JSON.stringify(member),
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
    <input type="button" id="checkJSON" value="SEND JSON"/>
    <div id="output"></div>
</body>
</html>

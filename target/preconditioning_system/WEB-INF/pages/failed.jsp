<%--
  Created by IntelliJ IDEA.
  User: ling
  Date: 2020/2/28
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <base href="<%=basePath %>"/>
    <c:set var="pac" value="${pageContext.request.contextPath}" scope="request"/>
    <link rel="shortcut icon"  href="${pac}/css/favicon.ico"/>
    <title>你还没有登录呢！</title>

</head>
<body>
你还没有登录!!点击进入<a href="user/login.do">登录界面</a><br/>
<span id="second">7<span>秒后自动跳转到登录界面


    <script>
        var  count=document.getElementById("second");
        var index=7;

        setInterval(function () {
            index--;
            count.innerText=index+"秒后自动跳转到登录界面";
            if(index==1){
                window.location.href="http://localhost:8283/web/user/login.do";
            }

        },1000)

    </script>
</body>
</html>

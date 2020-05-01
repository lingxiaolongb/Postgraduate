<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>参加复试吧</title>
    <base href="<%=basePath %>"/>
    <c:set var="pac" value="${pageContext.request.contextPath}" scope="request"/>
    <link rel="stylesheet" type="text/css" href="${pac}/css/taowa.css"/>
    <link rel="stylesheet" type="text/css" href="${pac}/css/stu-view-success.css"/>
    <link rel="shortcut icon" href="${pac}/css/favicon.ico"/>
</head>

<body>
<div class="tw_img">
    <div class="tw_logo">
        <p class="tw_tip">
            考研预调剂信息网
        </p>
        <span>欢迎你:${studentName}同学</span>
    </div>
    <div class="yan_img">

    </div>
    <div class="tw_lists">
        <span>“研”路漫漫&nbsp;&nbsp;唯有坚持!</span>
    </div>
</div>
<div class="tw_content">
    <div class="con_left">
        <ul class="con_ul">
            <li ><a href="student/info">个人考研信息</a></li>
            <li><a href="student/policy" >调剂信息功能</a></li>
            <li><a href="student/application" >查询信息调剂</a></li>
            <li><a href="student/notice" >查看复试通知</a></li>
            <li style="background: #ead2be"><a href="student/join.do" >参加复试</a></li>
        </ul>
    </div>
    <div class="body_left">
        <table class="gridtable">
            <colgroup>
                <col width="100">
                <col width="130">
                <col width="150">
                <col width="150">
                <col width="150">
                <col width="150">
            </colgroup>
            <thead>
            <tr>
                <th>学校代码</th>
                <th>学校负责人</th>
                <th>学校名称</th>
                <th>学校联系电话</th>
                <th>学校Email</th>
                <th>备注</th>
            </tr>
            </thead>
            <tbody>
        <c:forEach items="${schoolList}" var="record">
                <tr>
                    <td>${record.schollId}</td>
                    <td>${record.contacts}</td>
                    <td>${record.schollName}</td>
                    <td>${record.tel}</td>
                    <td>${record.email}</td>
                    <td>请尽快与学校联系</td>
                </tr>
        </c:forEach>
            </tbody>
        </table>

    </div>
</div>


</body>
</html>

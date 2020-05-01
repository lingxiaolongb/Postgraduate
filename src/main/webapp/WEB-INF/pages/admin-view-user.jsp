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
    <title>用户管理界面</title>
    <base href="<%=basePath %>" />
    <c:set var="pac" value="${pageContext.request.contextPath}" scope="request"/>
    <link rel="stylesheet" type="text/css" href="${pac}/css/taowa.css"/>
    <link rel="stylesheet" type="text/css" href="${pac}/css/admin/admin-user-info.css"/>
    <link rel="stylesheet" type="text/css" href="${pac}/layui/css/layui.css"/>
    <link rel="shortcut icon"  href="${pac}/css/favicon.ico"/>
    <script src="${pac}/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/layer/layer.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/js/admin/admin-find-user.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
<div class="tw_img">
    <div class="tw_logo">
        <p class="tw_tip">
            考研预调剂信息网
        </p>
        <span>欢迎你:XXX管理员</span>
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
            <li><a href="admin/info">用户信息界面</a></li>
            <li><a href="admin/role.do">用户权限设定</a></li>
            <li><a href="admin/log.do">用户访问日志</a></li>
        </ul>
    </div>
    <div class="con_right">
        <div class="body_top">
            <input class="put" id="findSub" type="text" placeholder="按姓名查询"/>
            <input class="put" id="findSch" type="text" placeholder="按登录名查询"/>
            <button class="btn" id="select"><span>查询</span></button>
            <button class="btn" id="reSet"><span>重置</span></button>
            <button class="btn" id="add"><span>新建</span></button>
        </div>
        <div class="body_left">
            <h2>用户列表</h2>
            <table id="demo" lay-filter="demo" class="layui-table"></table>
        </div>
        <div id="shenmolian" style="display: none;">
            <a class="layui-btn layui-btn-sm" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-sm" lay-event="del">删除</a>
        </div>
    </div>
</div>


</body>
</html>

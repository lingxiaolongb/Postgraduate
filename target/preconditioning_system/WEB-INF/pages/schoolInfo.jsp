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
    <base href="<%=basePath %>"/>
    <meta charset="utf-8">
    <title>高校招生信息网</title>
    <c:set var="pac" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" type="text/css" href="${pac}/css/taowa.css" />
    <link rel="stylesheet" type="text/css" href="${pac}/css/sch-info.css"/>
    <link rel="stylesheet" type="text/css" href="${pac}/css/dialog.css"/>
    <link rel="shortcut icon"  href="${pac}/css/favicon.ico"/>
    <script src="${pac}/js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/js/dialog.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/js/sch-info.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
<div class="dialog-wrap"></div>
<div class="tw_img">
    <div class="tw_logo">

        <p class="tw_tip">
            考研预调剂信息网
        </p>
        <span>尊敬的:${school.contacts}老师&nbsp;&nbsp;欢迎你</span>
    </div>
    <div class="yan_img">

    </div>
    <div class="tw_lists">
        <span>学而不倦,得知不难。其乐无穷乎!</span>
    </div>
</div>
<div class="tw_content">
    <div class="con_left">
        <ul class="con_ul">
            <li style="background: #ead2be"><a href="school/info">高校信息填写</a></li>
            <li><a href="school/vacancy">发布缺额信息</a></li>
            <li><a href="school/view.do">查看缺额信息</a></li>
            <li><a href="school/choose">筛选考生信息</a></li>
            <li><a href="school/notice">发送复试通知</a></li>
            <li><a href="school/condition.do">考生复试情况</a></li>
        </ul>
    </div>
    <div id="student_info">
        <p class="title">高校信息</p>

        <div class="top_dom"></div>
        <div class="items">

            <span class="item_el">联系人:</span>
            <input  id="contacts" class="info_sr_left" disabled value="${school.contacts}"  />

            <span class="item_el">学校代码:</span>
            <input  id="schoolId" class="info_sr_right" disabled value="${school.schollId}" />

        </div>

        <div class="items">

            <span class="item_el">学校名称:</span>
            <input  id="schoolName" class="info_sr_left" value="${school.schollName}"  />

            <span class="item_el">联系电话:</span>
            <input  id="telephone" class="info_sr_right" value="${school.tel}"  />

        </div>
        <div class="items">

            <span class="item_el" >邮箱:</span>
            <input  id="email"  value="${school.email}" class="info_sr_left" />


        </div>


        <div class="top_dom"></div>
        <button class="info_sub">
            <span>保存</span>
        </button>
    </div>
</div>


</body>
</html>

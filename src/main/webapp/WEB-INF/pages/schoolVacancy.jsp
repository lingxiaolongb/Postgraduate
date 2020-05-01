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
    <title>高校发布缺额信息页面</title>
    <base href="<%=basePath %>"/>
    <c:set var="pac" value="${pageContext.request.contextPath}"/>
    <link rel="shortcut icon"  href="${pac}/css/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="${pac}/css/taowa.css" />
    <link rel="stylesheet" type="text/css" href="${pac}/css/schVacancy.css" />
    <script src="${pac}/js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/js/sch-vacancy.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/layer/layer.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
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
            <li><a href="school/info">高校信息填写</a></li>
            <li><a href="school/vacancy">发布缺额信息</a></li>
            <li><a href="school/view.do">查看缺额信息</a></li>
            <li><a href="school/choose">筛选考生信息</a></li>
            <li><a href="school/notice">发送复试通知</a></li>
            <li><a href="school/condition.do">考生复试情况</a></li>
        </ul>
    </div>
    <div id="student_info">
        <p class="title">发布缺额信息</p>

        <div class="top_dom"></div>
        <div class="items">

            <span class="item_el"><span class="stars">*</span>高校名称:</span>
            <input id="schName"  class="info_sr_left" disabled value="${school.schollName}" />

            <span class="item_el"><span class="stars">*</span>联系人:</span>
            <input id="contacts" class="info_sr_right" />

        </div>


        <div class="items">

            <span class="item_el"><span class="stars">*</span>联系方式:</span>
            <input id="telephone"  class="info_sr_left" />

            <span class="item_el"><span class="stars">*</span>邮箱:</span>
            <input   id="email" class="info_sr_right" />

        </div>

        <div class="items">
            <span class="item_el"><span class="stars">*</span>专业:</span>
            <input id="specialized0"  class="info_sr_left" />
            <span class="item_el"><span class="stars">*</span>缺额人数:</span>
            <input id="lack0"  class="info_sr_right" />
        </div>


        <div class="top_dom" id="bottom_dom">
            <button class="add-field">
                <p><span class="add">+</span>点击添加发布其他缺额信息</p>
            </button>
            <button class="info_sub">
                <span>保存</span>
            </button>
        </div>

    </div>
</div>


</body>
</html>

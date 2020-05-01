<%--
  Created by IntelliJ IDEA.
  User: ling
  Date: 2020/3/3
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
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
    <title>个人考研信息</title>
    <base href="<%=basePath %>" />
    <c:set var="pac" value="${pageContext.request.contextPath}" scope="request"/>
    <script src="${pac}/js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/js/dialog.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/js/stu-info.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" type="text/css" href="${pac}/css/dialog.css"/>
    <link rel="shortcut icon"  href="${pac}/css/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="${pac}/css/taowa.css" />
    <link rel="stylesheet" type="text/css" href="${pac}/css/student_info.css"/>

</head>
<body>
<div class="dialog-wrap">
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
                <li style="background: #ead2be"><a href="student/info">个人考研信息</a></li>
                <li><a href="student/policy" >调剂信息功能</a></li>
                <li><a href="student/application" >查询信息调剂</a></li>
                <li><a href="student/notice" >查看复试通知</a></li>
                <li><a href="student/join.do" >参加复试</a></li>
            </ul>
        </div>

        <div id="student_info">
            <p class="title">考生信息</p>

            <div class="top_dom"></div>
            <div class="items">

                <span class="item_el">姓名:</span>
                <input  id="name" class="info_sr_left" disabled  value="${student.sname}" />

                <span class="item_el">准考证号:</span>
                <input  id="exam_id" class="info_sr_right" disabled value="${student.examId}" />

            </div>

            <div class="items">

                <span class="item_el">本科院校:</span>
                <input  id="f_school" class="info_sr_left" value="${student.fromSchool}" />

                <span class="item_el">本科专业:</span>
                <input  id="f_subject" class="info_sr_right" value="${student.fromSubject}" />

            </div>
            <div class="items">

                <span class="item_el">报考院校:</span>
                <input  id="t_school" class="info_sr_left" value="${student.toSchool}" />

                <span class="item_el">报考专业:</span>
                <input  id="t_subject" class="info_sr_right" value="${student.toSubject}" />

            </div>
            <div class="items">

                <span class="item_el">总分数:</span>
                <input  id="total"  class="info_sr_left"  disabled placeholder="总分数自动生成" value="${student.total}"/>

                <span class="item_el">政治分数:</span>
                <input  id="policy" class="info_sr_right" value="${student.politics}" />

            </div>
            <div class="items">

                <span class="item_el">英语分数:</span>
                <input  id="english" class="info_sr_left" value="${student.english}"/>

                <span class="item_el">专业课1分数:</span>
                <input  id="math" class="info_sr_right" value="${student.math}" />

            </div>
            <div class="items">

                <span class="item_el">专业课2分数:</span>
                <input  id="specialized" class="info_sr_right" value="${student.specialized}" />


            </div>

            <div class="top_dom"></div>
            <button class="info_sub">
                <span>保存</span>
            </button>
        </div>

    </div>

</body>
</html>

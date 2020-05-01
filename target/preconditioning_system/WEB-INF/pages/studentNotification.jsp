
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
    <title>复试通知</title>
    <base href="<%=basePath %>" />
    <c:set var="pac" value="${pageContext.request.contextPath}" scope="request"/>
    <link rel="shortcut icon"  href="${pac}/css/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="${pac}/css/taowa.css" />
    <link rel="stylesheet" type="text/css" href="${pac}/css/noticed.css"/>
    <link rel="stylesheet" type="text/css" href="${pac}/layui/css/layui.css"/>
    <script src="${pac}/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/layer/layer.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/js/stu-notice.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/layui/layui.js" type="text/javascript" charset="utf-8"></script>


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
            <li><a href="student/info">个人考研信息</a></li>
            <li><a href="student/policy" >调剂信息功能</a></li>
            <li><a href="student/application" >查询信息调剂</a></li>
            <li style="background: #ead2be"><a href="student/notice" >查看复试通知</a></li>
            <li><a href="student/join.do" >参加复试</a></li>
        </ul>
    </div>
    <div class="body_left">
        <table class="gridtable">
            <tr>
                <th style="width: 150px;">学校</th>
                <th style="width: 100px;">专业</th>
                <th style="width: 160px;">联系方式</th>
                <th style="width: 80px;">联系人</th>
                <th style="width: 160px;">邮箱</th>
                <th style="width: 70px;">备注</th>
                <th >是否参加复试</th>
            </tr>
            <c:forEach items="${maps}" var="data">
                <tr class="pageContent">
                    <td>${data['schoolName']}</td>
                    <td>${data['subName']}</td>
                    <td>${data['tel']} </td>
                    <td>${data['contacts']}</td>
                    <td>${data['email']}</td>
                    <td></td>
                    <td><input type="button" id="join" value="参加">&nbsp;&nbsp;<input id="cancel" type="button" value="不参加"></td>
                </tr>
            </c:forEach>
        </table>
        <div class="page">
            <ul class="page_ul">
                <c:if test="${page.currentPage!=1}">
                    <li class="page_li"><a>上一页</a></li>
                </c:if>
                <c:forEach begin="1" end="${page.totalPage}" var="p">
                    <c:choose>
                        <c:when test="${p==1}">
                            <li class="page_li "><a class="page_ch fta">${p}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="page_li"><a class="page_ch">${p}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${page.currentPage>0 and page.currentPage<page.totalPage}">
                    <li class="page_li"><a>下一页</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</div>


</body>
</html>
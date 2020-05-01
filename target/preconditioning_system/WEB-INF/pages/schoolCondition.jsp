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
    <title>查看考生复试情况</title>
    <base href="<%=basePath %>"/>
    <c:set var="pac" value="${pageContext.request.contextPath}" scope="request"/>

    <link rel="stylesheet" type="text/css" href="${pac}/css/taowa.css" />
    <link rel="stylesheet" type="text/css" href="${pac}/css/sch-view-success.css" />
    <link rel="shortcut icon"  href="${pac}/css/favicon.ico"/>
    <script src="${pac}/js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
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
            <li style="background: #ead2be"><a href="school/condition.do">考生复试情况</a></li>
        </ul>
    </div>
    <div class="body_left">
        <table class="gridtable">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="150">
                <col width="150">
                <col width="150">
                <col width="80">
                <col width="160">
            </colgroup>
            <thead>
            <tr>
                <th>姓名</th>
                <th>准考号</th>
                <th>本科院校 </th>
                <th>本科专业</th>
                <th>录取专业</th>
                <th>总分</th>
                <th>备注</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${studentList}" var="record">
            <tr>
                <td>${record.sname}</td>
                <td>${record.examId}</td>
                <td>${record.fromSchool}</td>
                <td>${record.fromSubject}</td>
                <td>${record.toSubject}</td>
                <td>${record.total}</td>
                <td>尽快与该学生取得联系</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

</div>




</body>
</html>

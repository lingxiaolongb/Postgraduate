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
    <meta charset="utf-8" />
    <title>高校信息筛选界面</title>
    <c:set var="pac" value="${pageContext.request.contextPath}" scope="request"/>
    <link rel="stylesheet" type="text/css" href="${pac}/css/taowagai.css" />
    <link rel="stylesheet" type="text/css" href="${pac}/css/sch_choose.css" />
    <link rel="stylesheet" type="text/css" href="${pac}/layui/css/layui.css"/>
    <link rel="shortcut icon"  href="${pac}/css/favicon.ico"/>
    <script src="${pac}/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/js/sch-choose.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/layui/layui.js" type="text/javascript" charset="utf-8"></script>

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
        <p class="title">信息验证</p>

        <div class="top_dom"></div>
        <div class="items">

            <span class="item_el">本科院校:</span>
            <input id="fromSchool" class="info_sr_left" />

            <span class="item_el">本科专业:</span>
            <input id="fromSubject" class="info_sr_right" />

            <button id="find_sub" class="info_sub">
                <span>查询</span>
            </button>

        </div>

        <div class="items">

            <span class="item_el">报考专业:</span>
            <input class="info_sr_left" id="toSubject" />

            <span class="item_el">总分数:</span>
            <input class="info_sr_right" id="total" />

        </div>
        <div class="items">

            <span class="item_el">政治分数:</span>
            <input class="info_sr_left" id="politics" />

            <span class="item_el">英语分数:</span>
            <input class="info_sr_right" id="english" />

        </div>

        <div class="items">

            <span class="item_el">专业课1分数:</span>
            <input class="info_sr_left" id="math" />

            <span class="item_el">专业课2分数:</span>
            <input class="info_sr_right" id="specialized" />

        </div>
        <div class="top_dom"></div>

        <div class="body_left">
            <table class="gridtable">
                <tr>
                    <th>姓名</th>
                    <th>准考号</th>
                    <th>本科院校</th>
                    <th>本科专业</th>
                    <th>报考专业</th>
                    <th>总分数</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${studentList}" var="student">
                    <tr class="stu-info">
                        <td>${student.sname}</td>
                        <td>${student.examId}</td>
                        <td>${student.fromSchool}</td>
                        <td>${student.fromSubject}</td>
                        <td>${student.toSubject}</td>
                        <td>${student.total}</td>
                        <td><button class="participate">发送通知</button></td>
                    </tr>
                </c:forEach>


            </table>
            <div class="page">
                <ul class="page_ul">
                    <c:if test="${page.currentPage!=1}">
                        <li class="page_li"><a >上一页</a></li>
                    </c:if>
                    <c:forEach begin="1" end="${page.totalPage}" var="p">
                        <c:choose>
                            <c:when test="${p==1}">
                                <li class="page_li "><a class="page_ch ffa">${p}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="page_li"><a class="page_ch">${p}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${page.currentPage!=page.totalPage}">
                        <li class="page_li"><a>下一页</a></li>
                    </c:if>


                </ul>
            </div>
        </div>




    </div>

</div>


</body>
</html>

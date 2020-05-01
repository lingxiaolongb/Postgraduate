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
    <title>高校发送复试通知界面</title>
    <base href="<%=basePath %>"/>
    <c:set var="pac" value="${pageContext.request.contextPath}" scope="request"/>
    <link rel="shortcut icon"  href="${pac}/css/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="${pac}/css/taowa.css" />
    <link rel="stylesheet" type="text/css" href="${pac}/css/sch-notice.css" />
    <link rel="stylesheet" type="text/css" href="${pac}/layui/css/layui.css"/>
    <script src="${pac}/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/js/sendNotice.js" type="text/javascript" charset="utf-8"></script>
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


    <div class="con_right">
        <div class="items">
            <ul class="nav">
                <li class="show1 fa"><a>待发送</a></li>
                <li class="show2"><a>已发送</a></li>
            </ul>
        </div>
        <div class="body_left" id="info-one" >
            <table class="gridtable">

                <colgroup>
                    <col width="100">
                    <col width="150">
                    <col width="180">
                    <col width="180">
                    <col width="150">
                    <col width="250">
                </colgroup>
                <tr>
                    <th>姓名</th>
                    <th>准考号</th>
                    <th>本科院校</th>
                    <th>本科专业</th>
                    <th>总分数</th>
                    <th style="width: 200px">操作</th>
                </tr>
                <c:if test="${empty ssm1 }">
                    <tr class="record">
                        <td>暂无</td>
                        <td>暂无</td>
                        <td>暂无</td>
                        <td>暂无</td>
                        <td>暂无</td>
                        <td>暂无</td>
                    </tr>
                </c:if>
                <c:forEach items="${ssm1}" var="msg">
                    <tr class="record">
                        <td>${msg.sname}</td>
                        <td>${msg.examId}</td>
                        <td>${msg.fromSchool}</td>
                        <td>${msg.fromSubject}</td>
                        <td>${msg.total}</td>
                        <td><button id="send" class="participate">发送</button>&nbsp;&nbsp;<button id="deny" class="participate">拒绝</button></td>
                    </tr>
                </c:forEach>
            </table>
            <div class="page" id="page1">
                <ul class="page_ul">
                    <c:if test="${page1.currentPage!=1}">
                        <li class="page_li"><a >上一页</a></li>
                    </c:if>
                    <c:forEach begin="1" end="${page1.totalPage}" var="p">
                        <c:choose>
                            <c:when test="${p==1}">
                                <li class="page_li "><a class="page_ch ffa">${p}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="page_li"><a class="page_ch">${p}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${page1.currentPage>0 and page1.currentPage<page1.totalPage}">
                        <li class="page_li"><a>下一页</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
        <div class="body_left" id="info-two" style="display: none;" >
            <table class="gridtable">
                <colgroup>
                    <col width="100">
                    <col width="150">
                    <col width="180">
                    <col width="180">
                    <col width="150">
                    <col width="180">
                </colgroup>
                <tr>
                    <th>姓名</th>
                    <th>准考号</th>
                    <th>本科院校</th>
                    <th>本科专业</th>
                    <th>总分数</th>
                    <th>操作</th>
                </tr>
                <c:if test="${empty ssm2 }">
                    <tr class="record">
                        <td>暂无</td>
                        <td>暂无</td>
                        <td>暂无</td>
                        <td>暂无</td>
                        <td>暂无</td>
                        <td>暂无</td>
                    </tr>
                </c:if>
                <c:forEach items="${ssm2}" var="msg">
                    <tr class="record">
                        <td>${msg.sname}</td>
                        <td>${msg.examId}</td>
                        <td>${msg.fromSchool}</td>
                        <td>${msg.fromSubject}</td>
                        <td>${msg.total}</td>
                        <td>消息已送达</td>
                    </tr>
                </c:forEach>
            </table>

            <div class="page" id="page2">
                <ul class="page_ul">
                    <c:if test="${page2.currentPage!=1}">
                        <li class="page_li"><a>上一页</a></li>
                    </c:if>
                    <c:forEach begin="1" end="${page2.totalPage}" var="p">
                        <c:choose>
                            <c:when test="${p==1}">
                                <li class="page_li "><a class="page_ch ffa">${p}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="page_li"><a class="page_ch">${p}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${page2.currentPage>0 and page2.currentPage<page2.totalPage}">
                        <li class="page_li"><a>下一页</a></li>
                    </c:if>
                </ul>
            </div>
        </div>

    </div>






</div>


</body>
</html>

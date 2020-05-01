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
    <title>预调剂申请</title>
    <base href="<%=basePath %>" />
    <c:set var="pac" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" type="text/css" href="${pac}/css/taowa.css" />
    <link rel="stylesheet" type="text/css" href="${pac}/css/chosen.css"/>
    <link rel="stylesheet" type="text/css" href="${pac}/css/finds.css"/>
    <link rel="stylesheet" type="text/css" href="${pac}/layer/theme/default/layer.css">
    <script src="${pac}/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/js/chosen.jquery.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/js/chosen.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/js/applicationed.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pac}/layer/layer.js" type="text/javascript" charset="utf-8"></script>

    <script type="text/javascript" charset="utf-8">
      $(function () {
          if(${disable=="true"}){
              $(".info_sub").prop("disabled","false");
              $(".info_sub").css({
                  "background":"#ababab",
                  "cursor":"default"
              });
              $(".info_sub span").text("已提交申请");
          }
      });
    </script>

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
            <li style="background: #ead2be"><a href="student/application" >查询信息调剂</a></li>
            <li><a href="student/notice" >查看复试通知</a></li>
            <li><a href="student/join.do" >参加复试</a></li>
        </ul>
    </div>
    <div class="con_right">
        <div class="body_top">
            <input class="put" id="findSub" type="text" placeholder="按专业查询" />
            <input class="put" id="findSch" type="text" placeholder="按高校查询" />
            <button class="btn" id="select"><span>查询</span></button>
            <button class="btn" id="reSet"><span>重置</span></button>
        </div>
        <div class="body_main">
            <div class="body_left">
                <table class="gridtable">
                    <tr>
                        <th style="width: 130px;">专业</th>
                        <th>专业代码</th>
                        <th style="width: 140px;">招生单位</th>
                        <th>缺额人数</th>
                    </tr>
                    <c:forEach items="${schoolList}" var="msg">
                        <tr class="pageContent">
                            <td>${msg["subName"]}</td>
                            <td>${msg["examId"]}</td>
                            <td>${msg["schName"]}</td>
                            <td>${msg["lack"]}</td>
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
                        <c:if test="${page.currentPage>0 and page.currentPage<page.totalPage}">
                            <li class="page_li"><a>下一页</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
            <div class="body_right">

                <h2>调剂报名</h2>
                <div class="selects">
                    <span>志愿一:${app.application1}</span>
                    <c:if test="${!empty schoolNames}">
                    <select class='chosen' id="chosen-1" data-placeholder='请选择志愿1'  >
                        <option value="" hassubinfo="true" >请选择志愿</option>
                        <c:forEach items="${schoolNames}" var="name">
                            <option value="${name}">${name}</option>
                        </c:forEach>
                    </select>
                    </c:if>
                </div>
                <div class="selects"   >
                    <span>志愿二:${app.application2}</span>
                    <c:if test="${!empty schoolNames}">
                        <select class='chosen' id="chosen-1" data-placeholder='请选择志愿1'>
                            <option value="" hassubinfo="true" >请选择志愿</option>
                            <c:forEach items="${schoolNames}" var="name">
                                <option value="${name}">${name}</option>
                            </c:forEach>
                        </select>
                    </c:if>
                </div>
                <div class="selects"   >
                    <span>志愿三:${app.application3}</span>
                    <c:if test="${!empty schoolNames}">
                        <select class='chosen' id="chosen-1" data-placeholder='请选择志愿1'>
                            <option value="" hassubinfo="true" >请选择志愿</option>
                            <c:forEach items="${schoolNames}" var="name">
                                <option value="${name}">${name}</option>
                            </c:forEach>
                        </select>
                    </c:if>
                </div>
                <div class="selects"  >
                    <span>志愿四:${app.application4}</span>
                    <c:if test="${!empty schoolNames}">
                        <select class='chosen' id="chosen-1" data-placeholder='请选择志愿1'>
                            <option value="" hassubinfo="true" >请选择志愿</option>
                            <c:forEach items="${schoolNames}" var="name">
                                <option value="${name}">${name}</option>
                            </c:forEach>
                        </select>
                    </c:if>
                </div>
                <button class="info_sub">
                    <span>同意</span>
                </button>
            </div>
        </div>

    </div>
</div>
</body>
</html>

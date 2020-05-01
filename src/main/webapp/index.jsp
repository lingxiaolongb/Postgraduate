<%--
  Created by IntelliJ IDEA.
  User: ling
  Date: 2020/2/19
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>欢迎来到考研预调剂系统</title>
    <link rel="shortcut icon"  href="css/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <link rel="stylesheet" type="text/css" href="css/switch.css"/>
    <link rel="stylesheet" type="text/css" href="css/stu.css"/>

    <script src="js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/index.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/reDialog.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/stu_sch.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>

<div id="calei"></div>
<div class="main">
    <div class="nav">
        <img class="i_img" src="img/icon.jpg"/>
        <h1 class="title">考研预调剂系统</h1>
    </div>

        <i class="icon-user"></i>
        <input type="text" placeholder="用户名" id="i_user" class="sm" autocomplete="off" /><br />
        <i class="icon-pwd"></i>

        <input type="password" placeholder="密码" id="i_pwd" class="sm"  autocomplete="off"/>
        <div class="mc">

        </div>
        <div class="single">
            <input type="radio" name="url" value="Student" class="rm" checked />Student
            <input type="radio" name="url" value="School" class="rm" />School
            <input type="radio" name="url" value="Admin" class="rm" />Admin
        </div>


        <input type="button" value="考生注册"  class="btn" id="stu_register" />
        <input type="button" value="高校注册"  class="btn" id="sch_register"  />


        <br />
        <input type="submit" id="index_btn" value="登录" class="btn and" />

    <form id="userFrom"  type="post" style="display: none">

    </form>


</div>

</body>
</html>


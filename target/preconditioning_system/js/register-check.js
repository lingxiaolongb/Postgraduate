$(function() {



    var len;

    $("#calei").on("focus","#stu_loginName",function(){

        $("#stu_loginName").removeClass("ipt_wr");
        $("#wr_mes_name").remove();
        $("#stu_loginName").after("<p class='wr_mes' id='wr_mes_name'>用户名可以包含中文、英文、数字、下划线、4-18个字符</p>");

    });

    $("#calei").on("focus","#stu_password",function(){

        $("#stu_password").removeClass("ipt_wr");
        $("#wr_mes_pwd").remove();
        $("#stu_password").after("<p class='wr_mes' id='wr_mes_pwd'>6~16个字符，区分大小写</p>");

    });


    $("#calei").on("focus","#stu_re_password",function(){
        $("#stu_re_password").removeClass("ipt_wr");
        $("#wr_mes_re_pwd").remove();
        $("#stu_re_password").after(`<p class="wr_mes" id="wr_mes_re_pwd">请再次填写密码</p>`);

    });


    $("#calei").on("focus","#stu_uno",function(){
        $("#stu_uno").removeClass("ipt_wr");
        $("#wr_mes_uno").remove();
        $("#stu_uno").after(`<p class="wr_mes" id="wr_mes_uno">请输入准考证号</p>`);

    });


    $("#calei").on("focus","#stu_uname",function(){
        $("#stu_uname").removeClass("ipt_wr");
        $("#wr_mes_uname").remove();
        $("#stu_uname").after(`<p class="wr_mes" id="wr_mes_uname">请填写你的姓名</p>`);

    });


    $("#calei").on("focus","#stu_uphone",function(){
        $("#stu_uphone").removeClass("ipt_wr");
        $("#wr_mes_uphone").remove();
        $("#stu_uphone").after(`<p class="wr_mes" id="wr_mes_uphone">请输入手机号码</p>`);
    });


    $("#calei").on("focus","#stu_email",function(){
        $("#stu_email").removeClass("ipt_wr");
        $("#wr_mes_email").remove();
        $("#domain").after(`<p class="wr_mes" id="wr_mes_email">请输入的邮箱账号</p>`);
    });







    $("#calei").on("blur","#stu_loginName",function(){

        var sname = $.trim($(this).val());
        var flag=0;
        if (sname == null || sname == "") {
            return;
        }
        chkUsername(sname);

    });

    $("#calei").on("blur","#stu_password",function(){

        var spwd = $(this).val();
        var flag=0;

        if (spwd == null || spwd == "") {
            return;
        }
        len=testPwdStr(spwd);
        checkPassword(spwd,len);

    });

    $("#calei").on("blur","#stu_re_password",function(){

        var valued =  $(this).val();
        var spwd=$("#stu_password").val();
        if (valued == null || valued == "") {
            return;
        }

        checkRePwd(spwd,valued);


    });

    $("#calei").on("blur","#stu_uno",function(){

        var valued = $.trim($(this).val());
        if (valued == null || valued == "") {
            return;
        }
        checkUno(valued);


    });

    $("#calei").on("blur","#stu_uphone",function(){

        var valued = $.trim($(this).val());
        if (valued == null || valued == "") {
            return;
        }
        checkPhone(valued);


    });
    $("#calei").on("blur","#stu_email",function(){

        var valued = $.trim($(this).val());
        if (valued == null || valued == "") {
            return;
        }

        checkEmail(valued);


    });


    $("#calei").on("blur","#stu_uname",function(){

        var valued = $.trim($(this).val());
        if (valued == null || valued == "") {
            return;
        }

        checkUname(valued);

    });



    //检查账户
    function chkUsername(name) {

        var str = new Array();
        str[0] = 0;


        if (name == null || name == "") {
            str[0] = 1
            str[1] = "账户未填写";
        } else if (name.length < 4 || name.length > 18) {
            //合法长度为4-18个字符
            str[1] = "合法长度应为4-18个字符";
            str[0] = 1
        } else if (!/^[\u4E00-\u9FA5\uf900-\ufa2d\w]{4,18}$/.test(name)) {
            str[1] = "用户名只能包含中文、英文、数字、下划线、4-18个字符";
            str[0] = 1
        } else if (!/^[a-zA-Z\u4e00-\u9fa5][a-zA-Z0-9\u4e00-\u9fa5]*$/.test(name)) {
            str[1] = "用户名只能英文字母和中文开头";
            str[0] = 1
        }else{
            $.ajax({
                data:{"name":name},
                url:"http://localhost:8283/web/user/check",
                async:false,
                success:function (msg) {
                    if(msg=="falsed"){
                        str[1] = "用户名已存在";
                        str[0] = 1
                    }

                },error:function () {

                    return "出错"
                }

            });

        }


        if (str[0] == 1) {
            $("#stu_loginName").addClass("ipt_wr");
            $("#wr_mes_name").remove();
            $("#stu_loginName").after(`
			<p class='wr_mes_red' id='wr_mes_name'><b class="warn_icon"></b>${str[1]}</p>`);
            return 0;
        }else {

            $("#stu_loginName").removeClass("ipt_wr");
            $("#wr_mes_name").remove();
            $("#stu_loginName").after(`
			<p class='wr_mes' id='wr_mes_name'><b class="correct_icon"></b>恭喜可以使用</p>`);
        }

        return 1;
    }

    //检查密码
    function checkPassword(pwd,len) {

        var str = new Array();
        str[0] = 0;
        if (pwd == null || pwd == "") {
            str[0] = 1
            str[1] = "密码未填写";
        } else if (pwd.length < 6 || pwd.length > 16) {
            str[1] = "合法长度应为6-16个字符";
            str[0] = 1
        }
        if (str[0] == 1) {
            $("#stu_password").addClass("ipt_wr");
            $("#wr_mes_pwd").remove();
            $("#stu_password").after(`
				<p class='wr_mes_red' id='wr_mes_pwd'><b class="warn_icon"></b>${str[1]}</p>`);
            return 0;
        }else{
            $("#stu_password").removeClass("ipt_wr");
            $("#wr_mes_pwd").remove();
            $("#stu_password").after(`
				<p class='wr_mes' id='wr_mes_pwd'><b class="correct_icon"></b>密码强度:${len}</p>`);
        }

        return 1;
    }

    //准考证号
    function checkUno(uno) {
        var str = new Array();
        str[0] = 0;
        if (uno == null || uno == "") {
            str[0] = 1
            str[1] = "请输入准考证号";
        } else if (!/^[0-9]+.?[0-9]*$/.test(uno)) {
            str[0] = 1
            str[1] = "考号应为数字";
        } else if (uno.length < 4 || uno.length > 15) {
            str[1] = "合法长度应为4-15个字符";
            str[0] = 1
        }
        if (str[0] == 1) {
            $("#stu_uno").addClass("ipt_wr");
            $("#wr_mes_uno").remove();
            $("#stu_uno").after(`
			<p class='wr_mes_red' id='wr_mes_uno'><b class="warn_icon"></b>${str[1]}</p>`);
            return 0;
        }else{
            $("#stu_uno").removeClass("ipt_wr");
            $("#wr_mes_uno").remove();
            $("#stu_uno").after(`
			<p class='wr_mes' id='wr_mes_uno'><b class="correct_icon"></b></p>`);
        }

        return 1;
    }


    //检测姓名不为空
    function checkUname(uname){
        var str = new Array();
        str[0] = 0;
        if (uname == null || uname == "") {
            str[0] = 1
            str[1] = "请输入姓名";
        }
        if (str[0] == 1) {
            $("#stu_uname").addClass("ipt_wr");
            $("#wr_mes_uname").remove();
            $("#stu_uname").after(`
					<p class='wr_mes_red' id='wr_mes_uname'><b class="warn_icon"></b>${str[1]}</p>`);
            return 0;
        }else{
            $("#stu_uname").removeClass("ipt_wr");
            $("#wr_mes_uname").remove();
            $("#stu_uname").after(`
					<span class='wr_mes' id='wr_mes_uname'><b class="correct_icon"></b></span>`);
        }
        return 1;
    }

    //检测手机号码
    function checkPhone(phone) {
        var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;
        var str = new Array();
        str[0] = 0;
        if (phone == null || phone == "") {
            str[0] = 1
            str[1] = "手机号码不能为空";
        } else if (phone.length != 11) {
            str[0] = 1
            str[1] = "手机号码为11位";
        } else if (!myreg.test(phone)) {
            str[1] = "请输入有效的手机号码";
            str[0] = 1
        }

        if (str[0] == 1) {
            $("#stu_uphone").addClass("ipt_wr");
            $("#wr_mes_uphone").remove();
            $("#stu_uphone").after(`
			<p class='wr_mes_red' id='wr_mes_uphone'><b class="warn_icon"></b>${str[1]}</p>`);
            return 0;
        }else{
            $("#stu_uphone").removeClass("ipt_wr");
            $("#wr_mes_uphone").remove();
            $("#stu_uphone").after(`
			<p class='wr_mes' id='wr_mes_uphone'><b class="correct_icon"></b></p>`);
        }

        return 1;
    }



    //检测邮箱
    function checkEmail(email) {

        var str = new Array();
        str[0] = 0;
        if (email == null || email == "") {
            str[0] = 1
            str[1] = "邮箱不能为空";
        }
        if (str[0] == 1) {
            $("#stu_email").addClass("ipt_wr");
            $("#wr_mes_email").remove();
            $("#domain").after(`
					<p class='wr_mes_red' id='wr_mes_email'><b class="warn_icon"></b>${str[1]}</p>`);
            return 0;
        }else{
            $("#stu_email").removeClass("ipt_wr");
            $("#wr_mes_email").remove();
            $("#domain").after(`
					<p class='wr_mes' id='wr_mes_email'><b class="correct_icon"></b></p>`);
        }
        return 1;
    }

    //检测密码是否重复
    function checkRePwd(pwd, rePwd) {

        var str = new Array();
        str[0] = 0;

        if (rePwd == null || rePwd == "") {
            str[0] = 1
            str[1] = "请再次填写密码";
        } else if (pwd != rePwd) {
            str[0] = 1
            str[1] = "两次输入密码不一样";
        }

        if (str[0] == 1) {
            $("#stu_re_password").addClass("ipt_wr");
            $("#wr_mes_re_pwd").remove();
            $("#stu_re_password").after(`
			<p class='wr_mes_red' id='wr_mes_re_pwd'><b class="warn_icon"></b>${str[1]}</p>`);
            return 0;
        }else{
            $("#stu_re_password").removeClass("ipt_wr");
            $("#wr_mes_re_pwd").remove();
            $("#stu_re_password").after(`
			<p class='wr_mes' id='wr_mes_re_pwd'><b class="correct_icon"></b></p>`);

        }


        return 1;
    }



    $("#calei").on("click","#stu_btn",function() {

        var test=0;
        var sname = $.trim($("#stu_loginName").val());
        test = chkUsername(sname);
        if(test==0){return false;}

        var spwd = $("#stu_password").val();
        test += checkPassword(spwd,len);
        if(test==1){return false;}

        var sre_pwd = $("#stu_re_password").val();
        test += checkRePwd(spwd, sre_pwd);
        if(test==2){return false;}

        var suno = $.trim($("#stu_uno").val());
        test += checkUno(suno);
        if(test==3){return false;}

        var suname = $.trim($("#stu_uname").val());
        test += checkUname(suname);
        if(test==4){return false;}

        var sphone = $.trim($("#stu_uphone").val());
        test += checkPhone(sphone);
        if(test==5){return false;}

        var semail = $.trim($("#stu_email").val());
        test += checkEmail(semail);
        if(test==6){return false;}

        var sremark = $.trim($("#stu_remark").val());




        var role=$("#role").val();
        var url="http://localhost:8283/web/user/save?role="+role;
        $.ajax({
            url:url,
            data:{
                "loginName":sname,
                "password":spwd,
                "uno":suno,
                "uname":suname,
                "email":semail,
                "uphone":sphone,
                "loginFlag":"0",
                "remarks":sremark } ,
            success:function ( data) {
                if(data=="trued"){
                    alert("成功");
                }else{
                    alert("失败");
                }
            },
            type:"post"

        });




        return true;

    });



    function testPwdStr(spwd) {
        var sname = $.trim($("#stu_loginName").val());

        var score = 0;


        score += spwd.length * 4;


        if (spwd.match(/(.*[0-9].*[0-9].*[0-9])/)) {
            score += 5;
        }
        //password has 2 symbols
        if (spwd.match(/(.*[!,@,#,$,%,^,&,*,?,_,~].*[!,@,#,$,%,^,&,*,?,_,~])/)) {
            score += 5;
        }
        //password has Upper and Lower chars
        if (spwd.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/)) {
            score += 10;
        }
        //password has number and chars
        if (spwd.match(/([a-zA-Z])/) && spwd.match(/([0-9])/)) {
            score += 15;
        }
        //
        //password has number and symbol
        if (spwd.match(/([!,@,#,$,%,^,&,*,?,_,~])/) && spwd.match(/([0-9])/)) {
            score += 15;
        }
        //password has char and symbol
        if (spwd.match(/([!,@,#,$,%,^,&,*,?,_,~])/) && spwd.match(/([a-zA-Z])/)) {
            score += 15;
        }
        //password is just a numbers or chars
        if (spwd.match(/^\w+$/) || spwd.match(/^\d+$/)) {
            score -= 10;
        }

        if (score < 0) {
            score = 0;
        }
        if (score > 100) {
            score = 100;
        }
        if (score < 34) {

            return "弱";
        }
        if (score < 68) {
            return "中等"
        }
        return "强";
    }


});

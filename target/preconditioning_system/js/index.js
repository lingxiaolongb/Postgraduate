$(function() {

    $("#index_btn").click(function() {
        var user = $("#i_user").val();
        var pwd = $("#i_pwd").val();


        if (user == null || user == "") {
            $("#i_user").addClass("rb");
            var $pp = $("<span class='meszh'>请输入账户</span>");
            if ($(".meszh").length > 0) {
                $(".meszh").remove();
                $(".mc").append($pp);
            } else {
                $(".mespwd").remove();
                $(".mc").append($pp);
            }
            return false;
        }

        if (pwd == null || pwd == "") {
            $("#i_pwd").addClass("rb");
            var $pp = $("<span class='mespwd'>请输入密码</span>");
            if ($(".mespwd").length > 0) {
                $(".mespwd").remove();
                $(".mc").append($pp);
            } else {
                $(".meszh").remove();
                $(".mc").append($pp);
            }
            return false;
        }
        var role =$('input:radio[name="url"]:checked').val().toLowerCase();
        var url="user/verify";

        $.ajax({url:url,
            type:"post",
            data:{
                "name":user,
                "pwd":pwd,
                "role":role
            },
            success:function (data) {
                console.log(data);
                if(data.flag=="trued"){
                    url=role+"/info";
                    $("#userFrom").attr("action",url);
                    $("#userFrom").submit();
                }else{
                    var $pp = $(`<span class='mespwd'>${data.msg}</span>`);
                    if ($(".mespwd").length > 0) {
                        $(".mespwd").remove();
                        $(".mc").append($pp);
                    } else {
                        $(".meszh").remove();
                        $(".mc").append($pp);
                    }

                }
            }

        });


        return false;
    });


    $("#i_user").click(function() {
        $(".meszh").remove();
    });
    $("#i_pwd").click(function() {
        $(".mespwd").remove();
    });

    $("#i_user").blur(function() {
        $(this).removeClass("rb");
    });

    $("#i_pwd").blur(function() {
        $(this).removeClass("rb");
    });


});
$(function () {
    $(".info_sub").click(function(){

        var contacts=$.trim($("#contacts").val());
        var telephone=$.trim($("#telephone").val());
        var email =$.trim($("#email").val());
        var id=$.trim($("#schoolId").val());
        var schoolName=$.trim($("#schoolName").val());




        $.ajax({
            url:"school/save",
            data:{
                "contacts":contacts,
                "tel":telephone,
                "schollId":id,
                "email":email,
                "schollName":schoolName
            },
            success:function () {
                $diaglog=createDialog();
                $(".dialog-wrap").append($diaglog);
            }
        });


    });

});


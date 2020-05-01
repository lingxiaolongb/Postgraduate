$(function () {
    $(".info_sub").click(function () {
        var name= $.trim($("#name").val());
        var exam_id= $.trim($("#exam_id").val());
        var f_school= $.trim($("#f_school").val());
        var f_subject= $.trim($("#f_subject").val());
        var t_school= $.trim($("#t_school").val());
        var t_subject= $.trim($("#t_subject").val());
        var total= $.trim($("#total").val());
        var policy= $.trim($("#policy").val());
        var english= $.trim($("#english").val());
        var math= $.trim($("#math").val());
        var specialized= $.trim($("#specialized").val());
        var url="student/save";
        var data={
          "sname":name,
            "examId":exam_id,
            "fromSchool":f_school,
            "fromSubject":f_subject,
            "toSchool":t_school,
            "toSubject":t_subject,
            "total":total,
            "politics":policy,
            "english":english,
            "math":math,
            "specialized":specialized,
        };
        $.ajax({
            url:url,
            data:data,
            success:function ( data) {
                if(data=="trued"){
                    $diaglog=createDialog();
                    $(".dialog-wrap").append($diaglog);
                }else{
                    alert("失败");
                }
            },
            type:"post"
        });

        $("#math").blur(function(){

            autoScore();
        })
        $("#policy").blur(function(){
            autoScore();
        })
        $("#english").blur(function(){
            autoScore();
        })
        $("#specialized").blur(function(){
            autoScore();
        })




    });

});

function autoScore(){
    var politics=$.trim($("#policy").val());
    var math=$.trim($("#math").val());
    var english=$.trim($("#english").val());
    var specialized=$.trim($("#specialized").val());
    console.log(math);
    if(politics==null || math==null || english==null || specialized==null ||
        math=="" || english==""|| specialized==""|| politics==""){
        return;
    }
    var result=parseInt(politics)+parseInt(math)+parseInt(english)+parseInt(specialized);
    $("#total").val(""+result);


}
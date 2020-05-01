$(function(){




    $(".page_ul").on("click",".page_ch",function () {
        var currentPage=parseInt($(this).text());
        pageAction(currentPage);
    });

    $(".gridtable").on("click",".participate",function () {
        var name=$(this).parents("tr").children("td").eq(0).text();
        var examId=$(this).parents("tr").children("td").eq(1).text();
        var specialized=$(this).parents("tr").children("td").eq(4).text();
        createDialog(name, examId, specialized);

    });

    layui.use('form', function() {
        var form = layui.form;
        form.render();
    });

    $("#find_sub").click(function () {
        pageAction(1);
    });


});

function pageAction(page) {

    var fromSchool=$.trim($("#fromSchool").val());
    var fromSubject=$.trim($("#fromSubject").val());
    var toSubject=$.trim($("#toSubject").val());
    var total=$.trim($("#total").val());
    var politics=$.trim($("#politics").val());
    var english=$.trim($("#english").val());
    var math=$.trim($("#math").val());
    var specialized=$.trim($("#specialized").val())

    $.ajax({
        url:"school/choose.do" ,
        data:{
            "fromSchool":fromSchool,
            "fromSubject":fromSubject,
            "toSubject":toSubject,
            "total":total,
            "politics":politics,
            "english":english,
            "math":math,
            "specialized":specialized,
            "currentPage":page
        },
        success:function (data) {
            var studentList=data.studentInfos;
            $(".stu-info").remove();
            $(".page_li").remove();

            for (let i=0; i < studentList.length; i++) {
                var $student = $(`
                    <tr class="stu-info">
                        <td>${studentList[i].sname}</td>
                        <td>${studentList[i].examId}</td>
                        <td>${studentList[i].fromSchool}</td>
                        <td>${studentList[i].fromSubject}</td>
                        <td>${studentList[i].toSubject}</td>
                        <td>${studentList[i].total}</td>
                        <td><button class="participate">发送通知</button></td>
                    </tr>`);

                $(".gridtable").append($student);
            }
            var page=data.page;

            if(page.currentPage!=1){
                $(".page_ul").append(`<li class="page_li"><a onclick="pageAction(${page.currentPage-1})" >上一页</a></li>`);
            }

            for(var i=1;i<page.totalPage+1;i++){
                var $node;
                if(i==page.currentPage){
                    $node=$(`<li class="page_li"><a class="page_ch ffa">${i}</a></li>`);
                }else{
                    $node=$(`<li class="page_li"><a class="page_ch">${i}</a></li>`);
                }
                $(".page_ul").append($node);
            }
            if(page.currentPage<page.totalPage && page.currentPage>0){
                $(".page_ul").append(`<li class="page_li" onclick="pageAction(${page.currentPage+1})"><a>下一页</a></li>`);
            }

        },
    });


}
$(document).keydown(function (event) {
    if(event.keyCode==13){
        $("#find_sub").trigger("click");
    }
});



function createDialog(name, examId, specialized) {

    var str =
        `<div class="layui-form-item top">
		<label class="layui-form-label">姓名:</label>
		<div class="layui-inline">
		<input type="text" disabled  class="layui-input" value="${name}">
		</div>
		</br>
		</br>
		<label class="layui-form-label">准考号:</label>
		<div class="layui-inline">
			<input type="text" disabled  id="stuId" class="layui-input" value="${examId}">
		</div>
		</br>
		</br>
		<label class="layui-form-label">报考专业:</label>
		<div class="layui-inline">
			<input type="text" disabled class="layui-input" value="${specialized}">
		</div>
			</br>
			</br>
			<label class="layui-form-label">录取专业:</label>`;




    createConfirm(str);

}



function createConfirm(str) {

    $.ajax({
        url:"school/schoolSub.do",
        success:function (data) {
            var subList=data;
            str = str + `<div class="select1"><select id="subList" name="city" lay-verify="required">
					<option value="">请选择你的专业</option>`;
            for (let i = 0; i < subList.length; i++) {
                var temp = `<option value="0">${subList[i]}</option>`;
                str = str + temp;
            }
            str = str + `</select></div></div>`;
            var index = top.layer.open({
                type: 1,
                title: "录取专业",
                skin: 'layui-layer-rim', //加上边框
                area: ['400px', '400px'], //宽高
                btn: ['录取', '取消'],
                yes: function () {
                    var sub=$("#subList option:selected").text();
                    if(sub==""){
                        layer.msg('请选择录取专业', {
                            icon: 2
                        });
                    }else{
                       var index2= layer.confirm('确定给这位同学发送复试通知吗？', {
                            btn: ['确定', '取消'] //按钮
                        }, function () {
                           layer.close(index);
                           layer.close(index2);
                            $.ajax({
                                url:"school//accept.do",
                                data:{
                                    "id":$("#stuId").val()
                                    ,"subName":sub

                                },
                                success:function () {
                                    layer.msg('已成功发送复试通知', {
                                        icon: 1
                                    });
                                },
                                error:function () {
                                    layer.msg('服务器出错啦', {
                                        icon: 2
                                    });
                                }
                            })

                        });
                    }//else结束

                },
                content: str

            });

        }});
}
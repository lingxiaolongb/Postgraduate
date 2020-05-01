$(function(){
	
	$(".show1").click(function(){
		$("#info-two").hide();
		$(this).addClass("fa");
		$(this).siblings().removeClass("fa");
        getUnSend(1);
		$("#info-one").show();
	});

    layui.use('form', function() {
        var form = layui.form;
        form.render();
    });


    $(".show2").click(function(){
		$("#info-one").hide();
		$(this).addClass("fa");
		$(this).siblings().removeClass("fa");
        getSend(1);
		$("#info-two").show();
	});


    $("#page1").on("click",".page_li",function () {
        var currentPage=parseInt($(this).text());
        getUnSend(currentPage);
    });

    $("#page2").on("click",".page_li",function () {
        var currentPage=parseInt($(this).text());
        getSend(currentPage);
    });

    $("#info-one").on("click","#send",function () {
        var name=$(this).parents("tr").children("td").eq(0).text();
        var examId=$(this).parents("tr").children("td").eq(1).text();
        var specialized=$(this).parents("tr").children("td").eq(4).text();
        createDialog(name, examId, specialized);
    });



    $("#info-one").on("click","#deny",function () {
        var examId=$(this).parents("tr").children("td").eq(1).text();
        denyStudent(examId);

    });

	
});

    function denyStudent(examId) {
        top.layer.confirm('确定拒绝该学生吗？', {
            btn: ['确定','再看看'] //按钮
        }, function(){
            $.ajax({
                url:"school/refuse.do",
                data:{ "id":examId},
                success:function () {
                    layer.msg('已经拒绝该消息', {icon: 1});
                }

            });
        });
    }

    function getUnSend(currentPage) {
        var url="school/notice.not";
      $.ajax({
          url:url,
          data:{
              "currentPage":currentPage
          },
          success:function (data) {
            var unSendList=data.infos;
            var page=data.page;
            $("#info-one .record").remove();
            $("#page1 .page_li").remove();
            for(let i=0;i<unSendList.length;i++){
               var $record=$(`<tr class="record">
                        <td>${unSendList[i].sname}</td>
                        <td>${unSendList[i].examId}</td>
                        <td>${unSendList[i].fromSchool}</td>
                        <td>${unSendList[i].fromSubject}</td>
                        <td>${unSendList[i].total}</td>
                        <td><button id="send" class="participate">发送</button>&nbsp;&nbsp;<button id="deny" class="participate">拒绝</button></td>
                    </tr>`);
                $("#info-one .gridtable").append($record);
            }
              if(page.currentPage!==1){
                  $("#info-one .page_ul").append(`<li class="page_li"><a onclick="pageAction(${page.currentPage-1})" >上一页</a></li>`);
              }
              for(let i=1;i<page.totalPage+1;i++){
                  var $node;
                  if(i==page.currentPage){
                      $node=$(`<li class="page_li"><a class="page_ch ffa">${i}</a></li>`);
                  }else{
                      $node=$(`<li class="page_li"><a class="page_ch">${i}</a></li>`);
                  }
                  $("#info-one .page_ul").append($node);
              }
              if(page.currentPage<page.totalPage && page.currentPage>0){
                  $("#info-one .page_ul").append(`<li class="page_li" onclick="pageAction(${page.currentPage+1})"><a>下一页</a></li>`);
              }
          },
          error:function (status) {
              alert("出错");
          }
      });
        // ajax结束
    }

    function getSend(currentPage) {
        var url="school/notice.send";
        $.ajax({
            url:url,
            data:{
                "currentPage":currentPage
            },
            success:function (data) {
                var unSendList=data.infos;
                var page=data.page;
                $("#info-two .record").remove();
                $("#page2 .page_li").remove();
                for(let i=0;i<unSendList.length;i++){
                    var $record=$(`<tr class="record">
                        <td>${unSendList[i].sname}</td>
                        <td>${unSendList[i].examId}</td>
                        <td>${unSendList[i].fromSchool}</td>
                        <td>${unSendList[i].fromSubject}</td>
                        <td>${unSendList[i].total}</td>
                        <td>消息已送达</td>
                    </tr>`);
                    $("#info-two .gridtable").append($record);
                }
                if(page.currentPage!==1){
                    $("#info-two .page_ul").append(`<li class="page_li"><a onclick="pageAction(${page.currentPage-1})" >上一页</a></li>`);
                }
                for(let i=1;i<page.totalPage+1;i++){
                    var $node;
                    if(i==page.currentPage){
                        $node=$(`<li class="page_li"><a class="page_ch ffa">${i}</a></li>`);
                    }else{
                        $node=$(`<li class="page_li"><a class="page_ch">${i}</a></li>`);
                    }
                    $("#info-two .page_ul").append($node);
                }
                if(page.currentPage<page.totalPage && page.currentPage>0){
                    $("#info-two .page_ul").append(`<li class="page_li" onclick="pageAction(${page.currentPage+1})"><a>下一页</a></li>`);
                }
            },
            error:function (status) {
                alert("出错");
            }
        });
        // ajax结束
    }


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
                                url:"school/acceptNotice.do",
                                data:{
                                    "id":$("#stuId").val()
                                    ,"subName":sub
                                },
                                success:function () {
                                    layer.msg('已发送复试邀请', {
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


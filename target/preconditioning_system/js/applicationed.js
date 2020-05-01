$(function () {




    $(".page_ul").on("click",".page_ch",function () {
        var currentPage=parseInt($(this).text());
        pageAction(currentPage);
    });


    $("#select").click(function () {
        var findSub=$.trim($("#findSub").val());
        var findSch=$.trim($("#findSch").val());
        pageAction(1);
    });

    $("#reSet").click(function () {
        $("#findSub").val("");
        $("#findSch").val("");
    });

    $(".info_sub").click(function () {

        var app1=$("#chosen-1").val();
        var app2=$("#chosen-2").val();
        var app3=$("#chosen-3").val();
        var app4=$("#chosen-4").val();
        if(app1=="" || app2=="" || app3=="" || app4==""){
            layer.alert('您的志愿申请不完整', {
                skin: 'layui-layer-lan' //样式类名
                ,closeBtn: 0,
                title:'提示'
            });
            return;
        }

        layer.confirm('提交后无法修改,你确认提交吗?', {
            btn: ['确认','取消'] //按钮
        }, function(){
            var url="student/app";
            $.ajax({
                url:url,
                data:{
                    "application1":app1,
                    "application2":app2,
                    "application3":app3,
                    "application4":app4,
                },
                type: "post",
                success:function (data) {
                    layer.msg('成功提交', {icon: 1});
                },
                error:function (data) {
                    alert("错误");
                }
            });
        });

    });


});
function pageAction(currentPage){
    var findSub=$.trim($("#findSub").val());
    var findSch=$.trim($("#findSch").val());
    var url="student/paging";
    $.ajax({
        url:url,
        data:{
            "currentPage":currentPage,
            "findSch":findSch,
            "findSub":findSub
        },
        type:"post",
        success:function (data) {
            var result=data.mapList;
            $(".pageContent").remove();
            $(".page_li").remove();
            for(var i=0 ;i<result.length;i++){
                var $node=$(`
                      <tr class="pageContent">
                            <td>${result[i].subName}</td>
                            <td>${result[i].examId}</td>
                            <td>${result[i].schName}</td>
                            <td>${result[i].lack}</td>
                        </tr>
                `);
                $(".gridtable").append($node);
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
        error:function (msg) {
            alert("出错了");
        },dataType:"json"


    });
}

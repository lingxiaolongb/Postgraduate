$(function () {

    $(".page_ul").on("click",".page_ch",function () {
        var currentPage=parseInt($(this).text());
        pageAction(currentPage);
    });

    $(".gridtable").on("click","#cancel",function () {
        var std=$(this).parent("td");
        var sch=$(this).parents("tr").children("td").eq(0).text();
        top.layer.confirm('您确定取消改高校的复试通知吗？', {
            btn: ['不用再想','我在考虑考虑'] //按钮
        }, function(){
            $.ajax({
                url:"student/refuse.do",
                data:{
                    "schName":sch
                },
                success:function () {
                    std.empty();
                    std.append("<p>已拒绝复试</p>");
                    layer.msg('的确很重要', {icon: 1});
                },error:function () {
                    layer.msg('服务器出错啦', {icon: 2});
                }
            })
        });


    });

    $(".gridtable").on("click","#join",function () {
        var std=$(this).parent("td");
        var sch=$(this).parents("tr").children("td").eq(0).text();
        top.layer.confirm('您确定参加复试吗？', {
            btn: ['确定','取消'],//按钮
            skin:"layui-layer-lan"
        }, function(){
            $.ajax({
                url:"student/accept.do",
                data:{
                   "schName":sch
                },
                success:function () {

                    std.empty();
                    std.append("<p>已参加复试</p>");
                    layer.msg('回复复试消息成功,请尽快联系导师', {
                        icon: 1,
                        btn:["确定"],
                        yes:function () {
                            layer.msg('哦！恭喜你',{
                                time:2000
                            });
                        }

                    });
                },error:function () {
                    layer.msg('服务器出错啦', {icon: 2});
                }
            })
            // s
        });


    });


});


function pageAction(currentPage){
    var url="student/noticePaging";
    $.ajax({
        url:url,
        data:{
            "currentPage":currentPage,
        },
        type:"post",
        success:function (data) {
            var result=data.mapList;
            $(".pageContent").remove();
            $(".page_li").remove();
            for(var i=0 ;i<result.length;i++){
                var $node=$(`
                  <tr class="pageContent">
                    <td>${result[i].schoolName}</td>
                    <td>${result[i].subName}</td>
                    <td>${result[i].tel}</td>
                    <td>${result[i].contacts}</td>
                    <td>${result[i].email}</td>
                    <td></td>
                    <td class="jcbtn"><input type="button" id="join" value="参加">&nbsp;&nbsp;<input  id="cancel" type="button" value="不参加"></td>
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
                    $node=$(`<li class="page_li"><a class="page_ch fta">${i}</a></li>`);
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

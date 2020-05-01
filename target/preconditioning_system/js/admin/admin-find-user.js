$(function() {


    $("#add").click(function(){
        var user=createUser();
        var op= top.layer.open({
            type: 1,
            title:'新增用户',
            skin: 'layui-layer-rim', //加上边框
            area: ['440px', '530px'], //宽高
            btn:['新增', '取消'],
            yes:function(){
                var a={
                    "loginName":$("#uLogin").val().trim(),
                    "password":$("#pwd").val().trim(),
                    "uname":$("#uName").val().trim(),
                    "uno":$("#uno").val().trim(),
                    "email":$("#uEmail").val().trim(),
                    "uphone":$("#uTel").val().trim(),
                    "rname":$("#role option:selected").val(),

                };
               $.ajax({
                   url:"admin/save.do",
                   data:a,
                   success:function () {
                       layer.msg("新增用户OK",{icon:1});
                   },error:function () {
                       layer.msg("服务器出错啦",{icon:2});
                   }
               });
                layer.close(op);
            },
            content: user
        });

    });



    $("#select").click(function() {

        tableIns.reload({
           page: {
            curr: 1
           }, where:{
                uname:$("#findSub").val().trim(),
                loginName:$("#findSch").val().trim()
            },
            method: 'post'
        });
    });

    $("#reSet").click(function() {
        $("#findSub").val("");
        $("#findSch").val("");
    });

});




layui.use(['table', 'element','jquery', 'layer'], function() {
    var element = layui.element;
    var layer = layui.layer;
    var table = layui.table;
    var  $=layui.$
   window.tableIns=table.render({
        elem: '#demo',
        url: 'admin/info.do',
        page: true,
       where:{
            uname:"",
           loginName:""
       },
        limit:7,
        limits: [2, 5, 10, 20, 30],
        method:"post",
        text: {
            none: '暂无相关数据!'
        },
        cols: [
            [{
                type: 'numbers',
                fixed: 'left',
                title: '序号'
            }, {
                field: 'uname',
                title: '姓名',
                width: 100,
                fixed: 'left',
                sort: true
            }, {
                field: 'loginName',
                title: '登录名',
                width: 120
            }, {
                field: 'uphone',
                title: '手机号码',
                width: 150,
                sort: true
            }, {
                field: 'email',
                title: '邮箱',
                width: 180,
                sort: true
            },  {
                field: 'loginFlag',
                title: '是否允许登录',
                width: 120
            } ,{
                fixed: 'right',
                title: '操作',
                toolbar: '#shenmolian',
                width: 150,
                align:"center"
            }]
        ]
    });

    table.on('tool(demo)', function(obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

        if (layEvent === 'del') { //删除
            layer.confirm('真的删除行么', function(index) {
                $.ajax({
                    url:"admin/delete.do",
                    data:{
                        "loginName":data.loginName
                    },
                    type:"post",
                    success:function() {
                        obj.del();
                        layer.close(index);
                        layer.alert("删除信息成功",{icon:1});
                    },error:function () {
                        layer.alert("服务器出错了",{icon:2});
                    }
                });

                //ajax跟新后台
            });
        } else if (layEvent === 'edit') { //编辑

            var pop=createPop(data.uname,data.loginName,data.uphone,data.email);
            var op= layer.open({
                type: 1,
                skin: 'layui-layer-rim', //加上边框
                area: ['440px', '430px'], //宽高
                btn:['保存', '取消'],
                yes:function(){
                    layer.close(op);
                    $.ajax({
                        url:"admin/update.do",
                        data:{
                            "uname":$("#name").val(),
                            "loginName":$("#loginName").val(),
                            "uphone":$("#tel").val(),
                            "email":$("#email").val(),
                            "loginFlag":$('#select1 option:selected').val(),
                            "sourceName":data.loginName
                        },
                        success:function() {
                            obj.update({
                                uname:$("#name").val(),
                                loginName:$("#loginName").val(),
                                uphone:$("#tel").val(),
                                email:$("#email").val(),
                                loginFlag:$('#select1 option:selected').text(),

                            })
                            layer.alert("更新信息成功",{icon:1});
                        },error:function () {
                            layer.alert("服务器出错了",{icon:2});
                        }
                    });

                },
                content: pop
            });

        }

    });


});

function createPop(id,name,tel,email){

    var pop=`<div class="dialog-width" style="white-space:nowrap!important;">
		<div class="layui-form-item top">
		    <label class="layui-form-label">姓名:</label>
		    <div class="layui-input-block">
		      <input type="text" name="title" lay-verify="title" id="name" value="${id}" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item top">
		      <label class="layui-form-label">登录名:</label>
		      <div class="layui-input-block">
		        <input type="text" name="title" disabled lay-verify="title" id="loginName" value="${name}" autocomplete="off" class="layui-input">
		      </div>
		    </div>
			<div class="layui-form-item top">
			    <label class="layui-form-label">手机号码:</label>
			    <div class="layui-input-block">
			      <input type="text" name="title" lay-verify="title" id="tel" value="${tel}" autocomplete="off"  class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item top">
			      <label class="layui-form-label">邮箱:</label>
			      <div class="layui-input-block">
			        <input type="text" name="title" lay-verify="title" id="email" value="${email}" autocomplete="off" class="layui-input">
			      </div>
			    </div>
			    <div class="layui-form-item top">
                    <label class="layui-form-label">是否允许登录:</label>
                    <div class="layui-input-block">
                     <select name="yorn" lay-verify="" id="select1" class="yorn" >
                        <option value="0" selected>是</option>
                        <option value="1">否</option>
                    </select>
                </div>
              </div>
			</div>`;

    return pop;
}

function createUser(){

    var userDialog=`<div class="dialog-width" >
				<div class="layui-form-item top">
			
				    <label class="layui-form-label">姓名:</label>
				    <div class="layui-input-block">
				      <input type="text" name="title" lay-verify="title" id="uName"  autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item top">
				      <label class="layui-form-label">登录名:</label>
				      <div class="layui-input-block">
				        <input type="text" name="title" lay-verify="title" id="uLogin"  autocomplete="off" class="layui-input">
				      </div>
				    </div>
					<div class="layui-form-item top">
					    <label class="layui-form-label">密码:</label>
					    <div class="layui-input-block">
					      <input type="password" name="title" lay-verify="title" id="pwd"  autocomplete="off" class="layui-input">
					    </div>
					  </div>
					<div class="layui-form-item top">
					    <label class="layui-form-label">工号:</label>
					    <div class="layui-input-block">
					      <input type="text" name="title" lay-verify="title" id="uno" autocomplete="off"  class="layui-input">
					    </div>
					  </div>
					  <div class="layui-form-item top">
					      <label class="layui-form-label">邮箱:</label>
					      <div class="layui-input-block">
					        <input type="text" name="title" lay-verify="title" id="uEmail" autocomplete="off" class="layui-input">
					      </div>
					    </div>
						
						<div class="layui-form-item top">
						    <label class="layui-form-label">手机:</label>
						    <div class="layui-input-block">
						      <input type="text" name="title" lay-verify="title" id="uTel"  autocomplete="off" class="layui-input">
						    </div>
						  </div>
						  <div class="layui-form-item top">
						      <label class="layui-form-label">用户权限:</label>
						      <div class="layui-input-block">
						          <select name="yorn" lay-verify="" id="role" class="yorn" >
									   <option value="student" selected>考生</option>
						            <option value="admin" >管理员</option>
									<option value="school">招生单位</option>
						          </select>
						        </div>
						    </div>
					
						  </div>`;

    return userDialog;

}


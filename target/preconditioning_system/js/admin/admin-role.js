$(function() {

	$("#add").click(function() {
		var user = createUser();
		var op = layer.open({
			type: 1,
			title: '新增用户',
			skin: 'layui-layer-rim', //加上边框
			area: ['440px', '530px'], //宽高
			btn: ['新增', '取消'],
			yes: function() {
				layer.close(op);
				var a = {
					"loginName": $("#uLogin").val().trim(),
					"password": $("#pwd").val().trim(),
					"uname": $("#uName").val().trim(),
					"uno": $("#uno").val().trim(),
					"email": $("#uEmail").val().trim(),
					"uphone": $("#uTel").val().trim(),
					"rname": $("#role option:selected").val(),

				}

				console.log(JSON.stringify(a));

			},
			content: user
		});

	});


});


layui.use(['table', 'element', 'layer', 'form'], function() {
	var element = layui.element;
	var layer = layui.layer;
	var table = layui.table;
	var form = layui.form;

	var tableIns=table.render({
		elem: '#demo',
		url: 'admin/role/find.do',
		height: 400,
		toolbar: '#ui-btn',
		title: '用户权限表',
        method:"post",
		cols: [
			[{
				type: 'numbers',
				fixed: 'left'
			}, {
				field: 'loginName',
				width: 150,
				title: '用户名'
			}, {
				field: 'roleName',
				width: 120,
				title: '用户权限',
				sort: true
			}, {
				field: 'chName',
				width: 120,
				title: '权限名称'
			}, {
				field: 'operation',
				width: 120,
				title: '权限范围'
			}, {
				field: 'right',
				width: 300,
				title: '操作权限',
                align:'center',
				toolbar: '#shenmolian'
			}]
		],
		page: true
	});


	table.on('toolbar(demo)', function(obj) {
		var checkStatus = table.checkStatus(obj.config.id);
		switch (obj.event) {
            case 'find':
				tableIns.reload({
                   page:{
                       curr: 1
                   }
                   ,where:{
                       "loginName":$("#findSub").val().trim(),
                        "rname":$("#findSch").val().trim()
                    }
                    , method: 'post'
                });
				break;
			case 'reset':
				$("#findSub").val("");
				$("#findSch").val("");
				break;
			case 'add':
				layer.msg('新增');
				break;
		};
	});


	table.on('tool(demo)', function(obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
		var data = obj.data; //获得当前行数据
		var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

		if (layEvent === 'add') {
			var role=createRole(data.loginName);
			var op = layer.open({
				type: 1,
				skin: 'layui-layer-rim',
				area: ['430px', '300px'],
				btn: ['确定', '取消'],
				title:'新增权限'
				,yes: function() {
					layer.close(op);
                    $.ajax({url:"admin/insertRole.do",
                        data:{
                        "loginName":data.loginName,
                        "rname":$("#select2").find("option:selected").val()
                        },
                        success:function(str) {
                        console.log(str);
                        if(str.code=="1"){
                            layer.msg(str.msg,{icon:1});
                        }else{
                            layer.msg(str.msg,{icon:0});
                        }
                        },error:function() {
                            layer.msg('服务器出错啦',{icon:2});
                        },type:"post"
                    });

				},
				content: role
			});
		} else if (layEvent === 'edit') { 
			var pop = createPop(data.loginName, data.roleName, data.chName);
			var op = layer.open({
				type: 1,
				skin: 'layui-layer-rim',
				area: ['420px', '350px'], 
				btn: ['保存', '取消'],
				title:'修改权限'
				,yes: function() {
					layer.close(op);
					$.ajax({url:"admin/updateRole.do",
                        data:{
                            "loginName":data.loginName,
                            "rname":$("#select1").find("option:selected").val(),
                            "sourceRole":data.roleName
                        },
                        success:function (msg) {
                        console.log(msg);
					    if(msg.code=="1"){
                            obj.update({
                                loginName:msg.username,
                                roleName:msg.rname,
                                chName:msg.chName,
                                operation:msg.operation
                            });
                            layer.msg(msg.msg,{icon:1});
                        }else{
                            layer.msg(msg.msg,{icon:0});
                        }
                        },error:function () {
                            layer.msg('服务器出错啦',{icon:2});
                        },type:"post"
					});

				},
				content: pop
			});

		}else if(layEvent==='del'){
            $.ajax({url:"admin/delRole.do",
                data:{
                    "loginName":data.loginName,
                    "rname":data.roleName
                },
                success:function() {
                    obj.del();
                    layer.msg('删除成功',{icon:1});
                },error:function() {
                    layer.msg('服务器出错啦',{icon:2});
                }
            });
        }

	});




});

function createPop(id, name, tel) {

	var pop =`<div class="dialog-width" style="white-space:nowrap!important;">
			<div class="layui-form-item top">
			    <label class="layui-form-label ">用户名:</label>
			    <div class="layui-input-block">
			      <input type="text" name="title" lay-verify="title" id="name" disabled value="${id}" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item top">
			      <label class="layui-form-label">用户权限:</label>
			      <div class="layui-input-block">
			   <input type="text" name="title" lay-verify="title" id="loginName" disabled value="${name}" autocomplete="off" class="layui-input">
			      </div>
			    </div>
				<div class="layui-form-item top">
				    <label class="layui-form-label">权限名称:</label>
				    <div class="layui-input-block">
				      <input type="text" name="title" lay-verify="title" id="tel" disabled value="${tel}" autocomplete="off"  class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item top">
				      <label class="layui-form-label">权限范围:</label>
				      <div class="layui-input-block">
							<select name="yorn" lay-verify="" id="select1" class="yorn" >
							  <option value="student" selected>考生</option>
							  <option value="school">招生单位</option>
							  <option value="admin">管理员</option>
							</select>
				      </div>
				    </div>
			</div>`;

	return pop;
}

function createRole(name) {

	var userDialog =
		`<div class="dialog-width" >
				<div class="layui-form-item top">
				    <label class="layui-form-label" >用户名:</label>
				    <div class="layui-input-block">
				    <input type="text" name="title" lay-verify="title" id="loginName" value="${name}" disabled  autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item top">
				  <label class="layui-form-label">新增权限:</label>
				     <div class="layui-input-block">
                        <select name="yorn" lay-verify="" id="select2" class="yorn" >
                        <option value="student" selected>考生</option>
                        <option value="school">招生单位</option>
                        <option value="admin">管理员</option>
                        </select>
				    </div> 
			</div>`;

	return userDialog;

}

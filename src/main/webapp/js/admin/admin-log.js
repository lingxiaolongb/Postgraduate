layui.use(['table', 'element', 'layer', 'form'], function() {
	var element = layui.element;
	var layer = layui.layer;
	var table = layui.table;
	var form = layui.form;

	table.render({
		elem: '#demo',
		url: 'admin/logPaging.do',
		height: 400,
		title: '用户权限表',
        method:"post",
		cols: [
			[{
					type: 'numbers',
					fixed: 'left'
				}, {
					field: 'operation',
					width: 88,
					title: '访问单位',

				}, {
					field: 'remoteAdd',
					width: 120,
					title: '请求地址',
					align: 'center'
				}, {
					field: 'method',
					width: 88,
					title: '请求方式'
				}, {
					field: 'url',
					width: 180,
					title: '访问路径',
					align: 'center'
				}, {
					field: 'exception',
					width: 88,
					title: '异常信息',
					align: 'center'
				},
				{
					field: 'visitTime',
					width: 140,
					title: '访问时间',
					align: 'center'
				},
				{
					field: 'type',
					width: 88,
					title: '日志类型'
				}
			]
		],
		page: true
	});

});

$(function(){
	
	
	
	
	$(".dialog-wrap").on("click","#dialog-btn",function(){	
		$(this).parents(".dialog-wrap .mask").remove();
	});
	
	$(".dialog-wrap").on("click"," .title .icon",function(){
		$(this).parents(".dialog-wrap .mask").remove();
	});
	


});

function createDialog(){
	
	var $diaglog=$(`<div class="mask">
			<div class="dialog">
				<div class="title">
					<span class="tips">提示</span>
					<span class="icon"></span>
				</div>
				<div class="body">
					<div class="ok"></div>
					<p class="msg">已成功更新你的信息</p>
					<button id="dialog-btn">确定</button>
				</div>
			</div>
		</div>`);
		return $diaglog;
	
}
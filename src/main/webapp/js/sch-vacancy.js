$(function(){

	$(".add-field").click(function(){
		
		if(index>=5){
			alert("你可以先保存哦!")
			$(".add-field").prop("disabled","false");
			return;
		}
		$node=createNode();
		$("#bottom_dom").before($node);
		
	
	});

		 index=1;
		 spec=new Array();
		 num=new Array();


	$(".info_sub").click(function(){

        a=[];
		var temp={specialized:$("#specialized0").val(),lack:$("#lack0").val()};
		a.push(temp);


		for(var i=0;i<spec.length;i++){
			temp={specialized:$(`#${spec[i]}`).val(),lack:$(`#${num[i]}`).val()}
			a.push(temp);
		}


		 var url=encodeURI("school/vacancy.do");
		$.ajax({
            url:url,
            data:JSON.stringify({
                "contacts":$("#contacts").val(),
                "telephone":$("#telephone").val(),
                "email":$("#email").val(),
                "vacancies":a}),
            contentType:"application/json;charset=utf-8",
            success:function (data) {
                layer.alert('信息更新成功', {icon: 1});
            },
            error:function () {
                layer.alert('服务器出错啦', {icon: 1});
            },
            type:"post"
        });

	});
    a=[];
});
		function createNode(){
			$node =$(`
			<div class="items">
				<span class="item_el"><span class="stars">*</span>专业[${index}]:</span>
				<input   id="specialized${index}" class="info_sr_left" />
				<span class="item_el"><span class="stars">*</span>缺额人数:</span>
				<input  id="lack${index}"  class="info_sr_right" />
			</div>
			`);
			spec[index-1]=`specialized${index}`;
			num[index-1]=`lack${index}`;
	
			index++;
			return $node;
		}
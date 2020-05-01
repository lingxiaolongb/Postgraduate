$(function() {

				$(".stu_sub>li>.stu_li").click(function() {
					var $father =$(this).parents("li");
					var $me=$(this);
					if($father.hasClass("rotate")){
						$father.removeClass("rotate").children(".content").stop().slideUp();
						$me.removeClass("add-color");
						return ;
					}
					
					 $father.addClass("rotate").children(".content").stop().slideToggle();
					 $me.addClass("add-color");
					
					// $(this).siblings().removeClass("rotate").children(".content").stop().slideUp();
					 // $(this).siblings().children(".stu_li").removeClass("add-color");
					 $father.siblings().removeClass("rotate").children(".content").stop().slideUp();
					 $father.siblings().children(".stu_li").removeClass("add-color");
					 
					
				
		
				});



			});
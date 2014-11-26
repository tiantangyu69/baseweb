/*
flashpic v1.0
by Lizhitao

configure info
- timeout 定时时间
- width 图片宽度
- height 图片高度
- numClass

*/
;(function($) {
	$.fn.extend({
		"flash":function(options){
			//设置默认值
			options=$.extend({
				timeout: 3000,	/* 定时时间*/
				width: 568, /* 图片宽度*/
				height: 230, /* 图片高度*/
				numClass: "picNews_num", /*图片中的数字样式*/
				clickOver: "click_over"
			},options);
				var currObj = this;//取得当前需要变为flashpic的对象
				var len=$(("ul>li"),this).length;//获取图片的数字个数
				this.addClass("picNews_size");
				this.addClass("picNews_style");
				this.addClass("flash_outer_9393943848934");//添加个样式主要用于鼠标移入到图片时不让图片再淡入淡出，鼠标移出后继续淡入淡出
				$("img",currObj).width(options.width);//设置图片的宽度
				$("img",currObj).height(options.height);//设置图片的高度
				this.width(options.width);//设置图片的宽度
				this.height(options.height);//设置图片的高度
				$("ul>li",currObj).each(function(){
					if($(this).index()==0){
						$(this).addClass(options.clickOver);
					}else{
						$(this).addClass("click_out");
					}
				});
				
				$(("ul"),currObj).addClass(options.numClass);//给数字添加样式
				var index=1;
				var int;
				function showSys(num)  //图片切换函数
				{
					$("ul>li",currObj).removeClass().addClass("click_out").eq(num).toggleClass("click_out").addClass(options.clickOver);
					$("img",currObj).fadeOut("fast").eq(num).fadeIn("slow");
				}
				function ziDong()  //自动切换
				{
					if(index==len)
				{
					index=0;
				}
					showSys(index);
					index=index+1;
				}
				
				int=setInterval(ziDong,options.timeout);//设置自动切换
				
				$("ul>li",currObj).click(function() //点击切换
				{
					var index_num=$("ul>li",currObj).index(this);
					showSys(index_num);
					index=index_num+1;  //改变全局变量的值，以便鼠标移开的时候能够衔接上
				});
				
				currObj.mouseover(function()  //移动到上面时停止自动切换
				   {
					clearInterval(int);
				   });
				currObj.mouseout(function()  //移开时继续自动切换
				   {
					int=setInterval(ziDong,options.timeout);
				   });
			
			return this;  //返回this，使方法可链。
		}
	});
})(jQuery);
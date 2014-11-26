function setmain(title, href) {
	$('#manageTabs').tabs({  
	    onBeforeClose : function(title,index){
			if(title == '在线用户'){
				$("#onlineUserTables").stopTime();
			}
	    }
	}); 
	// 判断选项卡是否已经存在，存在则不再添加该选项卡并将该选项卡选中
	if($('#manageTabs').tabs('exists', title)){
		$('#manageTabs').tabs('select', title);
	}else{
		$('#manageTabs').tabs('add',{  
		    title:title,
		    href : href,
		    closable:true,
		    cache : true,
		    iconCls:'icon-mini-add'
		}); 
	}
}

function changeMenuColor(obj){
	$(obj).css("background-color", "#E0ECFF");
}
function backMenuColor(obj){
	$(obj).css("background-color", "#FFFFFF");
}

function mangeUserLogout(href){
	$.messager.confirm('提示','您确定要退出系统吗?',function(result){
		if(result){
			window.location.href = href;
		}
	});
}

$(function(){
	// 关闭当前页
	$("#mm-tabclose").click(function(){
		var tab = $('#manageTabs').tabs('getSelected');
		var index = $('#manageTabs').tabs('getTabIndex',tab);
		if(index != 0){	
			$('#manageTabs').tabs('close',index);
		}
	});
	
	// 关闭所有页
	$("#mm-tabcloseall").click(function(){
		var arrayTitle = new Array();
		var tabs = $('#manageTabs').tabs('tabs');
		var count = tabs.length;
		for(var i = 0; i < count; i ++){
			arrayTitle.push(tabs[i].panel('options').title)
		}
		for(var i = 0; i < arrayTitle.length; i ++){
			if(arrayTitle[i] != '首页'){
				$('#manageTabs').tabs('close',arrayTitle[i]);
			}
		}
	});
	
	// 关闭非当前页
	$("#mm-tabcloseother").click(function(){
		var tabs = $('#manageTabs').tabs('tabs');
		var tab = $('#manageTabs').tabs('getSelected');
		var index = $('#manageTabs').tabs('getTabIndex',tab);
		var title = tabs[index].panel('options').title;
		var arrayTitle = new Array();
		var count = tabs.length;
		for(var i = 0; i < count; i ++){
			arrayTitle.push(tabs[i].panel('options').title)
		}
		for(var i = 0; i < arrayTitle.length; i ++){
			if(arrayTitle[i] != '首页' && arrayTitle[i] != title){
				$('#manageTabs').tabs('close',arrayTitle[i]);
			}
		}
	});
});
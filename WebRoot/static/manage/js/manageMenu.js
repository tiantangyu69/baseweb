var manageMenu = new baseManage("manageMenu");
manageMenu.importToResources = function(){
	$.messager.confirm('提示','开发菜单将不被导入资源表中,您确定要将数据导入资源表吗?',function(result){
        if (result){
        	$.post("manage/manageMenu/importToResources.action", function(){
        		$.messager.alert('提示',"导入成功！",'info');
        	});
        }
    });
}
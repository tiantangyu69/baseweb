var basePage = new baseManage("basePage");

basePage.saveOrEdit = function(){
	$(".edui-editor").css("z-index", 1000);
	$.messager.confirm('提示','您确定要保存该信息吗?',function(result){
        if (result){
			$("#edit_basePage_form").ajaxSubmit(function(){
				$.messager.alert('提示',"信息保存成功！",'info');
			});
        }
    });
}
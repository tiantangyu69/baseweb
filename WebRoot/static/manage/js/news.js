var news = new baseManage("news");
news.deployNews = function(){
	var rows = $("#newsTable").datagrid('getSelections');
	if(rows.length==0){
		$.messager.alert('提示',"请至少选择一行新闻再进行发布！",'info');
		return;
	}
	if(rows.length>1){
		$.messager.alert('提示',"一次只能选择一条新闻进行发布！",'info');
		return;
	}
	$.messager.confirm('提示','您确定发布选中的新闻吗?',function(result){
        if (result){
        	$.post('manage/news/deployNews.action', {id : rows[0].id},function(){
        		$("#newsTable").datagrid("reload");
        		$.messager.alert('提示',"发布成功！",'info');
        	});
        }
    });
}
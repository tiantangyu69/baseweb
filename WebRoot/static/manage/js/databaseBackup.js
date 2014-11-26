var databaseBackup = new baseManage("databaseBackup");

databaseBackup.restoreData = function(){
	
	var rows = $("#databaseBackupTable").datagrid('getSelections');
	if(rows.length==0){
		$.messager.alert('提示',"请先选择一个备份再进行数据还原！",'info');
		return;
	}
	if(rows.length>1){
		$.messager.alert('提示',"一次只能选择一个备份进行数据还原！",'info');
		return;
	}
	$.messager.confirm('提示','您确定要将该备份的数据还原覆盖现有的数据吗?请谨慎操作！',function(result){
        if (result){
        	$.post('manage/databaseBackup/restore.action', {id : rows[0].id},function(){
		        $.messager.alert('提示',"数据还原成功！请数分钟后在网站管理中选择缓存维护清理缓存。",'info');
        	});
        }
    });
}


databaseBackup.exportData = function(){
	
	var rows = $("#databaseBackupTable").datagrid('getSelections');
	if(rows.length==0){
		$.messager.alert('提示',"请先选择一个备份再进行导出！",'info');
		return;
	}
	if(rows.length>1){
		$.messager.alert('提示',"一次只能导出一个备份！",'info');
		return;
	}
	$.messager.confirm('提示','您确定要导出该备份文件吗！',function(result){
        if (result){
        	window.location.href = 'manage/databaseBackup/exportData.action?id=' + rows[0].id;
        }
    });
}
var websiteLetterReceive = new baseManage("websiteLetterReceive");
websiteLetterReceive.viewWebsiteLetterReceive = function(){
	var rows = $("#websiteLetterReceiveTable").datagrid('getSelections');
	var letterId = rows[0].id;
	$("#viewWebsiteReceiveLetter").layout('panel', 'west').panel({
		href : "manage/websiteLetterReceive/viewContent.action?id=" + letterId
	});
}

websiteLetterReceive.receive = function(){
	var rows = $("#websiteLetterReceiveTable").datagrid('getSelections');
	if(rows.length == 0){
		$.messager.alert('提示',"请选选择一个主题再进行查收！",'info');
	} else{
		var status = rows[0].status;
		if(status == '1'){
			$.messager.alert('提示',"该信息已查收！",'info');
		} else{
			$.messager.confirm('提示','您确定要查收该信息吗?',function(result){
				if (result){
					var rows = $("#websiteLetterReceiveTable").datagrid('getSelections');
					var letterId = rows[0].id;
					$.post("manage/websiteLetterReceive/receive.action", {id : letterId}, function(){
						$("#websiteLetterReceiveTable").datagrid("reload");
					});
				}
			});
		}
	}
}

websiteLetterReceive.reply = function(){
	var rows = $("#websiteLetterReceiveTable").datagrid('getSelections');
	if(rows.length == 0){
		$.messager.alert('提示',"请选选择一个主题再进行回复！",'info');
	} else{
		var width = 980;
		var height = 600;
		var title = "回复站内信";
		$("#add_websiteLetterReceive_Window").window( {
			minimizable : false,
			width : width,
			height : height,
			title : title,
			modal : true,
			iconCls : "icon-add",
			href : "manage/websiteLetterReceive/toEdit.action?id=" + rows[0].id
		});
	}
}
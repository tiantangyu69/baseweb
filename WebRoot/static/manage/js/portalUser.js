var portalUser = new baseManage("portalUser");

portalUser.validate = function(){
	var rows = $("#portalUserTable").datagrid('getSelections');
	if(rows.length==0){
		$.messager.alert('提示',"请先选择一行记录再进行审核！",'info');
		return;
	}
	if(rows.length > 1){
		$.messager.alert('提示',"一次只能选择一行记录进行审核！",'info');
		return;
	}
	if(rows[0].portalUserTypeId != 6){
		$.messager.alert('提示',"只能对经销商进行审核！",'info');
		return;
	}
	var width = width || 800;
	var height = height || 400;
	var title = title || "审核经销商";
	$("#edit_portalUser_Window").window( {
		minimizable : false,
		width : width,
		height : height,
		title : title,
		modal : true,
		iconCls : "icon-edit",
		href : "manage/portalUser/toValidate.action?id=" + rows[0].id
	});
}

portalUser.validate2 = function(id, status){
	$.post("manage/portalUser/validate.action",{id : id, status : status}, function(){
		$("#portalUserTable").datagrid("reload");
		$("#edit_portalUser_Window").window('close')
		$.messager.alert('提示',"审核成功！",'info');
	})
}

portalUser.validateClose = function(){
	$("#edit_portalUser_Window").window('close')
}
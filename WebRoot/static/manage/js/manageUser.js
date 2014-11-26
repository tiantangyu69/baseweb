var manageUser = new baseManage("manageUser");
manageUser.resetPassword = function(){
	var rows = $("#manageUserTable").datagrid('getSelections');
	if(rows.length==0){
		$.messager.alert('提示',"请先选择一行记录再进行重置密码！",'info');
		return;
	}
	$.messager.confirm('提示','您确定要重置选中用户的密码吗?',function(result){
        if (result){
        	var ids = new Array();
        	$.each(rows,function(i,n){
        		ids.push({name : "manageUserArray[" + i + "].id", value : n.id});
        	});
        	$.post('manage/manageUser/resetPassword.action', ids,function(){
        		$.messager.alert('提示',"重置密码成功！",'info');
        		$("#manageUserTable").datagrid("reload");
        	});
        }
    });
}

manageUser.toPersonSet = function(width, height, title){
	var width = width || 800;
	var height = height || 400;
	var title = title || "个人设置";
	$("#personSet_Window").window( {
		minimizable : false,
		width : width,
		height : height,
		title : title,
		modal : true,
		iconCls : "icon-edit",
		href : "manage/manageUser/toPersonSet.action"
	});
}

manageUser.personSet = function(){
	if($("#manageUser_personset_form").form('validate')){
		$("#manageUser_personset_form").ajaxSubmit(function(){
			$.messager.alert('提示',"设置成功！",'info');
			$("#personSet_Window").window('close');
		});
	}
}

manageUser.cancelPersonSet = function(){
	$("#personSet_Window").window('close');
}

manageUser.toModifyPassword = function(width, height, title){
	var width = width || 800;
	var height = height || 400;
	var title = title || "个人设置";
	$("#modifyPassword_Window").window( {
		minimizable : false,
		width : width,
		height : height,
		title : title,
		modal : true,
		iconCls : "icon-edit",
		href : "manage/manageUser/toModifyPassword.action"
	});
}

manageUser.modifyPassword = function(){
	var newpwd = $("input[name='newPassword']").val();
	var repeatpwd = $("input[name='repeatNewPassword']").val();
	if(newpwd != repeatpwd){
		$.messager.alert('提示',"您输入的新密码和重复新密码不一致，请重新输入！",'info');
	}else{
		if($("#manageUser_changePassword_form").form('validate')){
			$("#manageUser_changePassword_form").ajaxSubmit(function(status){
				if(status == "0"){
					$.messager.alert('提示',"密码修改失败！",'info');
				} else if(status == "1"){
					$.messager.alert('提示',"密码修改成功！",'info');
					$("#modifyPassword_Window").window('close');
				} else if(status == "2"){
					$.messager.alert('提示',"您输入的原密码错误，请重新输入！",'error');
				}
			});
		}
	}
}

manageUser.cancelModifyPassword = function(){
	$("#modifyPassword_Window").window('close');
}

manageUser.sendWebsiteLetter = function(){
	$("#sendWebsiteLetterReceive_form").form('submit', {
		success : function(msg){
			$.messager.alert('提示',"发送成功！",'info');
			$("#sendWebLetter_Window").window('close');
		}
	});
}

manageUser.cancelSendWebsiteLetter = function(){
	$("#sendWebLetter_Window").window('close');
}

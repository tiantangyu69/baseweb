var manageRole = new baseManage("manageRole");

manageRole.setRoleProperty = function(){
	manageRole.setResources();
	manageRole.setManageUser();
}

manageRole.setResources = function() {
	var rows = $("#manageRoleTable").datagrid('getSelections');
	var roleName = rows[0].name;
	var roleId = rows[0].id;
	var title = "<span style='color:#08C'>[" + roleName + "]</span>权限列表";
	$("#roleResourcesTree").panel({
		href : "manage/manageRoleResources/query.action?manageRoleId=" + roleId,
		title : title,
		tools: [{
			iconCls:'icon-save',
			handler:function(){manageRole.saveReources()}
		}]  
	});
}
manageRole.saveReources = function(){
	$.messager.confirm('提示','您确定要修改该角色的权限吗?',function(result){
		if(result){
			var rows = $("#manageRoleTable").datagrid('getSelections');
			var roleId = rows[0].id;
			var treeObj = $.fn.zTree.getZTreeObj("role_resource_tree");
			var nodes = treeObj.getCheckedNodes(true);
			if(nodes.length == 0){
				$.post("manage/manageRoleResources/add.action", {roleId : roleId}, function(){
					$.messager.alert('提示',"权限保存成功！",'info');
				});
			}else{
				var ids = new Array();
				$.each(nodes,function(i ,value){
					ids.push({name : "manageRoleResourcesArray[" + i + "].manageRoleId", value : roleId});
					ids.push({name : "manageRoleResourcesArray[" + i + "].resourceId", value : value.id});
				});
				$.post("manage/manageRoleResources/add.action", ids, function(){
					$.messager.alert('提示',"权限保存成功！",'info');
				});
			}
		}
	});
}

manageRole.setManageUser = function() {
	var rows = $("#manageRoleTable").datagrid('getSelections');
	var roleName = rows[0].name;
	var roleId = rows[0].id;
	var title = "<span style='color:#08C'>[" + roleName + "]</span>人员列表";
	$("#roleManageUserTree").panel({
		href : "manage/manageUserRole/manager.action?roleId=" + roleId,
		title : title
	});
}

manageRole.selectUser = function(width, height, title){
	var width = width || 800;
	var height = height || 400;
	var title = title || "添加人员";
	$("#add_manageUserRole_Window").window( {
		minimizable : false,
		width : width,
		height : height,
		title : title,
		modal : true,
		iconCls : "icon-add",
		href : "manage/manageUser/selectUser.action?num=" + Math.random()
	});
}

manageRole.saveRoleUser = function(){
	var rows = $("#selectUserTable").datagrid('getSelections');
	if(rows.length==0){
		$.messager.alert('提示',"请先选择人员再进行保存！",'info');
		return;
	}
	var rows2 = $("#manageRoleTable").datagrid('getSelections');
	var roleId = rows2[0].id;
	var ids = new Array();
	$.each(rows,function(i,n){
		ids.push({name : "manageUserRoleArray[" + i + "].roleId", value : roleId});
		ids.push({name : "manageUserRoleArray[" + i + "].userId", value : n.id});
	});
	$.post("manage/manageUserRole/add.action",ids, function(){
		$("#manageUserRoleTable").datagrid('reload');
		$("#add_manageUserRole_Window").window('close');
	});
}
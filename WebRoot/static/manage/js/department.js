var department = new baseManage("department");
department.add = function(){
	if($("#add_department_form").form('validate')){
		$("#add_department_form").ajaxSubmit(function(result){
			if(result && result.showDialog){
				if(result.status == RESULT.ERROR){
					$.messager.alert('错误',result.msg, 'error');
				} else{
					$.messager.alert('提示',result.msg, 'info');
				}
			}
			$("#departmentTable").treegrid("reload");
			$("#add_department_Window").window('close');
		});
	}
}

department.edit = function(){
	if($("#edit_department_form").form('validate')){
		$("#edit_department_form").ajaxSubmit(function(result){
			if(result && result.showDialog){
				if(result.status == RESULT.ERROR){
					$.messager.alert('错误',result.msg, 'error');
				} else{
					$.messager.alert('提示',result.msg, 'info');
				}
			}
			$("#departmentTable").treegrid("reload");
			$("#edit_department_Window").window('close');
		});
	}
}

department.deleteByIds = function(){
	var rows = $("#departmentTable").datagrid('getSelections');
	if(rows.length==0){
		$.messager.alert('提示',"请先选择一行记录再进行删除！",'info');
		return;
	}
	$.messager.confirm('提示','您确定要删除选中的数据吗?',function(result){
        if (result){
        	var rows = $("#departmentTable").datagrid('getSelections');
        	var ids = new Array();
        	$.each(rows,function(i,n){
        		ids.push({name : "departmentArray[" + i + "].id", value : n.id});
        	});
        	$.post('manage/department/deleteByIds.action', ids,function(result){
				if(result && result.showDialog){
					if(result.status == RESULT.ERROR){
						$.messager.alert('错误',result.msg, 'error');
					} else if(result.status == RESULT.SUCCESS){
						$.messager.alert('提示',result.msg, 'info');
					} else{
        				$.messager.alert('提示',result.msg,'error');
					} 
				}
    			$("#departmentTable").treegrid("reload");
        	});
        }
    });
}

department.showDepartmemtUsers = function(){
	var rows = $("#departmentTable").datagrid('getSelections');
	var departmentName = rows[0].name;
	var departmentId = rows[0].id;
	var title = "<span style='color:#08C'>[" + departmentName + "]</span>人员列表";
	$("#departmentResourcesTree").layout('panel','east').panel({
		title:title,
		href:"manage/department/managerUsers.action?department=" + departmentId
	});
	$('#departmentResourcesTree').layout('panel','east').panel('refresh');
}
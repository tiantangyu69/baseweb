jQuery.ajaxSetup({cache:false});//ajax不缓存
// 执行操作后的结果，常量值与java Result类的常量值相同，便于状态的同意
var RESULT = {
	ERROR : 0,
	SUCCESS : 1
}
function baseManage(module){
	this.toAdd = function(width, height, title){
		var width = width || 800;
		var height = height || 400;
		var title = title || "添加数据";
		$("#add_" + module + "_Window").window( {
			minimizable : false,
			width : width,
			height : height,
			title : title,
			modal : true,
			iconCls : "icon-add",
			href : "manage/" + module + "/toAdd.action"
		});
	};
	
	this.add = function(refreshTreeGrid){
		if($("#add_" + module + "_form").form('validate')){
			if(refreshTreeGrid){
				$("#add_" + module + "_form").ajaxSubmit(function(result){
					$("#" + module + "Table").treegrid("reload");
					$('body').layout('panel','west').panel('refresh');
					$("#add_" + module + "_Window").window('close');
					if(result && result.showDialog){
						if(result.status == RESULT.ERROR){
							$.messager.alert('错误',result.msg, 'error');
						} else{
							$.messager.alert('提示',result.msg, 'info');
						}
					}
				});
			} else{
				$("#add_" + module + "_form").ajaxSubmit(function(result){
					if(result && result.showDialog){
						if(result.status == RESULT.ERROR){
							$.messager.alert('错误',result.msg, 'error');
						} else{
							$.messager.alert('提示',result.msg, 'info');
						}
					}
					$("#" + module + "Table").datagrid("reload");
					$("#add_" + module + "_Window").window('close');
				});
			}
		}
	};
	
	this.toEdit = function(width, height, title){
		var rows = $("#" + module + "Table").datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert('提示',"请先选择一行记录再进行修改！",'info');
			return;
		}
		if(rows.length > 1){
			$.messager.alert('提示',"一次只能选择一行记录进行修改！",'info');
			return;
		}
		var width = width || 800;
		var height = height || 400;
		var title = title || "修改数据";
		$("#edit_" + module + "_Window").window( {
			minimizable : false,
			width : width,
			height : height,
			title : title,
			modal : true,
			iconCls : "icon-edit",
			href : "manage/" + module + "/toEdit.action?id=" + rows[0].id
		});
	};
	
	this.edit = function(refreshTreeGrid,callback){
		if($("#edit_" + module + "_form").form('validate')){
			if(refreshTreeGrid){
				$("#edit_" + module + "_form").ajaxSubmit(function(result){
					if(result && result.showDialog){
						if(result.status == RESULT.ERROR){
							$.messager.alert('错误',result.msg, 'error');
						} else{
							$.messager.alert('提示',result.msg, 'info');
						}
					}
					$("#" + module + "Table").treegrid("reload");
					$('body').layout('panel','west').panel('refresh');
					$("#edit_" + module + "_Window").window('close');
				});
			} else{
				$("#edit_" + module + "_form").ajaxSubmit(function(result){
					if(result && result.showDialog){
						if(result.status == RESULT.ERROR){
							$.messager.alert('错误',result.msg, 'error');
						} else{
							$.messager.alert('提示',result.msg, 'info');
						}
					}
					$("#" + module + "Table").datagrid("reload");
					$("#edit_" + module + "_Window").window('close');
				});
			}
		}
	};
	
	this.cancelAdd = function(){
		$("#add_" + module + "_Window").window('close');
	};
	
	this.cancelEdit = function(){
		$("#edit_" + module + "_Window").window('close');
	};
	
	this.deleteByIds = function(refreshTreeGrid){
		var rows = $("#" + module + "Table").datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert('提示',"请先选择一行记录再进行删除！",'info');
			return;
		}
		$.messager.confirm('提示','您确定要删除选中的数据吗?',function(result){
	        if (result){
	        	var rows = $("#" + module + "Table").datagrid('getSelections');
	        	var ids = new Array();
	        	$.each(rows,function(i,n){
	        		ids.push({name : module + "Array[" + i + "].id", value : n.id});
	        	});
	        	$.post('manage/' + module + '/deleteByIds.action', ids,function(result){
					if(result && result.showDialog){
						if(result.status == RESULT.ERROR){
							$.messager.alert('错误',result.msg, 'error');
						} else{
							$.messager.alert('提示',result.msg, 'info');
						}
					}
	        		if(refreshTreeGrid){
	        			$("#" + module + "Table").treegrid("reload");
	        			$('body').layout('panel','west').panel('refresh');
	        		} else{
		        		$("#" + module + "Table").datagrid("reload");
		        	}
	        	});
	        }
	    });
	};
};
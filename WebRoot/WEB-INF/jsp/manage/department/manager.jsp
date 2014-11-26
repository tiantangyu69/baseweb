<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="departmentToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <ui:linkButton icon="icon-add" plain="true" onclick="department.toAdd(600, 230, '添加部门');">添加部门</ui:linkButton>
        <ui:linkButton icon="icon-edit" plain="true" onclick="department.toEdit(600, 230, '修改部门');">修改部门</ui:linkButton>
        <ui:linkButton icon="icon-remove" plain="true" onclick="department.deleteByIds();">删除部门</ui:linkButton>
    </div>
</div>
<ui:layout fit="true" border="false" id="departmentResourcesTree">
	<ui:region region="center" split="true" border="false">
		<table id="departmentTable" title="部门列表" class="easyui-treegrid" data-options="
		    url : '${basePath}manage/department/query.action',
		    striped : true,
		    fitColumns : true,
		    fit : true,
		    idField: 'id',
		    treeField: 'name',
		    showFooter: true,
		    border : false,
		    toolbar : '#departmentToolBar',
			onClickRow : department.showDepartmemtUsers">
		    <thead>
		        <tr>
		            <th data-options="field : 'name'" width="10">部门名称</th>
		            <th data-options="field : 'url'" width="15">职能描述</th>
		            <th data-options="field : 'sort'" width="5">排序</th>
		        </tr>
		    </thead>
		</table>
	</ui:region>
    <ui:region id="" region="east" split="true" title="用户列表" style="width:420px;">
    </ui:region>
</ui:layout>

<div id="add_department_Window" title="添加部门"></div>
<div id="edit_department_Window" title="修改部门"></div>

<script type="text/javascript">
	function doDepartmentSearch(){
		var params = $('#departmentTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields =$('#departmentQueryForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each( fields, function(i, field){
			params[field.name] = field.value; //设置查询参数
		}); 
		$('#departmentTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
	}
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="deptUserToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <form id="manageUserDeptQueryForm">
            <input type="hidden" value="${department}" name="department"/>
            <input style="width: 240px;height: 25px;" class="easyui-searchbox" data-options="prompt:'输入用户名查询',searcher:doManageUserDeptSearch" name="username"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </form>
    </div>
</div>

<table id="deptUserTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}/manage/department/queryUsers.action?department=${department}',
    rownumbers : true,
    pagination : true,
    toolbar : '#deptUserToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'username'" width="10">用户名</th>
            <th data-options="field : 'telephone'" width="10">手机</th>
            <th data-options="field : 'status', formatter:deptUserStatusFormatter" width="10">状态</th>
        </tr>
    </thead>
</table>

<script type="text/javascript">

	function doManageUserDeptSearch(){
		var params = $('#deptUserTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields =$('#manageUserDeptQueryForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each( fields, function(i, field){
			params[field.name] = field.value; //设置查询参数
		}); 
		$('#deptUserTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
	}
	
	function deptUserStatusFormatter(val){
		if(val == '1'){
			return "启用";
		} else{
			return "<span style='color:red'>已停用</span>";
		}
	}
</script>
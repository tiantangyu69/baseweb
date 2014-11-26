<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="manageUserRoleToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="manageRole.selectUser(800, 500, '选择人员');">选择人员</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="manageUserRole.deleteByIds();">移除人员</a>
    </div>
</div>

<table id="manageUserRoleTable" class="easyui-datagrid" data-options="
    url : '${basePath}manage/manageUserRole/query.action',
    rownumbers : true,
    toolbar : '#manageUserRoleToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true,
    idField : 'id',
    queryParams : {roleId : ${roleId}}">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'manageUser',formatter:usernameFormatter" width="10">用户名</th>
        </tr>
    </thead>
</table>
<script type="text/javascript">
	function usernameFormatter(val, row){
    	return val.username;
    }
</script>
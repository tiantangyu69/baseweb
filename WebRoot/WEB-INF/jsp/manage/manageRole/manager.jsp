<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<ui:layout fit="true" border="false">
	<ui:region region="center" split="true" border="false">
		<div id="manageRoleToolBar" style="padding:5px;height:auto">
		    <div style="margin-bottom:5px">
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="manageRole.toAdd(600, 220, '添加角色');">添加角色</a>
		       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="manageRole.toEdit(600, 220, '修改角色');">修改角色</a>
		       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="manageRole.deleteByIds();">删除角色</a>
		    </div>
		</div>
		<table id="manageRoleTable" class="easyui-datagrid" data-options="
			pageList : [15,30,50,100],
			pageSize : 15,
			url : '${basePath}manage/manageRole/query.action',
			rownumbers : true,
			pagination : true,
			toolbar : '#manageRoleToolBar',
			striped : true,
			fitColumns : true,
			border : false,
			singleSelect : true,
			fit : true,
			idField : 'id',
			onClickRow : manageRole.setRoleProperty">
		    <thead>
		        <tr>
		            <th data-options="field : 'name'" width="10">角色名称</th>
		            <th data-options="field : 'description'" width="40">角色描述</th>
		            <th data-options="field : 'sort'" width="10">角色排序</th>
		        </tr>
		    </thead>
		</table>
	</ui:region>
    <ui:region region="east" split="true" title="角色属性" style="width:420px;">
        <ui:layout fit="true" border="false">
            <ui:region region="west" split="true" border="false" style="width:210px;">
                <div id="roleManageUserTree" class="easyui-panel" data-options="fit:true,border:false,title:'角色人员列表'"></div>
            </ui:region>
            <ui:region region="center" split="true">
                <div id="roleResourcesTree" class="easyui-panel" data-options="fit:true,border:false,title:'角色权限列表'"></div>
            </ui:region>
        </ui:layout>
    </ui:region>
</ui:layout>    
<div id="add_manageRole_Window" title="添加角色"></div>
<div id="edit_manageRole_Window" title="修改角色"></div>
<div id="add_manageUserRole_Window" title="选择人员"></div>
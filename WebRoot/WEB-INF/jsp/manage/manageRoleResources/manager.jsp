<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="manageRoleResourcesToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="manageRoleResources.toAdd(800, 500, '添加数据');">添加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="manageRoleResources.toEdit(800, 500, '修改数据');">修改</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="manageRoleResources.deleteByIds();">删除</a>
        <input class="easyui-searchbox"/>
    </div>
</div>

<table id="manageRoleResourcesTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/manageRoleResources/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#manageRoleResourcesToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'manageRoleId'" width="10">角色id</th>
            <th data-options="field : 'resourceId'" width="10">资源id</th>
            <th data-options="field : 'attribute1'" width="10">attribute1</th>
            <th data-options="field : 'attribute2'" width="10">attribute2</th>
            <th data-options="field : 'attribute3'" width="10">attribute3</th>
            <th data-options="field : 'attribute4'" width="10">attribute4</th>
            <th data-options="field : 'attribute5'" width="10">attribute5</th>
        </tr>
    </thead>
</table>
<div id="add_manageRoleResources_Window" title="添加数据"></div>
<div id="edit_manageRoleResources_Window" title="修改数据"></div>
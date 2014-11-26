<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="databaseBackupToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="databaseBackup.toAdd(600, 220, '创建备份');">创建备份</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="databaseBackup.toEdit(600, 220, '修改备份');">修改备份</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="databaseBackup.restoreData();">恢复备份</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="databaseBackup.exportData();">导出备份</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="databaseBackup.deleteByIds();">删除备份</a>
    </div>
</div>

<table id="databaseBackupTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/databaseBackup/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#databaseBackupToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'name'" width="15">备份名称</th>
            <th data-options="field : 'backupDate'" width="10">备份日期</th>
            <th data-options="field : 'username'" width="10">操作人</th>
            <th data-options="field : 'remark'" width="30">备注</th>
        </tr>
    </thead>
</table>
<div id="add_databaseBackup_Window" title="创建备份"></div>
<div id="edit_databaseBackup_Window" title="修改备份"></div>
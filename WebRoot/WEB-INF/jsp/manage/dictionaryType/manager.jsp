<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="dictionaryTypeToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="dictionaryType.toAdd(600, 170, '添加字典类型');">添加字典类型</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="dictionaryType.toEdit(600, 170, '修改字典类型');">修改字典类型</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="dictionaryType.deleteByIds();">删除字典类型</a>
    </div>
</div>

<table id="dictionaryTypeTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/dictionaryType/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#dictionaryTypeToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'name'" width="10">类型名称</th>
            <th data-options="field : 'attribute1'" width="30">备注</th>
        </tr>
    </thead>
</table>
<div id="add_dictionaryType_Window" title="添加字典类型"></div>
<div id="edit_dictionaryType_Window" title="修改字典类型"></div>
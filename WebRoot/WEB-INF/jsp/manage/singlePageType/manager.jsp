<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="singlePageTypeToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="singlePageType.toAdd(600, 150, '添加单页类型');">添加单页类型</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="singlePageType.toEdit(600, 150, '修改单页类型');">修改单页类型</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="singlePageType.deleteByIds();">删除单页类型</a>
    </div>
</div>

<table id="singlePageTypeTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/singlePageType/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#singlePageTypeToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'name'" width="10">单页类型名称</th>
            <th data-options="field : 'sort'" width="10">排序</th>
        </tr>
    </thead>
</table>
<div id="add_singlePageType_Window" title="添加单页类型"></div>
<div id="edit_singlePageType_Window" title="修改单页类型"></div>
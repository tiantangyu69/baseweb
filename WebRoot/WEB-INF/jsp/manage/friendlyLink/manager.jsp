<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="friendlyLinkToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="friendlyLink.toAdd(600, 200, '添加友情链接');">添加友情链接</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="friendlyLink.toEdit(600, 200, '修改友情链接');">修改友情链接</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="friendlyLink.deleteByIds();">删除友情链接</a>
    </div>
</div>

<table id="friendlyLinkTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/friendlyLink/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#friendlyLinkToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'name'" width="10">链接名</th>
            <th data-options="field : 'url'" width="10">链接地址</th>
            <th data-options="field : 'sort'" width="10">排序</th>
        </tr>
    </thead>
</table>
<div id="add_friendlyLink_Window" title="添加友情链接"></div>
<div id="edit_friendlyLink_Window" title="修改友情链接"></div>
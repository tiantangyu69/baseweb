<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="portalUserTypeToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="portalUserType.toAdd(600, 210, '添加会员类型');">添加会员类型</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="portalUserType.toEdit(600, 210, '修改会员类型');">修改会员类型</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="portalUserType.deleteByIds();">删除会员类型</a>
    </div>
</div>

<table id="portalUserTypeTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/portalUserType/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#portalUserTypeToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'name'" width="10">会员类型名称</th>
            <th data-options="field : 'attribute1'" width="30">描述</th>
            <th data-options="field : 'sort'" width="10">排序</th>
        </tr>
    </thead>
</table>
<div id="add_portalUserType_Window" title="添加会员类型"></div>
<div id="edit_portalUserType_Window" title="修改会员类型"></div>
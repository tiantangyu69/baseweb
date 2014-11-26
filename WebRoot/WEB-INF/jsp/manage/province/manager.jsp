<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="provinceToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="province.toAdd(600, 200, '添加省市');">添加省市</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="province.toEdit(600, 200, '修改省市');">修改省市</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="province.deleteByIds();">删除省市</a>
    </div>
</div>

<table id="provinceTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/province/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#provinceToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'name'" width="10">省市名</th>
            <th data-options="field : 'sort'" width="10">排序</th>
            <th data-options="field : 'remark'" width="10">说明</th>
        </tr>
    </thead>
</table>
<div id="add_province_Window" title="添加省市"></div>
<div id="edit_province_Window" title="修改省市"></div>
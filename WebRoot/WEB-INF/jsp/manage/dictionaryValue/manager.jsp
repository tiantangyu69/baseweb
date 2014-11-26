<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="dictionaryValueToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="dictionaryValue.toAdd(600, 200, '添加数字字典值');">添加数字字典值</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="dictionaryValue.toEdit(600, 200, '修改数据字典值');">修改数字字典值</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="dictionaryValue.deleteByIds();">删除数字字典值</a>
    </div>
</div>

<table id="dictionaryValueTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/dictionaryValue/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#dictionaryValueToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'dictionaryType',formatter:dictionaryTypeFormatter" width="10">字典类型</th>
            <th data-options="field : 'value'" width="10">字典值</th>
            <th data-options="field : 'attribute1'" width="30">备注</th>
        </tr>
    </thead>
</table>
<div id="add_dictionaryValue_Window" title="添加数字字典值"></div>
<div id="edit_dictionaryValue_Window" title="修改数字字典值"></div>

<script type="text/javascript">
	function dictionaryTypeFormatter(val, row){
		return val.name;
	}
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="${entityName ? uncap_first}ToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <form id="${entityName ? uncap_first}QueryForm">
            <ui:searchbox style="width: 360px;height: 25px;" prompt="" name="andLikeName" searcher="do${entityName}Search"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </form>
        <ui:linkButton icon="icon-add" plain="true" onclick="${entityName ? uncap_first}.toAdd(800, 500, '添加数据');">添加</ui:linkButton>
        <ui:linkButton icon="icon-edit" plain="true" onclick="${entityName ? uncap_first}.toEdit(800, 500, '修改数据');">修改</ui:linkButton>
        <ui:linkButton icon="icon-remove" plain="true" onclick="${entityName ? uncap_first}.deleteByIds();">删除</ui:linkButton>
    </div>
</div>

<table id="${entityName ? uncap_first}Table" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${"$"}{basePath}manage/${entityName ? uncap_first}/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '${"#"}${entityName ? uncap_first}ToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <#list columnList as f>
            <th data-options="field : '${f.name}'<#if f.name=='id'>, checkbox : true</#if>" width="10">${f.nameCN}</th>
            </#list>
        </tr>
    </thead>
</table>
<div id="add_${entityName ? uncap_first}_Window" title="添加数据"></div>
<div id="edit_${entityName ? uncap_first}_Window" title="修改数据"></div>

<script type="text/javascript">
	function do${entityName}Search(){
		var params = $('#${entityName ? uncap_first}Table').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields =$('#${entityName ? uncap_first}QueryForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each( fields, function(i, field){
			params[field.name] = field.value; //设置查询参数
		}); 
		$('#${entityName ? uncap_first}Table').datagrid('reload'); //设置好查询参数 reload 一下就可以了
	}
</script>
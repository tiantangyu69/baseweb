<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="singlePageToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="singlePage.toAdd(900, 650, '添加单页');">添加单页</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="singlePage.toEdit(900, 650, '修改单页');">修改单页</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="singlePage.deleteByIds();">删除单页</a>
    </div>
</div>

<table id="singlePageTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/singlePage/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#singlePageToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'name'" width="10">单页名称</th>
            <th data-options="field : 'singlePageType',formatter:singlePageTypeFormatter" width="10">单页类型</th>
            <th data-options="field : 'content',formatter:singlePageContentFormatter" width="30">单页内容</th>
        </tr>
    </thead>
</table>
<div id="add_singlePage_Window" title="添加单页"></div>
<div id="edit_singlePage_Window" title="修改单页"></div>

<script type="text/javascript">
	function singlePageTypeFormatter(val, row){
    	return val.name;
    }
	
	function singlePageContentFormatter(val, row){
		return "单页内容请点击修改查看。";
	}
</script>
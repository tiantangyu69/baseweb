<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="resourcesToolBar" style="padding:5px;height:auto;display: none;">
    <div style="margin-bottom:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="resources.toAdd(800, 500, '添加数据');">添加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="resources.toEdit(800, 500, '修改数据');">修改</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="resources.deleteByIds();">删除</a>
        <input class="easyui-searchbox"/>
    </div>
</div>
<table id="resourcesTable" class="easyui-treegrid" data-options="
    url : '${basePath}manage/resources/query.action',
    striped : true,
    fitColumns : true,
    fit : true,
    idField: 'id',
    treeField: 'name',
    showFooter: true">
    <thead>
        <tr>
            <th data-options="field : 'name'" width="10">资源名称</th>
            <th data-options="field : 'code'" width="10">资源代码</th>
            <th data-options="field : 'resourceType',formatter:resourcesTypeFormatter" width="10">页面类型</th>
        </tr>
    </thead>
</table>
<div id="add_resources_Window" title="添加数据"></div>
<div id="edit_resources_Window" title="修改数据"></div>
<script type="text/javascript">
	function resourcesTypeFormatter(val,row){
		if(val == 1){
			return "后台页面";
		} else if(val == 2){
			return "前台页面";
		} else{
			return "";
		}
	}
  </script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="manageMenuToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="manageMenu.toAdd(600, 220, '添加菜单');">添加菜单</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="manageMenu.toEdit(600, 220, '修改菜单');">修改菜单</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="manageMenu.deleteByIds(true);">删除菜单</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="manageMenu.importToResources();">导入资源表</a>
    </div>
</div>

<table id="manageMenuTable" class="easyui-treegrid" data-options="
    url : '${basePath}manage/manageMenu/query.action',
    toolbar : '#manageMenuToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true,
    idField: 'id',
    treeField: 'name',
    showFooter: true">
    <thead>
        <tr>
            <th data-options="field : 'name'" width="15">菜单名称</th>
            <th data-options="field : 'type',formatter:manageMenuTypeFormatter" width="10">菜单类型</th>
            <th data-options="field : 'url'" width="30">菜单路径</th>
            <th data-options="field : 'sort'" width="10">排序</th>
        </tr>
    </thead>
</table>
<div id="add_manageMenu_Window" title="添加菜单"></div>
<div id="edit_manageMenu_Window" title="修改菜单"></div>
<script type="text/javascript">
	function manageMenuTypeFormatter(val,row){
		if(val == 1){
			return "后台菜单";
		} else if(val == 2){
			return "前台菜单";
		} else{
			return "开发菜单";
		}
	}
  </script>
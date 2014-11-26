<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="websiteLogoToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="websiteLogo.toAdd(830, 330, '添加logo');">添加logo</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="websiteLogo.toEdit(830, 330, '修改logo');">修改logo</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="websiteLogo.deleteByIds();">删除logo</a>
    </div>
</div>

<table id="websiteLogoTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/websiteLogo/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#websiteLogoToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    idField: 'id',
    singleSelect : true,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'attribute1'" width="10">logo编号</th>
            <th data-options="field : 'name'" width="10">logo图片名称</th>
            <th data-options="field : 'picUrl',formatter:picViewFormatter" width="30">logo图片预览</th>
        </tr>
    </thead>
</table>
<div id="add_websiteLogo_Window" title="添加logo"></div>
<div id="edit_websiteLogo_Window" title="修改logo"></div>
<script type="text/javascript">
	function picViewFormatter(val){
		return "<img src='${basePath}" + val + "' style='width:576px;height:51px;border:none'>";
	}
</script>
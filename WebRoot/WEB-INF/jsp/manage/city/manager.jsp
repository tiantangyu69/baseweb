<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="cityToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="city.toAdd(600, 200, '添加城市');">添加城市</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="city.toEdit(600, 200, '修改城市');">修改城市</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="city.deleteByIds();">删除城市</a>
    </div>
</div>

<table id="cityTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/city/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#cityToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'province',formatter:provinceFormatter" width="10">所属省市</th>
            <th data-options="field : 'name'" width="10">城市名</th>
            <th data-options="field : 'sort'" width="10">排序</th>
            <th data-options="field : 'remark'" width="10">说明</th>
        </tr>
    </thead>
</table>
<div id="add_city_Window" title="添加城市"></div>
<div id="edit_city_Window" title="修改城市"></div>

<script type="text/javascript">
	function provinceFormatter(val){
		return val.name;
	}
</script>
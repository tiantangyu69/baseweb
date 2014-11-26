<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<table id="dataSourceTable" class="easyui-propertygrid" data-options="
				url: '${basePath}manage/dataBaseManage/queryDataSource.action',
				showGroup: true,
				scrollbarSize: 0,
				columns: mycolumns,
				groupFormatter: groupFormatter,
				border : false">
</table>
<div style="margin:5px auto auto 3px;">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="getChanges()">保存修改</a>
</div>
<script>
	var mycolumns = [[
		{field:'name',title:'属性名称',width:50},
		{field:'value',title:'属性值',width:150}
	]];
	function groupFormatter(fvalue, rows){
		return '<span style="font-size:12px">' + fvalue + '</span>';
	}
	function getChanges(){
	    var s = '';
	    var rows = $('#dataSourceTable').propertygrid('getChanges');
	    for(var i=0; i<rows.length; i++){
	    	if(i < rows.length -1){
	        	s += rows[i].name + '$' + rows[i].value + ',';
	        } else{
	        	s += rows[i].name + '$' + rows[i].value;
	        }
	    }
	    if("" != s){
	    	$.get("${basePath}manage/dataBaseManage/updateDataSource.action",{settings : s},function(){
	    		$.messager.alert('提示',"配置修改成功！",'info');
	    	})
	    }
	}
</script>
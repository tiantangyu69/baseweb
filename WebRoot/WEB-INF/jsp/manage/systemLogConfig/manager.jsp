<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="systemLogConfigToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <form id="systemLogConfigQueryForm">
            <ui:searchbox style="width: 360px;height: 25px;" prompt="" name="andLikeName" searcher="doSystemLogConfigSearch"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </form>
        <ui:linkButton icon="icon-add" plain="true" onclick="systemLogConfig.toAdd(800, 500, '添加日志配置');">添加日志配置</ui:linkButton>
        <ui:linkButton icon="icon-edit" plain="true" onclick="systemLogConfig.toEdit(800, 500, '修改日志配置');">修改日志配置</ui:linkButton>
        <ui:linkButton icon="icon-remove" plain="true" onclick="systemLogConfig.deleteByIds();">删除日志配置</ui:linkButton>
    </div>
</div>

<table id="systemLogConfigTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/systemLogConfig/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#systemLogConfigToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'attribute1'" width="10">日志类型</th>
            <th data-options="field : 'name'" width="10">操作栏目</th>
            <th data-options="field : 'optionName'" width="10">操作动作</th>
            <th data-options="field : 'property'" width="10">操作属性</th>
            <th data-options="field : 'url'" width="15">过滤路径</th>
            <th data-options="field : 'record',formatter:systemLogConfigFormatter" width="5">是否进行日志记录</th>
        </tr>
    </thead>
</table>
<div id="add_systemLogConfig_Window" title="添加日志配置"></div>
<div id="edit_systemLogConfig_Window" title="修改日志配置"></div>

<script type="text/javascript">
	function systemLogConfigFormatter(val){
		if(val == true){
			return "是";
		} else{
			return "<span style='color:red'>否</span>";
		}
	}

	function doSystemLogConfigSearch(){
		var params = $('#systemLogConfigTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields =$('#systemLogConfigQueryForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each( fields, function(i, field){
			params[field.name] = field.value; //设置查询参数
		}); 
		$('#systemLogConfigTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
	}
</script>
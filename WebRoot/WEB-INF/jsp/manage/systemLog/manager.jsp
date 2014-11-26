<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="systemLogToolBar" style="padding:5px;height:auto">
    <div style="margin-top:5px">
        <form id="systemLogQueryForm">
			<table width="100%" style="font-size:12px;">
				<tr>
				    <td width="340">
				        <span>日志内容：</span>
				        <ui:input cssClass="input_240" name="andLikeName"/>
				    </td>
				    <td width="340">
				        <span>日志类型：</span>
				        <ui:combobox cssClass="input_240" name="andLikeAttribute1" url="${basePath}manage/dictionaryValue/queryCombobox.action?dictionaryTypeId=3" textField="value" valueField="value"/>
				    </td>
				    <td align="left">
				        <a href="#" onclick="doSearchLogs();" class="easyui-linkbutton" iconCls="icon-search">查询</a>&nbsp;&nbsp;&nbsp;&nbsp;
				        <a href="#" onclick="javascript:$('#systemLogQueryForm').form('clear');" class="easyui-linkbutton" iconCls="icon-undo">重置</a>
				    </td>
				</tr>
				<tr>
				    <td>
				        <span>操作用户：</span>
				        <input name="andLikeUsername" class="input_240" maxlength="100">
				    </td>
				    <td>
				        <span>操作时间：</span>
				        <ui:WdatePicker readonly="readonly" name="andLikeOptTime" cssClass="input_240"/>
				    </td>
				    <td align="center"></td>
				</tr>
			</table>
        </form>
        <ui:linkButton icon="icon-remove" plain="true" onclick="systemLog.deleteByIds();">删除日志</ui:linkButton>
    </div>
</div>

<table id="systemLogTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/systemLog/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#systemLogToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'name'" width="30">日志内容</th>
            <th data-options="field : 'username'" width="10">操作用户</th>
            <th data-options="field : 'ip'" width="10">操作用户IP地址</th>
            <th data-options="field : 'optTime'" width="10">操作时间</th>
        </tr>
    </thead>
</table>

<script type="text/javascript">
	function doSearchLogs(){
		var params = $('#systemLogTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields =$('#systemLogQueryForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each( fields, function(i, field){
			params[field.name] = field.value; //设置查询参数
		}); 
		$('#systemLogTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
	}
</script>
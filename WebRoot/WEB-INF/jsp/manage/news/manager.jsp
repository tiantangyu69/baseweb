<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>

<div id="newsToolBar" style="padding:5px;height:auto">
	<form id="newsQueryForm" style="margin:10;text-align: center;">
		<table width="100%" style="font-size:12px;">
			<tr>
			    <td width="340">
			        <span>所属栏目：</span>
			        <ui:combobox cssClass="input_240" url="manage/dictionaryValue/queryCombobox.action?dictionaryTypeId=1" valueField="id" textField="value" name="itemId"/>
			    </td>
			    <td width="340">
			        <span>新闻类型：</span>
			        <ui:combobox cssClass="input_240" url="manage/dictionaryValue/queryCombobox.action?dictionaryTypeId=2" valueField="id" textField="value" name="newsTypeId"/>
			    </td>
			    <td align="left">
			        <a href="#" onclick="doSearchNews();" class="easyui-linkbutton" iconCls="icon-search">查询</a>&nbsp;&nbsp;&nbsp;&nbsp;
			        <a href="#" onclick="javascript:$('#newsQueryForm').form('clear');" class="easyui-linkbutton" iconCls="icon-undo">重置</a>
			    </td>
			</tr>
			<tr>
			    <td>
			        <span>新闻标题：</span>
			        <input name="title" style="width: 240" maxlength="100">
			    </td>
			    <td>
			        <span>发布日期：</span>
			        <ui:WdatePicker readonly="readonly" name="deployDate" cssClass="input_240"/>
			    </td>
			    <td align="center"></td>
			</tr>
		</table>
	</form>
    <div style="margin-bottom:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="news.toAdd(980, 750, '添加新闻');">添加新闻</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="news.toEdit(980, 750, '修改新闻');">修改新闻</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="news.deleteByIds();">删除新闻</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="news.deployNews();">发布新闻</a>
    </div>
</div>

<table id="newsTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/news/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#newsToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'newsItem',formatter:newsItemFormatter" width="10">栏目</th>
            <th data-options="field : 'newsType',formatter:newsTypeFormatter" width="10">新闻类型</th>
            <th data-options="field : 'title'" width="25">标题</th>
            <th data-options="field : 'status',formatter:newsStatusFormatter" width="10">新闻状态</th>
            <th data-options="field : 'deployUsername'" width="10">发布人</th>
            <th data-options="field : 'deployDate'" width="10">发布日期</th>
        </tr>
    </thead>
</table>
<div id="add_news_Window" title="添加新闻"></div>
<div id="edit_news_Window" title="修改新闻"></div>

<script type="text/javascript">
	function newsItemFormatter(val, row){
		if(val && val.value){
			return val.value;
		} else{
			return "";
		}
	}
	
	function newsTypeFormatter(val, row){
		if(val && val.value){
			if(val.value == '普通'){
				return val.value;
			} else{
				return "<span style='color:red'>" + val.value + "</span>";
			}
		} else{
			return "";
		}
	}

	function newsStatusFormatter(val, row){
		if(val == 0){
			return "<span style='color:red'>未发布</span>";
		} else if(val == 1){
			return "<span style='color:blue'>已发布</span>";
		} else{
			return "";
		}
	}
	
	//表格查询
	function doSearchNews(){
		var params = $('#newsTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields =$('#newsQueryForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each( fields, function(i, field){
			params[field.name] = field.value; //设置查询参数
		}); 
		$('#newsTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
	}
</script>
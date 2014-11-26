<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<script type="text/javascript">
	$(function(){
		$('#searchPortalUserTypeId').combobox({
			valueField:'id', //值字段
		    textField:'name', //显示的字段
		    url:'manage/portalUserType/queryCombobox.action',
			editable:false//不可编辑，只能选择
		});
	});
</script>

<div id="portalUserToolBar" style="padding:5px;height:auto">
	<form id="portalUserQueryForm" style="margin:10;text-align: center;">
		<table width="100%" style="font-size:12px;">
			<tr>
			    <td width="340">用户类型：<input style="width:240px;" id="searchPortalUserTypeId" name="portalUserTypeId"></input></td>
			    <td width="340">用户名：<input style="width: 240" name="username"></td>
			    <td align="left"><a href="#" onclick="doPortalUserSearch();" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
			</tr>
		</table>
	</form>
    <div style="margin-bottom:5px">
        <%--<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="portalUser.toAdd(700, 260, '添加会员');">添加用户</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="portalUser.toEdit(700, 260, '修改用户');">修改用户</a>--%>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="portalUser.validate()">审核经销商</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="portalUser.deleteByIds();">删除用户</a>
    </div>
</div>

<table id="portalUserTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/portalUser/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#portalUserToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'portalUserType', formatter:userTypeFormatter" width="10">用户类型</th>
            <th data-options="field : 'username'" width="10">用户名</th>
            <th data-options="field : 'telephone'" width="10">手机</th>
            <th data-options="field : 'email'" width="10">邮箱</th>
            <th data-options="field : 'attribute2'" width="10">注册时间</th>
            <th data-options="field : 'attribute12',formatter:portalUserStatusFormatter" width="10">用户状态</th>
            <th data-options="field : 'attribute1'" width="20">备注</th>
        </tr>
    </thead>
</table>
<div id="add_portalUser_Window" title="添加用户"></div>
<div id="edit_portalUser_Window" title="修改用户"></div>

<script type="text/javascript">
	function userTypeFormatter(val, row){
		if(val.id == 6){
    		return "<span style='color:red'>" + val.name + "</span>";
		}
    	return val.name;
    }
	
	function portalUserStatusFormatter(val){
		if(val == '0'){
			return "<span style='color:red'>未审核</span>";
		} else if(val == '1'){
			return "<span style='color:green'>审核通过</span>";
		} else if(val == '2'){
			return "<span style='color:gray'>审核未通过</span>";
		} else{
			return "数据错误";
		}
	}
	
	function doPortalUserSearch(){
		var params = $('#portalUserTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields =$('#portalUserQueryForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each( fields, function(i, field){
			params[field.name] = field.value; //设置查询参数
		}); 
		$('#portalUserTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
	}
</script>
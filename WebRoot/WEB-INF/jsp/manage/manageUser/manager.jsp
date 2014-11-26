<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="manageUserToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <form id="manageUserQueryForm">
			<table width="100%" style="font-size:12px;">
				<tr>
				    <td width="340">
				        <span>用户名：</span>
				        <ui:input cssClass="input_240" name="andLikeUsername"  validType="length[0,30]"/>
				    </td>
				    <td width="340">
				        <span>所属部门：</span>
				        <input name="department" class="easyui-combotree input_240" data-options="url:'${basePath}manage/department/queryCombox.action',method:'get'"/>
				    </td>
				    <td align="left">
				        <ui:linkButton onclick="doManageUserSearch();" icon="icon-search">查询</ui:linkButton>&nbsp;&nbsp;&nbsp;&nbsp;
				        <ui:linkButton onclick="javascript:$('#manageUserQueryForm').form('clear');" icon="icon-undo">重置</ui:linkButton>
				    </td>
				</tr>
				<tr>
				    <td>
				        <span>手机号：</span>
				        <ui:numberbox name="andLikeTelephone" cssClass="input_240" maxLength="11"/>
				    </td>
				    <td>
				        <span>电子邮箱：</span>
				        <ui:input cssClass="input_240" name="andLikeEmail" validType="length[0,30]"/>
				    </td>
				    <td align="center"></td>
				</tr>
			</table>
        </form>
        <ui:linkButton icon="icon-add" plain="true" onclick="manageUser.toAdd(600, 250, '添加用户');">添加用户</ui:linkButton>
        <ui:linkButton icon="icon-edit" plain="true" onclick="manageUser.toEdit(600, 250, '修改用户');">修改用户</ui:linkButton>
        <ui:linkButton icon="icon-reload" plain="true" onclick="manageUser.resetPassword();">重置密码</ui:linkButton>
        <ui:linkButton icon="icon-remove" plain="true" onclick="manageUser.deleteByIds();">删除用户</ui:linkButton>
    </div>
</div>

<table id="manageUserTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/manageUser/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#manageUserToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'username'" width="10">用户名</th>
            <th data-options="field : 'dept', formatter:manageUserDeptFormatter" width="10">所属部门</th>
            <th data-options="field : 'telephone'" width="10">手机号</th>
            <th data-options="field : 'email'" width="10">电子邮箱</th>
            <th data-options="field : 'grade',formatter:manageUserGradeFormatter" width="10">级别</th>
            <th data-options="field : 'status',formatter:manageUserStatusFormatter" width="10">状态</th>
            <th data-options="field : 'lastLoginTime'" width="10">最后登录时间</th>
            <th data-options="field : 'lastLoginIP'" width="10">最后登录ip</th>
        </tr>
    </thead>
</table>
<div id="add_manageUser_Window" title="添加用户"></div>
<div id="edit_manageUser_Window" title="修改用户"></div>
<script type="text/javascript">
	function manageUserStatusFormatter(val){
		if(val == '1'){
			return "启用";
		}else if(val == '0'){
			return "<span style='color : red'>停用</span>";
		}
	}
	function manageUserGradeFormatter(val){
		if(val == '0'){
			return "普通用户";
		}else if(val == '1'){
			return "<span style='color : red'>管理员</span>";
		}
	}
	function doManageUserSearch(){
		var params = $('#manageUserTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields =$('#manageUserQueryForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each( fields, function(i, field){
			params[field.name] = field.value; //设置查询参数
		}); 
		$('#manageUserTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
	}
	function manageUserDeptFormatter(val){
		if(val.name != "未分配部门"){
			return val.name;
		} else{
			return "<span style='color:orange'>" + val.name + "</span>";
		}
	}
</script>
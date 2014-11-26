<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="onlineManageUserToolBar" style="padding:5px;height:auto">
    <table style="margin-bottom:5px;font-size: 12px;">
        <tr>
            <td>
                <span>自动刷新频率</span>
                <ui:numberbox value="${refreshSeconds}" id="refreshSeconds" maxLength="11"/>
                <span>秒</span>
            </td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<ui:linkButton id="userRefreshBtn" href="javascript:void(0)" onclick="" icon="icon-reload">手动刷新</ui:linkButton></td>
        </tr>
    </table>
</div>
<table id="onlineUserTables" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/manageUser/getOnlineManageUserList2.action',
    rownumbers : true,
    striped : true,
    fitColumns : true,
    toolbar : '#onlineManageUserToolBar',
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'username'" width="10">用户名</th>
            <th data-options="field : 'telephone'" width="10">手机号</th>
            <th data-options="field : 'email'" width="10">电子邮箱</th>
            <th data-options="field : 'grade',formatter:manageUserGradeFormatter2" width="10">级别</th>
            <th data-options="field : 'status',formatter:manageUserStatusFormatter2" width="10">状态</th>
            <th data-options="field : 'lastLoginTime'" width="10">登录时间</th>
            <th data-options="field : 'lastLoginIP'" width="10">登录ip</th>
        </tr>
    </thead>
</table>
<script type="text/javascript">
	$(function(){
		$("#onlineUserTables").everyTime(parseInt($("#refreshSeconds").val()) * 1000, refreshOnlineUsers);
		$("#refreshSeconds").blur(function(){
			if($(this).val() == ""){
				$(this).val("600");
			}
			$("#onlineUserTables").stopTime();
			$("#onlineUserTables").everyTime(parseInt($(this).val()) * 1000, refreshOnlineUsers);
		});
		$("#userRefreshBtn").click(function(){
			refreshOnlineUsers();
		});
	});
	function refreshOnlineUsers(){
		$("#onlineUserTables").datagrid("reload");
	}
	function manageUserStatusFormatter2(val){
		if(val == '1'){
			return "启用";
		}else if(val == '0'){
			return "<span style='color : red'>停用</span>";
		}
	}
	function manageUserGradeFormatter2(val){
		if(val == '0'){
			return "普通用户";
		}else if(val == '1'){
			return "<span style='color : red'>管理员</span>";
		}
	}
</script>
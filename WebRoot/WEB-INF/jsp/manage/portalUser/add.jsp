<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<script type="text/javascript">
	$(function(){
		$('#portalUserTypeId').combobox({
			valueField:'id', //值字段
		    textField:'name', //显示的字段
		    url:'manage/portalUserType/queryCombobox.action',
			editable:false//不可编辑，只能选择
		});
	});
</script>

<form action="${basePath}/manage/portalUser/add.action" method="post" id="add_portalUser_form">
    <table class="common_table">
        <tr>
            <th width="30%" align="right">用户类型：</th>
            <td width="70%"><input class="input_240" data-options="required:true" id="portalUserTypeId" type="text" name="portalUserTypeId"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">用户名：</th>
            <td width="70%"><input class="input_240 easyui-validatebox" data-options="required:true" type="text" name="username"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">密码：</th>
            <td width="70%"><input class="input_240 easyui-validatebox" data-options="required:true" type="password" name="password"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">手机：</th>
            <td width="70%"><input class="input_240" type="text" name="telephone"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">邮箱：</th>
            <td width="70%"><input class="input_240" type="text" name="email"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">备注：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute1"/></td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="portalUser.add()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="portalUser.cancelAdd()">关闭</a>
</div>
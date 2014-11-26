<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/manageUser/updateModifyPassword.action" method="post" id="manageUser_changePassword_form">
    <table class="common_table">
        <input type="hidden" value="${userInfo.id}" name="id"/>
        
        <tr>
            <th width="30%" align="right">用户名：</th>
            <td width="70%"><input class="input_240" type="text" value="${userInfo.username}" readonly="readonly"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">原密码：</th>
            <td width="70%"><input class="input_240 easyui-validatebox" required="true" validType="length[6,20]" type="password" name="password"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">新密码：</th>
            <td width="70%"><input class="input_240 easyui-validatebox" required="true" validType="length[6,20]" type="password" name="newPassword"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">重复新密码：</th>
            <td width="70%"><input class="input_240 easyui-validatebox" required="true" validType="length[6,20]" type="password" name="repeatNewPassword"/></td>
        </tr>
    </table>
</form>

<div class="floatright absolute_right_botton_10px">
    <div class="floatright">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageUser.modifyPassword()">修改</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageUser.cancelModifyPassword()">关闭</a>
    </div>

</div>
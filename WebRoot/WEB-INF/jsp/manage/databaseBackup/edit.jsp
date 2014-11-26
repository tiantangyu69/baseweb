<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/databaseBackup/edit.action" method="post" id="edit_databaseBackup_form">
    <table class="common_table">
        <input type="hidden" value="${databaseBackup.id}" name="id"/>
        
        <tr>
            <th width="30%" align="right">备份名称：</th>
            <td width="70%"><input class="input_240 easyui-validatebox" data-options="required:true" type="text" name="name" value="${databaseBackup.name}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">操作人：</th>
            <td width="70%"><input class="input_240" type="text" readonly="readonly" name="username" value="${databaseBackup.username}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">备注：</th>
            <td width="70%"><textarea class="textarea_240" name="remark">${databaseBackup.remark}</textarea></td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="databaseBackup.edit()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="databaseBackup.cancelEdit()">关闭</a>
</div>
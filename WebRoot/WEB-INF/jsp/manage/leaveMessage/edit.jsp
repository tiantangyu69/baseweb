<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/leaveMessage/edit.action" method="post" id="edit_leaveMessage_form">
    <table class="common_table">
        <input type="hidden" value="${leaveMessage.id}" name="id"/>
        
        <tr>
            <th width="30%" align="right">留言人：</th>
            <td width="70%"><input readonly="readonly" class="input_480" type="text" name="username" value="${leaveMessage.username}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">留言用户：</th>
            <td width="70%"><input readonly="readonly" class="input_480" type="text" name="attribute1" value="${leaveMessage.attribute1}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">电子邮件：</th>
            <td width="70%"><input readonly="readonly" class="input_480" type="text" name="email" value="${leaveMessage.email}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">电话：</th>
            <td width="70%"><input readonly="readonly" class="input_480" type="text" name="phone" value="${leaveMessage.phone}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">内容：</th>
            <td width="70%"><textarea readonly="readonly" class="textarea_480" type="text" name="content">${leaveMessage.content}</textarea></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">留言日期：</th>
            <td width="70%"><input readonly="readonly" class="input_480" type="text" name="deployTime" value="${leaveMessage.deployTime}"/></td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="leaveMessage.edit()">关闭</a>
</div>
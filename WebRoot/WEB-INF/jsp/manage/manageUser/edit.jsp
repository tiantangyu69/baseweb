<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/manageUser/edit.action" method="post" id="edit_manageUser_form">
    <table class="common_table">
        <input type="hidden" value="${manageUser.id}" name="id"/>
        
        <tr>
            <th width="30%" align="right">用户名：</th>
            <td width="70%">
                <input class="input_240 easyui-validatebox" data-options="required:true,validType:'uniqueUsername'" type="text" name="username" value="${manageUser.username}"/>
                <input type="hidden" value="${manageUser.username}" id="olderUsername"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">所属部门：</th>
            <td width="70%">
                <input name="department" value="${manageUser.department}" class="easyui-combotree input_240" data-options="url:'${basePath}manage/department/queryCombox.action',method:'get'"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">用户级别：</th>
            <td>
                <select name="grade" class="input_240">
                    <option value="0" <c:if test="${manageUser.grade == 0}">selected="selected"</c:if>>普通用户</option>
                    <option value="1" <c:if test="${manageUser.grade == 1}">selected="selected"</c:if>>管理员</option>
                </select>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">手机：</th>
            <td width="70%"><input class="input_240" type="text" name="telephone" value="${manageUser.telephone}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">邮箱：</th>
            <td width="70%"><ui:emailbox cssClass="input_240" name="email" value="${manageUser.email}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">状态：</th>
            <td width="70%">
                <select name="status" class="input_240">
                    <option value="1" <c:if test="${manageUser.status == 1}">selected="selected"</c:if>>启用</option>
                    <option value="0" <c:if test="${manageUser.status == 0}">selected="selected"</c:if>>停用</option>
                </select>
            </td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageUser.edit()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageUser.cancelEdit()">关闭</a>
</div>
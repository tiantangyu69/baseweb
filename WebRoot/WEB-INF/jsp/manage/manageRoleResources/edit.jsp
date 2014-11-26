<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/manageRoleResources/edit.action" method="post" id="edit_manageRoleResources_form">
    <table class="common_table">
        <input type="hidden" value="${manageRoleResources.id}" name="id"/>
        
        <tr>
            <th width="30%" align="right">角色id：</th>
            <td width="70%"><input class="input_240" type="text" name="manageRoleId" value="${manageRoleResources.manageRoleId}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">资源id：</th>
            <td width="70%"><input class="input_240" type="text" name="resourceId" value="${manageRoleResources.resourceId}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute1：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute1" value="${manageRoleResources.attribute1}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute2：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute2" value="${manageRoleResources.attribute2}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute3：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute3" value="${manageRoleResources.attribute3}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute4：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute4" value="${manageRoleResources.attribute4}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute5：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute5" value="${manageRoleResources.attribute5}"/></td>
        </tr>
    </table>
    <div class="floatright">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageRoleResources.edit()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageRoleResources.cancelEdit()">关闭</a>
    </div>
</form>
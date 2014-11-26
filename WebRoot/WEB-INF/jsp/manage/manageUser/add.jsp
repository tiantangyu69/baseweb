<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/manageUser/add.action" method="post" id="add_manageUser_form">
    <table class="common_table">
        <tr>
            <th width="30%" align="right">用户名：</th>
            <td width="70%"><input class="input_240 easyui-validatebox" data-options="required:true,validType:'uniqueUsername'" type="text" name="username"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">所属部门：</th>
            <td width="70%">
                <input name="department" class="easyui-combotree input_240" data-options="url:'${basePath}manage/department/queryCombox.action',method:'get'"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">用户级别：</th>
            <td width="70%">
                <select name="grade" class="input_240">
                    <option value="0" selected="selected">普通用户</option>
                    <option value="1">管理员</option>
                </select>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">手机：</th>
            <td width="70%"><input class="input_240" type="text" name="telephone"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">邮箱：</th>
            <td width="70%"><ui:emailbox cssClass="input_240" name="email"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">状态：</th>
            <td width="70%">
                <select name="status" class="input_240">
                    <option value="1" selected="selected">启用</option>
                    <option value="0">停用</option>
                </select>
            </td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageUser.add()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageUser.cancelAdd()">关闭</a>
</div>
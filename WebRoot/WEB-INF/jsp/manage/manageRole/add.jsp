<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/manageRole/add.action" method="post" id="add_manageRole_form">
    <table class="common_table">
        <tr>
            <th width="30%" align="right">角色名称：</th>
            <td width="70%"><input class="input_240 easyui-validatebox" data-options="required:true" type="text" name="name"/></td>
        </tr>
        <tr>
            <th width="30%" align="right" valign="top">角色描述：</th>
            <td width="70%">
                <textarea rows="2" cols="2" class="textarea_240" name="description"></textarea>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">角色排序：</th>
            <td width="70%"><ui:numberbox cssClass="input_240" name="sort"/></td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageRole.add()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageRole.cancelAdd()">关闭</a>
</div>
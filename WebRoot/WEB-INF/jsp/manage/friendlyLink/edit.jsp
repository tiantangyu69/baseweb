<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/friendlyLink/edit.action" method="post" id="edit_friendlyLink_form">
    <table class="common_table">
        <input type="hidden" value="${friendlyLink.id}" name="id"/>
        
        <tr>
            <th width="30%" align="right">链接名：</th>
            <td width="70%"><input class="input_240 easyui-validatebox" data-options="required:true" type="text" name="name" value="${friendlyLink.name}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">链接地址：</th>
            <td width="70%"><input class="input_240 easyui-validatebox" data-options="required:true,validType:'url'" type="text" name="url" value="${friendlyLink.url}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">排序：</th>
            <td width="70%"><input class="input_240 easyui-numberbox" type="text" name="sort" value="${friendlyLink.sort}"/></td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="friendlyLink.edit()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="friendlyLink.cancelEdit()">关闭</a>
</div>
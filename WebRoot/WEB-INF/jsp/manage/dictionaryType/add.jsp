<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/dictionaryType/add.action" method="post" id="add_dictionaryType_form">
    <table class="common_table">
        <tr>
            <th width="30%" align="right">类型名称：</th>
            <td width="70%"><input class="input_240 easyui-validatebox" data-options="required:true" type="text" name="name"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">备注：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute1"/></td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="dictionaryType.add()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="dictionaryType.cancelAdd()">关闭</a>
</div>
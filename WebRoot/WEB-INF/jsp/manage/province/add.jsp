<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/province/add.action" method="post" id="add_province_form">
    <table class="common_table">
        <tr>
            <th width="30%" align="right">省市名：</th>
            <td width="70%"><input class="input_240 easyui-validatebox" data-options="required:true" type="text" name="name"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">排序：</th>
            <td width="70%"><input class="input_240 easyui-numberbox" type="text" name="sort"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">说明：</th>
            <td width="70%"><input class="input_240" type="text" name="remark"/></td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="province.add()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="province.cancelAdd()">关闭</a>
</div>
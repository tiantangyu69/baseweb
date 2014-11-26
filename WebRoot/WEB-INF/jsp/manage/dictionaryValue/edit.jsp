<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<script type="text/javascript">
	$(function(){
		$('#updateDictionaryTypeId').combobox({
			valueField:'id', //值字段
		    textField:'name', //显示的字段
		    url:'manage/dictionaryType/queryCombobox.action',
			editable:false//不可编辑，只能选择
		});
	});
</script>

<form action="${basePath}/manage/dictionaryValue/edit.action" method="post" id="edit_dictionaryValue_form">
    <table class="common_table">
        <input type="hidden" value="${dictionaryValue.id}" name="id"/>
        
        <tr>
            <th width="30%" align="right">字典类型：</th>
            <td width="70%"><input id="updateDictionaryTypeId" class="input_240" data-options="required:true" type="text" name="dictionaryTypeId" value="${dictionaryValue.dictionaryTypeId}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">字典值：</th>
            <td width="70%"><input class="input_240 easyui-validatebox" data-options="required:true" type="text" name="value" value="${dictionaryValue.value}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">备注：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute1" value="${dictionaryValue.attribute1}"/></td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="dictionaryValue.edit()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="dictionaryValue.cancelEdit()">关闭</a>
</div>
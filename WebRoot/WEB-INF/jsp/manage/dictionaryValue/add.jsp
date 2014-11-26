<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<script type="text/javascript">
	$(function(){
		$('#dictionaryTypeId').combobox({
			valueField:'id', //值字段
		    textField:'name', //显示的字段
		    url:'manage/dictionaryType/queryCombobox.action',
			editable:false//不可编辑，只能选择
		});
	});
</script>

<form action="${basePath}/manage/dictionaryValue/add.action" method="post" id="add_dictionaryValue_form">
    <table class="common_table">
        <tr>
            <th width="30%" align="right">字典类型：</th>
            <td width="70%"><input id="dictionaryTypeId" class="input_240" data-options="required:true" type="text" name="dictionaryTypeId"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">字典值：</th>
            <td width="70%"><input class="input_240 easyui-validatebox" data-options="required:true" type="text" name="value"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">备注：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute1"/></td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="dictionaryValue.add()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="dictionaryValue.cancelAdd()">关闭</a>
</div>
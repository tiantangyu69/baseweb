<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<script type="text/javascript">
	$(function(){
		$('#updateSinglePageTypeId').combobox({
			valueField:'id', //值字段
		    textField:'name', //显示的字段
		    url:'manage/singlePageType/queryCombobox.action',
			editable:false//不可编辑，只能选择
		});
	});
</script>

<form action="${basePath}/manage/singlePage/edit.action" method="post" id="edit_singlePage_form">
    <table class="common_table">
        <input type="hidden" value="${singlePage.id}" name="id"/>
        
        <tr>
            <th width="10%" align="right">单页名称：</th>
            <td width="90%"><input class="input_240 easyui-validatebox" data-options="required:true" type="text" name="name" value="${singlePage.name}"/></td>
        </tr>
        
        <tr>
            <th width="10%" align="right">单页类型：</th>
            <td width="90%"><input id="updateSinglePageTypeId" class="input_240" data-options="required:true" type="text" name="singlePageTypeId" value="${singlePage.singlePageTypeId}"/></td>
        </tr>
        
        <tr>
            <th width="10%" align="right">单页内容：</th>
            <td width="90%"><textarea id="updateSinglePageContent" style="height: 400px;" type="text" name="content">${singlePage.content}</textarea></td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="singlePage.edit()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="singlePage.cancelEdit()">关闭</a>
</div>

<script type="text/javascript">
	var singlePageEditor2 = new UE.ui.Editor();
	singlePageEditor2.render('updateSinglePageContent');
</script>
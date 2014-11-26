<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<script type="text/javascript">
	$(function(){
		$('#singlePageTypeId').combobox({
			valueField:'id', //值字段
		    textField:'name', //显示的字段
		    url:'manage/singlePageType/queryCombobox.action',
			editable:false//不可编辑，只能选择
		});
	});
</script>

<form action="${basePath}/manage/singlePage/add.action" method="post" id="add_singlePage_form">
    <table class="common_table">
        <tr>
            <th width="10%" align="right">单页名称：</th>
            <td width="90%"><input class="input_240 easyui-validatebox" data-options="required:true" type="text" name="name"/></td>
        </tr>
        <tr>
            <th width="10%" align="right">单页类型：</th>
            <td width="90%"><input id="singlePageTypeId" class="input_240" data-options="required:true" type="text" name="singlePageTypeId"/></td>
        </tr>
        <tr>
            <th width="10%" align="right">单页内容：</th>
            <td width="90%"><textarea id="addSinglePageContent" style="height: 400px;" name="content" cols="2" rows="2"></textarea></td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="singlePage.add()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="singlePage.cancelAdd()">关闭</a>
</div>

<script type="text/javascript">
	var singlePageEditor = new UE.ui.Editor();
	singlePageEditor.render('addSinglePageContent');
</script>
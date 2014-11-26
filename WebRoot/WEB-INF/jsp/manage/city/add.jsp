<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<script type="text/javascript">
	$(function(){
		$('#provinceId').combobox({
			valueField:'id', //值字段
		    textField:'name', //显示的字段
		    url:'${basePath}provinceCombobox.action',
			editable:false//不可编辑，只能选择
		});
	});
</script>

<form action="${basePath}/manage/city/add.action" method="post" id="add_city_form">
    <table class="common_table">
        <tr>
            <th width="30%" align="right">所属省市：</th>
            <td width="70%"><input id="provinceId" class="input_240" data-options="required:true" type="text" name="provinceId"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">城市名：</th>
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
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="city.add()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="city.cancelAdd()">关闭</a>
</div>
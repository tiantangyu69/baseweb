<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<script type="text/javascript">
	$(function(){
		$('#updatePortalUserTypeId').combobox({
			valueField:'id', //值字段
		    textField:'name', //显示的字段
		    url:'manage/portalUserType/queryCombobox.action',
			editable:false//不可编辑，只能选择
		});
	});
</script>

<form action="${basePath}/manage/portalUser/edit.action" method="post" id="edit_portalUser_form">
    <table class="common_table">
        <input type="hidden" value="${portalUser.id}" name="id"/>
        
        <tr>
            <th width="30%" align="right">用户类型：</th>
            <td width="70%"><input class="input_240" readonly="readonly" type="text" name="portalUserTypeId" id="updatePortalUserTypeId" value="${portalUser.portalUserTypeId}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">用户名：</th>
            <td width="70%"><input class="input_240" readonly="readonly" type="text" name="username" value="${portalUser.username}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">联系人：</th>
            <td width="70%"><input class="input_240" readonly="readonly" type="text" name="username" value="${portalUser.attribute6}"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">手机：</th>
            <td width="70%"><input readonly="readonly" class="input_240" type="text" name="telephone" value="${portalUser.telephone}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">邮箱：</th>
            <td width="70%"><input readonly="readonly" class="input_240" type="text" name="email" value="${portalUser.email}"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">公司名称：</th>
            <td width="70%"><input class="input_240" readonly="readonly" type="text" name="username" value="${portalUser.attribute8}"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">公司地址：</th>
            <td width="70%"><input class="input_240" readonly="readonly" type="text" name="username" value="${portalUser.attribute9}"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">公司电话：</th>
            <td width="70%"><input class="input_240" readonly="readonly" type="text" name="username" value="${portalUser.attribute10}"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">公司传真：</th>
            <td width="70%"><input class="input_240" readonly="readonly" type="text" name="username" value="${portalUser.attribute11}"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">所在省市：</th>
            <td width="70%"><input class="input_240" readonly="readonly" type="text" name="username" value="${portalUser.attribute4}${portalUser.attribute5} "/></td>
        </tr>
        <tr>
            <th width="30%" align="right">备注：</th>
            <td width="70%"><input readonly="readonly" class="input_240" type="text" name="attribute1" value="${portalUser.attribute1}"/></td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="portalUser.validate2(${portalUser.id}, '1')">审核通过</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="portalUser.validate2(${portalUser.id}, '2')">审核不通过</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="portalUser.validateClose()">关闭</a>
</div>
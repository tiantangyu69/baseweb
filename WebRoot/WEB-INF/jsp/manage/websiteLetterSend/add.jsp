<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<script type="text/javascript">
    $(function(){
        $('#websiteLetterReceiveUser').combogrid({
            panelWidth:400,
            url: '${basePath}manage/manageUser/queryCombobox.action',
            multiple: true,
            idField:'username',
            textField:'username',
            mode:'remote',
            fitColumns:true,
			editable:false,//不可编辑，只能选择
            columns:[[
                {field:'ck',checkbox:true},
                {field:'username',title:'用户名',width:150},
                {field:'telephone',title:'手机',width:150}
            ]]
        });
    });
</script>

<form action="${basePath}/manage/websiteLetterSend/add.action" method="post" id="add_websiteLetterSend_form">
    <table class="common_table">
        <tr>
            <th width="10%" align="right">主题：</th>
            <td width="90%"><input class="input_480 easyui-validatebox" data-options="required:true" type="text" name="title"/></td>
        </tr>
        <tr>
            <th align="right">接收人：</th>
            <td><input id="websiteLetterReceiveUser" class="input_480" data-options="required:true" type="text" name="receiveUser"/></td>
        </tr>
        <tr>
            <th align="right">发送人：</th>
            <td>
                <input type="hidden" name="manageUserId"  value="${sessionScope.user.id}"/>
                <input class="input_240" type="text" readonly="readonly" value="${sessionScope.user.username}"/>
            </td>
        </tr>
        <tr>
            <th align="right">内容：</th>
            <td>
                <ui:UEditor id="websiteLetterContent${jg:uuid()}" cssClass="common_editor" name="content"/>
            </td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="websiteLetterSend.add()">发送</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="websiteLetterSend.cancelAdd()">关闭</a>
</div>
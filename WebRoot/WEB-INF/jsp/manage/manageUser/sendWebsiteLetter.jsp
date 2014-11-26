<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/websiteLetterReceive/edit.action" method="post" id="sendWebsiteLetterReceive_form">
    <table class="common_table">
        <tr>
            <th width="30%" align="right">主题：</th>
            <td width="70%"><input class="input_480 easyui-validatebox" data-options="required:true" type="text" name="title"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">发送人：</th>
            <td width="70%">
                <input type="hidden" value="${sessionScope.user.id}" name="manageUserId"/>
                <input readonly="readonly" class="input_240" type="text" value="${sessionScope.user.username}"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">接收人：</th>
            <td width="70%"><input readonly="readonly" class="input_240" type="text" name="receiveUser" value="${sendUser}"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">内容：</th>
            <td width="70%">
                <textarea id="websiteReceiveLetterContent2" cols="2" rows="2" class="common_editor" name="content"></textarea>  
            </td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageUser.sendWebsiteLetter()">发送</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageUser.cancelSendWebsiteLetter()">关闭</a>
</div>

<script type="text/javascript">
	var websiteReceiveLetterEditor2 = new UE.ui.Editor();
	websiteReceiveLetterEditor2.render('websiteReceiveLetterContent2');
</script>
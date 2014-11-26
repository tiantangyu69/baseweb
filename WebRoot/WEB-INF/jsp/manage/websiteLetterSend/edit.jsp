<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/websiteLetterSend/edit.action" method="post" id="edit_websiteLetterSend_form">
    <table class="common_table">
        <input type="hidden" value="${websiteLetterSend.id}" name="id"/>
        
        <tr>
            <th width="30%" align="right">主题：</th>
            <td width="70%"><input class="input_240" type="text" name="title" value="${websiteLetterSend.title}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">内容：</th>
            <td width="70%"><input class="input_240" type="text" name="content" value="${websiteLetterSend.content}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">发送人：</th>
            <td width="70%"><input class="input_240" type="text" name="manageUserId" value="${websiteLetterSend.manageUserId}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">接收人：</th>
            <td width="70%"><input class="input_240" type="text" name="receiveUser" value="${websiteLetterSend.receiveUser}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">发送时间：</th>
            <td width="70%"><input class="input_240" type="text" name="sendTime" value="${websiteLetterSend.sendTime}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute1：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute1" value="${websiteLetterSend.attribute1}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute2：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute2" value="${websiteLetterSend.attribute2}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute3：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute3" value="${websiteLetterSend.attribute3}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute4：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute4" value="${websiteLetterSend.attribute4}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute5：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute5" value="${websiteLetterSend.attribute5}"/></td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="websiteLetterSend.edit()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="websiteLetterSend.cancelEdit()">关闭</a>
</div>
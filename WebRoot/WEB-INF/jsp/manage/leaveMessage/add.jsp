<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/leaveMessage/add.action" method="post" id="add_leaveMessage_form">
    <table class="common_table">
        <tr>
            <th width="30%" align="right">留言人：</th>
            <td width="70%"><input class="input_240" type="text" name="username"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">电子邮件：</th>
            <td width="70%"><input class="input_240" type="text" name="email"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">电话：</th>
            <td width="70%"><input class="input_240" type="text" name="phone"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">内容：</th>
            <td width="70%"><input class="input_240" type="text" name="content"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">留言日期：</th>
            <td width="70%"><input class="input_240" type="text" name="deployTime"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">留言状态：</th>
            <td width="70%"><input class="input_240" type="text" name="status"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">attribute1：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute1"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">attribute2：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute2"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">attribute3：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute3"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">attribute4：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute4"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">attribute5：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute5"/></td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="leaveMessage.add()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="leaveMessage.cancelAdd()">关闭</a>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/websiteAccessRecords/add.action" method="post" id="add_websiteAccessRecords_form">
    <table class="common_table">
        <tr>
            <th width="30%" align="right">访问者ip：</th>
            <td width="70%"><input class="input_240" type="text" name="ip"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">来源：</th>
            <td width="70%"><input class="input_240" type="text" name="source"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">访问者：</th>
            <td width="70%"><input class="input_240" type="text" name="viewUser"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">访问者session：</th>
            <td width="70%"><input class="input_240" type="text" name="viewSession"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">浏览器版本：</th>
            <td width="70%"><input class="input_240" type="text" name="browserVersion"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">访问日期：</th>
            <td width="70%"><input class="input_240" type="text" name="viewDate"/></td>
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
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="websiteAccessRecords.add()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="websiteAccessRecords.cancelAdd()">关闭</a>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/websiteAccessRecords/edit.action" method="post" id="edit_websiteAccessRecords_form">
    <table class="common_table">
        <input type="hidden" value="${websiteAccessRecords.id}" name="id"/>
        
        <tr>
            <th width="30%" align="right">访问者ip：</th>
            <td width="70%"><input class="input_240" type="text" name="ip" value="${websiteAccessRecords.ip}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">来源：</th>
            <td width="70%"><input class="input_240" type="text" name="source" value="${websiteAccessRecords.source}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">访问者：</th>
            <td width="70%"><input class="input_240" type="text" name="viewUser" value="${websiteAccessRecords.viewUser}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">访问者session：</th>
            <td width="70%"><input class="input_240" type="text" name="viewSession" value="${websiteAccessRecords.viewSession}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">浏览器版本：</th>
            <td width="70%"><input class="input_240" type="text" name="browserVersion" value="${websiteAccessRecords.browserVersion}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">访问日期：</th>
            <td width="70%"><input class="input_240" type="text" name="viewDate" value="${websiteAccessRecords.viewDate}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute1：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute1" value="${websiteAccessRecords.attribute1}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute2：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute2" value="${websiteAccessRecords.attribute2}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute3：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute3" value="${websiteAccessRecords.attribute3}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute4：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute4" value="${websiteAccessRecords.attribute4}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute5：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute5" value="${websiteAccessRecords.attribute5}"/></td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="websiteAccessRecords.edit()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="websiteAccessRecords.cancelEdit()">关闭</a>
</div>
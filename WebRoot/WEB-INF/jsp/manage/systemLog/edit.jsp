<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/systemLog/edit.action" method="post" id="edit_systemLog_form">
    <table class="common_table">
        <input type="hidden" value="${systemLog.id}" name="id"/>
        
        <tr>
            <th width="30%" align="right">操作栏目：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,100]" name="name" value="${systemLog.name}"/>
            </td>
        </tr>
        
        <tr>
            <th width="30%" align="right">操作动作：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,30]" name="optionName" value="${systemLog.optionName}"/>
            </td>
        </tr>
        
        <tr>
            <th width="30%" align="right">操作属性：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,100]" name="property" value="${systemLog.property}"/>
            </td>
        </tr>
        
        <tr>
            <th width="30%" align="right">操作人：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,150]" name="username" value="${systemLog.username}"/>
            </td>
        </tr>
        
        <tr>
            <th width="30%" align="right">操作人IP：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,50]" name="ip" value="${systemLog.ip}"/>
            </td>
        </tr>
        
        <tr>
            <th width="30%" align="right">浏览器：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,30]" name="webbrowser" value="${systemLog.webbrowser}"/>
            </td>
        </tr>
        
        <tr>
            <th width="30%" align="right">操作时间：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,30]" name="optTime" value="${systemLog.optTime}"/>
            </td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute1：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,255]" name="attribute1" value="${systemLog.attribute1}"/>
            </td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute2：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,255]" name="attribute2" value="${systemLog.attribute2}"/>
            </td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute3：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,255]" name="attribute3" value="${systemLog.attribute3}"/>
            </td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute4：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,255]" name="attribute4" value="${systemLog.attribute4}"/>
            </td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute5：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,255]" name="attribute5" value="${systemLog.attribute5}"/>
            </td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="systemLog.edit()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="systemLog.cancelEdit()">关闭</a>
</div>
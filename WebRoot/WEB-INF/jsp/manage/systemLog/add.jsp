<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/systemLog/add.action" method="post" id="add_systemLog_form">
    <table class="common_table">
        <tr>
            <th width="30%" align="right">操作栏目：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,100]" name="name"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">操作动作：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,30]" name="optionName"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">操作属性：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,100]" name="property"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">操作人：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,150]" name="username"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">操作人IP：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,50]" name="ip"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">浏览器：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,30]" name="webbrowser"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">操作时间：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,30]" name="optTime"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">attribute1：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,255]" name="attribute1"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">attribute2：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,255]" name="attribute2"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">attribute3：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,255]" name="attribute3"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">attribute4：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,255]" name="attribute4"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">attribute5：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,255]" name="attribute5"/>
            </td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="systemLog.add()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="systemLog.cancelAdd()">关闭</a>
</div>
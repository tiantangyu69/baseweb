<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/systemLogConfig/edit.action" method="post" id="edit_systemLogConfig_form">
    <table class="common_table">
        <input type="hidden" value="${systemLogConfig.id}" name="id"/>
        <tr>
            <th width="30%" align="right">日志类型：</th>
            <td width="70%">
                <ui:combobox value="${systemLogConfig.attribute1}" cssClass="input_240" name="attribute1" url="${basePath}manage/dictionaryValue/queryCombobox.action?dictionaryTypeId=3" textField="value" valueField="value"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">操作栏目：</th>
            <td width="70%">
                <ui:input cssClass="input_240"  required="true" validType="length[1,100]"  name="name" value="${systemLogConfig.name}"/>
            </td>
        </tr>
        
        <tr>
            <th width="30%" align="right">操作动作：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  required="true" validType="length[1,30]"  name="optionName" value="${systemLogConfig.optionName}"/>
            </td>
        </tr>
        
        <tr>
            <th width="30%" align="right">操作属性：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,100]" name="property" value="${systemLogConfig.property}"/>
            </td>
        </tr>
        
        <tr>
            <th width="30%" align="right">过滤路径：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,150]" name="url" value="${systemLogConfig.url}"/>
            </td>
        </tr>
        
        <tr>
            <th width="30%" align="right">是否进行日志记录：</th>
            <td width="70%">
                <input type="radio" value="true" name="record" <c:if test="${systemLogConfig.record == true}"> checked="checked"</c:if>/>
                <span>是</span>
                <input type="radio" value="false" name="record" <c:if test="${systemLogConfig.record == false}"> checked="checked"</c:if>/>
                <span>否</span>
            </td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="systemLogConfig.edit()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="systemLogConfig.cancelEdit()">关闭</a>
</div>
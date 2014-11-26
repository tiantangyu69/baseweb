<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${'$'}{basePath}/manage/${entityName ? uncap_first}/edit.action" method="post" id="edit_${entityName ? uncap_first}_form">
    <table class="common_table">
        <#list columnList as f>
        <#if f.name == 'id'><input type="hidden" value="${'$'}{${entityName ? uncap_first}.${f.name}}" name="${f.name}"/></#if>
        <#if f.name != 'id'>
        <tr>
            <th width="30%" align="right">${f.nameCN}：</th>
            <td width="70%">
                <#if f.type == 'Integer'><ui:numberbox cssClass="input_240" name="${f.name}" value="${'$'}{${entityName ? uncap_first}.${f.name}}"/></#if>
                <#if f.type == 'String'><ui:input cssClass="input_240" <#if f.required == true> required="true" validType="length[1,${f.length}]"</#if> <#if f.required == false>validType="length[0,${f.length}]"</#if> name="${f.name}" value="${'$'}{${entityName ? uncap_first}.${f.name}}"/></#if>
            </td>
        </tr>
        </#if>
        </#list>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="${entityName ? uncap_first}.edit()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="${entityName ? uncap_first}.cancelEdit()">关闭</a>
</div>
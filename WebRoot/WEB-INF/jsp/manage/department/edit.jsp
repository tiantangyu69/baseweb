<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/department/edit.action" method="post" id="edit_department_form">
    <table class="common_table">
        <input type="hidden" value="${department.id}" name="id"/>
        
        <tr>
            <th width="30%" align="right">部门名称：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[1,50]" required="true" name="name" value="${department.name}"/>
            </td>
        </tr>
        
        <tr>
            <th width="30%" align="right">职能描述：</th>
            <td width="70%">
                
                <ui:input cssClass="input_240"  validType="length[0,500]" name="url" value="${department.url}"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">上级部门：</th>
            <td width="70%">
                <input value="${department.parentDepartment}" name="parentDepartment" class="easyui-combotree input_240" data-options="url:'${basePath}manage/department/queryCombox2.action',method:'get'"/>
                <span style="color: gray;">留空则为无上级部门</span>
            </td>
        </tr>
        
        <tr>
            <th width="30%" align="right">排序：</th>
            <td width="70%">
                <ui:numberbox cssClass="input_240" name="sort" value="${department.sort}"/>
                
            </td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="department.edit()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="department.cancelEdit()">关闭</a>
</div>
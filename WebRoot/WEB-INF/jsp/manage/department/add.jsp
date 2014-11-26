<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/department/add.action" method="post" id="add_department_form">
    <table class="common_table">
        <tr>
            <th width="30%" align="right">部门名称：</th>
            <td width="70%">
                <ui:input cssClass="input_240" required="true" validType="length[0,50]" name="name"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">职能描述：</th>
            <td width="70%">
                <ui:input cssClass="input_240"  validType="length[0,500]" name="url"/>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">上级部门：</th>
            <td width="70%">
                <input name="parentDepartment" class="easyui-combotree input_240" data-options="url:'${basePath}manage/department/queryCombox2.action',method:'get'"/>
                <span style="color: gray;">留空则为无上级部门</span>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">排序：</th>
            <td width="70%">
                <ui:numberbox cssClass="input_240" name="sort"/>
                
            </td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="department.add()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="department.cancelAdd()">关闭</a>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/manageMenu/edit.action" method="post" id="edit_manageMenu_form">
    <table class="common_table">
        <input type="hidden" value="${manageMenu.id}" name="id"/>
        <tr>
            <th width="30%" align="right">菜单名称：</th>
            <td width="70%"><input class="input_240 easyui-validatebox" data-options="required:true" type="text" name="name" value="${manageMenu.name}"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">菜单类型：</th>
            <td width="70%">
                <select name="type" class="input_240">
                    <option value="1" <c:if test="${manageMenu.type == 1}">selected="selected"</c:if>>后台菜单</option>
                    <option value="2" <c:if test="${manageMenu.type == 2}">selected="selected"</c:if>>前台菜单</option>
                    <option value="3" <c:if test="${manageMenu.type == 3}">selected="selected"</c:if>>开发菜单</option>
                </select>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">上级菜单：</th>
            <td width="70%">
                <select name="parentId" class="input_240">
                    <option value="-1" <c:if test="${-1 == manageMenu.parentId}">selected="selected"</c:if>>无上级</option>
                    <c:forEach var="m" items="${menuList}">
                        <option value="${m.id}" <c:if test="${m.id == manageMenu.parentId}">selected="selected"</c:if>>- ${m.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">菜单路径：</th>
            <td width="70%"><input class="input_240" type="text" name="url" value="${manageMenu.url}"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">排序：</th>
            <td width="70%"><input class="input_240 easyui-numberbox" type="text" name="sort" value="${manageMenu.sort}"/></td>
        </tr>
    </table>
    <div class="floatright absolute_right_botton_10px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageMenu.edit(true)">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageMenu.cancelEdit()">关闭</a>
    </div>
</form>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/manageMenu/add.action" method="post" id="add_manageMenu_form">
    <table class="common_table">
        <tr>
            <th width="30%" align="right">菜单名称：</th>
            <td width="70%"><input class="input_240 easyui-validatebox" data-options="required:true" type="text" name="name"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">菜单类型：</th>
            <td width="70%">
                <select name="type" class="input_240">
                    <option value="1" selected="selected">后台菜单</option>
                    <option value="2">前台菜单</option>
                    <option value="3">开发菜单</option>
                </select>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">上级菜单：</th>
            <td width="70%">
                <select name="parentId" class="input_240">
                    <option value="-1" selected="selected">无上级</option>
                    <c:forEach var="m" items="${menuList}">
                        <option value="${m.id}">- ${m.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">菜单路径：</th>
            <td width="70%"><input class="input_240" type="text" name="url"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">排序：</th>
            <td width="70%"><input class="input_240 easyui-numberbox" type="text" name="sort"/></td>
        </tr>
    </table>
    <div class="floatright absolute_right_botton_10px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageMenu.add(true)">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageMenu.cancelAdd()">关闭</a>
    </div>
</form>
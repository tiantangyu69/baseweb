<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/manageUserRole/add.action" method="post" id="add_manageUserRole_form">
    <table class="common_table">
        <tr>
            <th width="30%" align="right">用户id：</th>
            <td width="70%"><input class="input_240" type="text" name="userId"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">角色id：</th>
            <td width="70%"><input class="input_240" type="text" name="roleId"/></td>
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
    <div class="floatright">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageUserRole.add()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageUserRole.cancelAdd()">关闭</a>
    </div>
</form>
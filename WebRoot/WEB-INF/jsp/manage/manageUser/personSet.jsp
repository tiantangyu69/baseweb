<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/manageUser/edit.action" method="post" id="manageUser_personset_form">
    <table class="common_table">
        <input type="hidden" value="${userInfo.id}" name="id"/>
        
        <tr>
            <th width="30%" align="right">用户名：</th>
            <td width="70%"><input class="input_240" type="text" name="username" value="${userInfo.username}" readonly="readonly"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">真实姓名：</th>
            <td width="70%"><input class="input_240" type="text" name="trueName" value="${userInfo.trueName}"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">性别：</th>
            <td width="70%">
                <input type="radio" name="sex" value="男" <c:if test="${userInfo.sex=='男'}"> checked="checked"</c:if>/>男
                <input type="radio" name="sex" value="女" <c:if test="${userInfo.sex=='女'}"> checked="checked"</c:if>/>女
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">出生日期：</th>
            <td width="70%"><input class="input_240 Wdate" onClick="WdatePicker()" type="text" name="birthday" readonly="readonly" value="${userInfo.birthday}"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">身份证号：</th>
            <td width="70%"><ui:input cssClass="input_240" name="idCard" validType="idCard" value="${userInfo.idCard}"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">手机：</th>
            <td width="70%"><ui:input validType="telephone" cssClass="input_240" name="telephone" value="${userInfo.telephone}"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">邮箱：</th>
            <td width="70%"><ui:emailbox cssClass="input_240" name="email" value="${userInfo.email}"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">状态：</th>
            <td width="70%">
                <select class="input_240" disabled="disabled">
                    <option value="1" <c:if test="${userInfo.status == 1}">selected="selected"</c:if>>启用</option>
                    <option value="0" <c:if test="${userInfo.status == 0}">selected="selected"</c:if>>停用</option>
                </select>
            </td>
        </tr>
        <tr>
            <th width="30%" align="right">上次登录时间：</th>
            <td width="70%"><input readonly="readonly" class="input_240" type="text" value="${sessionScope.user.lastLoginTime}"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">上次登录ip：</th>
            <td width="70%"><input readonly="readonly" class="input_240" type="text" value="${sessionScope.user.lastLoginIP}"/></td>
        </tr>
    </table>
</form>

<div class="floatright absolute_right_botton_10px">
    <div class="floatright">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageUser.personSet()">保存设置</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="manageUser.cancelPersonSet()">关闭</a>
    </div>

</div>
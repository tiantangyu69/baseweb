<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/resources/edit.action" method="post" id="edit_resources_form">
    <table class="common_table">
        <input type="hidden" value="${resources.id}" name="id"/>
        
        <tr>
            <th width="30%" align="right">资源代码：</th>
            <td width="70%"><input class="input_240" type="text" name="code" value="${resources.code}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">资源名称：</th>
            <td width="70%"><input class="input_240" type="text" name="name" value="${resources.name}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">资源类型：</th>
            <td width="70%"><input class="input_240" type="text" name="resourceType" value="${resources.resourceType}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">资源路径：</th>
            <td width="70%"><input class="input_240" type="text" name="url" value="${resources.url}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">上级资源：</th>
            <td width="70%"><input class="input_240" type="text" name="parentId" value="${resources.parentId}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute1：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute1" value="${resources.attribute1}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute2：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute2" value="${resources.attribute2}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute3：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute3" value="${resources.attribute3}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute4：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute4" value="${resources.attribute4}"/></td>
        </tr>
        
        <tr>
            <th width="30%" align="right">attribute5：</th>
            <td width="70%"><input class="input_240" type="text" name="attribute5" value="${resources.attribute5}"/></td>
        </tr>
    </table>
    <div class="floatright">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="resources.edit()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="resources.cancelEdit()">关闭</a>
    </div>
</form>
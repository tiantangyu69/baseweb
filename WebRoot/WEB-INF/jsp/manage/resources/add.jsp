<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}/manage/resources/add.action" method="post" id="add_resources_form">
    <table class="common_table">
        <tr>
            <th width="30%" align="right">资源代码：</th>
            <td width="70%"><input class="input_240" type="text" name="code"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">资源名称：</th>
            <td width="70%"><input class="input_240" type="text" name="name"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">资源类型：</th>
            <td width="70%"><input class="input_240" type="text" name="resourceType"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">资源路径：</th>
            <td width="70%"><input class="input_240" type="text" name="url"/></td>
        </tr>
        <tr>
            <th width="30%" align="right">上级资源：</th>
            <td width="70%"><input class="input_240" type="text" name="parentId"/></td>
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
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="resources.add()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="resources.cancelAdd()">关闭</a>
    </div>
</form>
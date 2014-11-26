<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="websiteAccessRecordsToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="websiteAccessRecords.deleteByIds();">删除访问记录</a>
    </div>
</div>

<table id="websiteAccessRecordsTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/websiteAccessRecords/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#websiteAccessRecordsToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'ip'" width="10">访问者ip</th>
            <th data-options="field : 'source'" width="10">来源</th>
            <th data-options="field : 'viewUser'" width="10">访问者</th>
            <th data-options="field : 'browserVersion'" width="10">浏览器版本</th>
            <th data-options="field : 'viewDate'" width="10">访问日期</th>
        </tr>
    </thead>
</table>
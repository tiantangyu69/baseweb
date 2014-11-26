<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="leaveMessageToolBar" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
    <%-- 
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="leaveMessage.toAdd(800, 500, '添加数据');">添加</a>
    --%>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="leaveMessage.toEdit(800, 400, '修改数据');">查看留言</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="leaveMessage.deleteByIds();">删除留言</a>
    </div>
</div>

<table id="leaveMessageTable" class="easyui-datagrid" data-options="
    pageList : [15,30,50,100],
    pageSize : 15,
    url : '${basePath}manage/leaveMessage/query.action',
    rownumbers : true,
    pagination : true,
    toolbar : '#leaveMessageToolBar',
    striped : true,
    fitColumns : true,
    border : false,
    fit : true">
    <thead>
        <tr>
            <th data-options="field : 'id', checkbox : true" width="10">id</th>
            <th data-options="field : 'username'" width="10">留言人</th>
            <th data-options="field : 'attribute1'" width="10">留言用户</th>
            <th data-options="field : 'email'" width="10">电子邮件</th>
            <th data-options="field : 'phone'" width="10">电话</th>
            <th data-options="field : 'deployTime'" width="10">留言日期</th>
            <th data-options="field : 'status',formatter:leaveMessageStatusFormatter" width="10">状态</th>
        </tr>
    </thead>
</table>
<%-- 
<div id="add_leaveMessage_Window" title="添加数据"></div>
--%>
<div id="edit_leaveMessage_Window" title="修改数据"></div>

<script type="text/javascript">
	function leaveMessageStatusFormatter(val){
		if(val == 0){
			return "<span style='color:red'>未查看</span>";
		} else{
			return "<span style='color:blue'>已查看</span>";
		}
		return val;
	}
</script>
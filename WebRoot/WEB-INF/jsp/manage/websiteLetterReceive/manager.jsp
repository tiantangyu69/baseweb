<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>

<div class="easyui-layout" data-options="fit:true,border:false" id="viewWebsiteReceiveLetter">
    <%-- 站内信内容 --%>
    <div data-options="region:'west',split:true,title:'站内信内容'" style="width:420px;"></div>
	<%-- 站内信列表 --%>
    <div data-options="region:'center',split:true,border:false">
		<div id="websiteLetterReceiveToolBar" style="padding:5px;height:auto">
		    <div style="margin-bottom:5px">
		        <%--<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="websiteLetterReceive.toAdd(800, 500, '添加数据');">添加</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="websiteLetterReceive.toEdit(800, 500, '修改数据');">修改</a>--%>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="websiteLetterReceive.receive();">查收</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="websiteLetterReceive.reply();">回复</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="websiteLetterReceive.deleteByIds();">删除</a>
		    </div>
		</div>

		<table id="websiteLetterReceiveTable" class="easyui-datagrid" data-options="
		    pageList : [15,30,50,100],
		    pageSize : 15,
		    url : '${basePath}manage/websiteLetterReceive/query.action',
		    rownumbers : true,
		    pagination : true,
		    toolbar : '#websiteLetterReceiveToolBar',
		    striped : true,
		    fitColumns : true,
		    border : false,
		    idField : 'id',
		    singleSelect : true,
		    fit : true,
			onClickRow :websiteLetterReceive.viewWebsiteLetterReceive">
		    <thead>
		        <tr>
		            <th data-options="field : 'title'" width="20">主题</th>
		            <th data-options="field : 'manageUserId'" width="10">发送人</th>
		            <th data-options="field : 'sendTime'" width="10">发送时间</th>
		            <th data-options="field : 'status', formatter:websiteLetterStatusFormatter" width="10">状态</th>
		        </tr>
		    </thead>
		</table>
    </div>
</div>
    
<div id="add_websiteLetterReceive_Window" title="回复站内信"></div>
<div id="edit_websiteLetterReceive_Window" title="修改数据"></div>

<script type="text/javascript">
	function websiteLetterStatusFormatter(val){
		if(val == '0'){
			return "<span style='color:red'>未查收</span>";
		} else{
			return "已查收";
		}
	}
</script>
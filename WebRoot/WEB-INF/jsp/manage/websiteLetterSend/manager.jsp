<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div class="easyui-layout" data-options="fit:true,border:false" id="viewWebsiteSendLetter">
    <%-- 站内信内容 --%>
    <div data-options="region:'west',split:true,title:'站内信内容'" style="width:420px;"></div>
	<%-- 站内信列表 --%>
    <div data-options="region:'center',split:true,border:false">
		<div id="websiteLetterSendToolBar" style="padding:5px;height:auto">
		    <div style="margin-bottom:5px">
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="websiteLetterSend.toAdd(980, 600, '发送站内信');">发送站内信</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="websiteLetterSend.deleteByIds();">删除已发送</a>
		    </div>
		</div>

		<table id="websiteLetterSendTable" class="easyui-datagrid" data-options="
		    pageList : [15,30,50,100],
		    pageSize : 15,
		    url : '${basePath}manage/websiteLetterSend/query.action',
		    rownumbers : true,
		    pagination : true,
		    toolbar : '#websiteLetterSendToolBar',
		    striped : true,
		    fitColumns : true,
		    border : false,
		    idField : 'id',
		    singleSelect : true,
		    fit : true,
			onClickRow:websiteLetterSend.viewWebsiteLetterSend">
		    <thead>
		        <tr>
		            <th data-options="field : 'title'" width="10">主题</th>
		            <th data-options="field : 'receiveUser'" width="30">接收人</th>
		            <th data-options="field : 'sendTime'" width="10">发送时间</th>
		        </tr>
		    </thead>
		</table>
	</div>
</div>
<div id="add_websiteLetterSend_Window" title="发送站内信"></div>
<div id="edit_websiteLetterSend_Window" title="修改数据"></div>
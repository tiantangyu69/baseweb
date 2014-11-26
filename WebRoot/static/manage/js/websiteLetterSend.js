var websiteLetterSend = new baseManage("websiteLetterSend");

websiteLetterSend.viewWebsiteLetterSend = function(){
	var rows = $("#websiteLetterSendTable").datagrid('getSelections');
	var letterId = rows[0].id;
	$("#viewWebsiteSendLetter").layout('panel', 'west').panel({
		href : "manage/websiteLetterSend/viewContent.action?id=" + letterId
	});
}
<%@ page language="java" pageEncoding="utf-8" import="java.util.Date"%>
    <link href="${basePath}static/common/js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css"></link>
    <link rel="stylesheet" type="text/css" href="${basePath}static/common/js/easyui/themes/icon.css"></link>
    <link rel="stylesheet" href="${basePath}static/common/js/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
    <link rel="stylesheet" href="${basePath}static/common/js/uploadify/uploadify.css" type="text/css"></link>
    <link rel="stylesheet" href="${basePath}static/common/js/artDialog/skins/default.css" type="text/css"></link>
    <%-- 各模块css --%>
    <link rel="stylesheet" href="${basePath}static/manage/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="${basePath}static/manage/css/main.css" type="text/css"></link>
    <%-- 公用js --%>
    <script type="text/javascript" src="${basePath}static/common/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${basePath}static/common/js/jquery.timers-1.2.js"></script>
    <script type="text/javascript" src="${basePath}static/common/js/jquery.form.js"></script>
    <script type="text/javascript" src="${basePath}static/common/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${basePath}static/common/js/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${basePath}static/common/js/commonValidate.js"></script>
    <script type="text/javascript" src="${basePath}static/common/js/zTree/js/jquery.ztree.all-3.5.js"></script>
    <script type="text/javascript" src="${basePath}static/common/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="${basePath}static/common/js/uploadify/jquery.uploadify.min.js"></script>
    <script type="text/javascript" src="${basePath}static/common/js/artDialog/artDialog.js"></script>
    
    <!-- 编辑器 -->
    <script type="text/javascript" charset="utf-8" src="${basePath}static/common/js/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${basePath}static/common/js/ueditor/ueditor.all.js"></script>
    
	<script type="text/javascript">
		$(function(){
		    var win = $.messager.progress({
		        msg:'请稍等，正在加载数据...'
		    });
		    setTimeout(function(){
		        $.messager.progress('close');
		    },2000)
		    setTimeout(alertLoginInfo, 2100);
		    setInterval(function(){
		    	$.post("${basePath}/manage/refreshSession.action");
		    }, 1700000);
		    
		    setTimeout(getOnlineManageUser, 2000);
		    setInterval(getOnlineManageUser, 20000);
		    setTimeout(getUnreadWebsiteLetterCount, 1000);
		    setInterval(getUnreadWebsiteLetterCount, 20000);
		    
            $(".easyui-tabs").bind('contextmenu',function(e){
                e.preventDefault();
                $('#mm').menu('show', {
                    left: e.pageX - 5,
                    top: e.pageY - 5
                });
            });
		});
		
	    function alertLoginInfo(){
	    	var htm = "<div style='color: #666'><span style='font-size:12px;font-weight:bold'>欢迎您 ${sessionScope.user.username}：</span></br></br>" +
	    	"&nbsp;&nbsp;&nbsp;&nbsp;您上次登录的时间为：${sessionScope.user.lastLoginTime}</br>" +
	    	"&nbsp;&nbsp;&nbsp;&nbsp;您上次登录的ip地址为：${sessionScope.user.lastLoginIP}</div>";
	    	$.messager.show({
	    		title:'登录信息',
	    		msg:htm,
	    		showType:'slide',
	    		width : 300,
	    		height:120
	    	});
	    }
		
		function getOnlineManageUser(){
	    	$.post("${basePath}manage/manageUser/getOnlineManageUserList.action", function(data){
	    		var htm="";
	    		for(var i = 0; i < data.length; i++){
	    			htm += "<div style='height:20px;line-height:20px;margin-bottom: 2px;'>" +
	    				"<div style='float:left'><img style='display:inline' src='${basePath}static/common/images/people.jpg'/></div>" +
	    				"<div style='float:left;font-weight:bold;cursor:pointer'>&nbsp;&nbsp;" + data[i] + 
	    				"</div></div>";
	    		}
	    		$("#onlineManageUser").html(htm);;
	    	});
	    }
		
		function getUnreadWebsiteLetterCount(){
			$.post("${basePath}manage/websiteLetterReceive/getUnreadWebsiteLetterCount.action", function(count){
				$("#unreadWebsiteLetterCount").text(count);
			});
		}
	</script>
	    
    <%-- 标签菜单 --%>
    <div id="mm" class="easyui-menu" style="width:150px;display: none;">
        <div id="mm-tabclose">关闭当前页</div>
        <div id="mm-tabcloseother">关闭非当前页</div>
        <div id="mm-tabcloseall">关闭所有页</div>
        <div class="menu-sep"></div>
        <div id="mm-tabclose"  data-options="iconCls:'icon-reload'" onclick="javascript:window.location.reload(); ">刷新（ F5 ）</div>
    </div>
    
    <%-- 统计图js --%>
    <script src="${basePath}static/common/js/highcharts/highcharts.js"></script>
    <script src="${basePath}static/common/js/highcharts/modules/exporting.js"></script>
    <%-- 各模块js --%>
    <script type="text/javascript" src="${basePath}static/common/js/baseManage.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/main.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/manageRole.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/manageUser.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/resources.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/manageMenu.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/manageRoleResources.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/manageUserRole.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/websiteLogo.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/friendlyLink.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/singlePage.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/singlePageType.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/portalUserType.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/portalUser.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/websiteAccessRecords.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/dictionaryType.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/dictionaryValue.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/news.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/basePage.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/leaveMessage.js"></script>
    
    <script type="text/javascript" src="${basePath}static/manage/js/province.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/city.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/databaseBackup.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/websiteLetterSend.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/websiteLetterReceive.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/department.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/systemLogConfig.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/systemLog.js"></script>
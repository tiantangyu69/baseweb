<%@ page language="java" pageEncoding="utf-8" import="java.util.Date"%>
<%-- 包含所有的标签库 --%>
<%@ include file="/common/manage/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>后台管理主页面</title>
    <%-- js 和 css --%>
    <%@ include file="js.jsp" %>
</head>
<ui:body>
    <%-- 页面顶端布局 --%>
    <ui:region title=" " region="north" border="false" cssClass="main_north">
        <div style="margin-top: 8px;"><img src="${basePath}static/manage/images/toplogo-main.png" width="600px" height="50px;"></div>
        <%-- 右侧菜单div --%>
        <div class="absolute_right_bottom">
            <div style="float: left;margin-top: 2px;"><img onclick="setmain('收信箱', '${basePath}manage/websiteLetterReceive/manager.action')" style='display:inline;height: 22px;width: 22px;cursor: pointer;' src='${basePath}static/common/images/letter.png'/></div>
            <span style="color: #0081C2; cursor: pointer;" onclick="setmain('收信箱', '${basePath}manage/websiteLetterReceive/manager.action')">（未查收信息 <span id="unreadWebsiteLetterCount"></span> 条）</span>
            <span class="normalfont" style="color: #0081C2">&nbsp;欢迎您：${sessionScope.user.username} 今天是：<fmt:formatDate value="<%=new java.util.Date() %>" pattern="yyyy年MM月dd日"/> </span>
            <%-- 个人设置菜单 --%>
            <a href="javascript:void(0);" class="easyui-menubutton" menu="#person_settings_menu" iconCls="icon-help">个人设置</a>
            <div id="person_settings_menu" class="top_menu_div">
                <div onclick="manageUser.toPersonSet(600, 360, '个人信息')"> 个人信息</div>
                <div class="menu-sep"></div>
                <div onclick="manageUser.toModifyPassword(500,200,'修改密码')"> 修改密码</div>
            </div>
            <%-- 退出系统菜单 --%>
            <a href="javascript:void(0);" class="easyui-menubutton" menu="#exit_system_menu" iconCls="icon-back">安全退出</a>
            <div id="exit_system_menu" class="top_menu_div">
                <div class="menu-sep"></div>
                <div onclick="mangeUserLogout('manageLogout.action');">退出系统</div>
            </div>
        </div>
        <%-- 个人设置窗口 --%>
        <div id="personSet_Window" title="个人设置"></div>
        <%-- 修改密码窗口 --%>
        <div id="modifyPassword_Window" title="修改密码"></div>
    </ui:region>
    
    <%-- 左侧菜单布局 --%>
    <ui:region title="菜单导航" region="west" split="true" style="width:200px;" cssClass="main_west" href="${basePath}manage/manageMenu/getManageMenu.action"></ui:region>
    
    <%-- 右侧布局 --%>
    <ui:region title="辅助工具" icon="icon-reload" region="east" split="true" cssClass="main_east" collapsed="true">
        <ui:tabs id="helperTabs" border="false">
	        <div title="日历" data-options="border:false" class="easyui-calendar"></div>
	    </ui:tabs>
	    <ui:tabs id="helperTabs2" border="false">
	        <ui:tab id="onlineManageUser" title="在线人员" style="padding: 5px; overflow: auto; color: #0E2D5F"></ui:tab>
	        <ui:tab id="allManageUser" title="所有人员" style="padding: 5px; overflow: auto; color: #0E2D5F" href="${basePath}manage/manageUser/queryAllManageUser.action" cache="false"></ui:tab>
	    </ui:tabs>
    </ui:region>
	
	<%-- 中间布局 --%>
    <ui:region region="center">
	    <%-- 标签页 --%>
	    <ui:tabs id="manageTabs" fit="true" border="false">
	        <ui:tab title="首页" href="${basePath}manage/singlePage/fetchSinglePage.action?id=2"></ui:tab>
	    </ui:tabs>
    </ui:region>
    
    <%-- 底部布局 --%>
    <ui:region region="south" style="text-align: center;height: 10px;"></ui:region>
</ui:body>
</html>
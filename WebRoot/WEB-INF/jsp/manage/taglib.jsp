<%@ page language="java" pageEncoding="utf-8"%>
<%-- 包含所有的标签库 --%>
<%@ include file="/common/manage/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <link href="${basePath}static/common/js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${basePath}static/common/js/easyui/themes/icon.css">
    <script type="text/javascript" src="${basePath}static/common/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${basePath}static/common/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${basePath}static/common/js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<%--
<ui:body>
        
        <ui:region title=" " region="north" style="height:100px;">${content}</ui:region>
        <ui:region title="菜单导航" region="west" split="true" style="width:200px;">${content}</ui:region>
        <ui:region title="" region="center" split="true">${content}</ui:region>
        <ui:region title="辅助工具" icon="icon-reload" region="east" split="true" style="width:200px">${content}</ui:region>
        <ui:region region="south" style="height:20px;"></ui:region>
        
</ui:body>
--%>
<%--
<body>
    <ui:layout style="width:800px;height:700px;">
        <ui:region title="aaa" region="north" style="width:100px;height:200px;"></ui:region>
        <ui:region title="aaa" region="west" style="width:100px;height:200px;"></ui:region>
        <ui:region title="aaa" region="center" style="width:100px;height:200px;"></ui:region>
    </ui:layout>
</body>
--%>
</html>

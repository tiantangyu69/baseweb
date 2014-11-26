<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<ui:layout fit="true" border="false" id="jspOnlineModifyLayout">
    <ui:region region="west" split="true" title="页面根目录" style="width:280px;" href="${basePath}manage/jspManage/getFileTree.action"></ui:region>
	<ui:region region="center" split="true" border="false" title="页面内容"></ui:region>
</ui:layout>
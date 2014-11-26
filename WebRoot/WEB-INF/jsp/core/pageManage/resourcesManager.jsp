<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<ui:layout fit="true" border="false" id="resourcesOnlineModifyLayout">
    <ui:region region="west" split="true" title="资源文件根目录" style="width:280px;" href="${basePath}manage/jspManage/getResourcesFileTree.action"></ui:region>
	<ui:region region="center" split="true" border="false" title="资源文件内容"></ui:region>
</ui:layout>
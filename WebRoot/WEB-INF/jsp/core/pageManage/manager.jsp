<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<ui:tabs fit="true" plain="false" id="pageManagerTabs" border="false">
    <ui:tab href="${basePath}manage/jspManage/jspManager.action" title="jsp页面维护"></ui:tab>
    <ui:tab href="${basePath}manage/jspManage/resourcesManager.action" title="资源文件维护"></ui:tab>
</ui:tabs>
<script type="text/javascript">
	$(function(){
		$("#pageManagerTabs").tabs({tabPosition : 'left', tabHeight : 30, headerWidth : 100});;
	});
</script>

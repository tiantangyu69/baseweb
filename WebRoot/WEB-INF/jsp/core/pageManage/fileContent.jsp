<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<c:if test="${jg:isImage(fileName)}">
    <h3 style="text-align: center;">${fileName} 图片预览</h3>
    <div style="padding: 5px;"><img src="${basePath}${relativeFilePath}"/></div>
</c:if>
<c:if test="${!jg:isImage(fileName)}">
	<form id="saveJspContentForm" method="post" action="${basePath}manage/jspManage/saveContent.action">
		<table width="100%" align="center">
		    <tr height="5"></tr>
		    <tr>
		        <td align="center">
		            <input type="hidden" name="filePath" value="${filePath}"/>
		            <textarea name="content" id="saveJspContentTextarea" style="width: 99%;height: 600px;background-color: #f2f2f2;" cols="2" rows="2"><c:out value="${content}"></c:out></textarea>
		            <input type="hidden" value="<c:out value="${content}"></c:out>" id="orgJspContent"/>
		        </td>
		    </tr>
		    <tr>
		        <td align="center">
		            <a href="#" onclick="saveJspContent();" class="easyui-linkbutton" iconCls="icon-save">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;
		            <a href="#" onclick="resetSaveJspContentForm()" class="easyui-linkbutton" iconCls="icon-undo">重置</a>
		        </td>
		    </tr>
		</table>
	</form>
	
	<script type="text/javascript">
		function resetSaveJspContentForm(){
			$("#saveJspContentTextarea").val($("#orgJspContent").val());
		}
		function saveJspContent(){
			$.messager.confirm('提示','您确定要保存该jsp页面吗?',function(result){
		        if (result){
					$("#saveJspContentForm").ajaxSubmit(function(result){
						if(result.status == RESULT.SUCCESS){
							$.messager.alert('提示',result.msg, 'info');
						} else{
							$.messager.alert('错误',result.msg, 'error');
						}
					});
		        }
		    });
		}
	</script>
</c:if>

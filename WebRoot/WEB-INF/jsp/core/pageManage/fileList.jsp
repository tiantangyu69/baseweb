<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div id="createNewFolderToolBar">
	<table width="100%" align="center">
	    <tr style="line-height: 100%">
	        <td width="220"><div style="font-size: 12px;color: #0081C2;margin: 0 auto;">当前目录: ${dictionaryPath}</div></td>
	        <td width="190">
	            <span style="font-size: 12px;color: #0081C2;margin: 0 auto;">新建目录：</span>
	            <input type="text" class="input_120" maxlength="30"/>
	        </td>
	        <td width="100"><ui:linkButton icon="icon-folder">新建</ui:linkButton></td>
	        <td width="190">
	            <span style="font-size: 12px;color: #0081C2;margin: 0 auto;">新建文件：</span>
	            <input type="text" class="input_120" maxlength="30"/>
	        </td>
	        <td><ui:linkButton icon="icon-file-add">新建</ui:linkButton></td>
	    </tr>
	    <tr>
	        <td width="110" colspan="2"><span style="font-size: 12px;color: #0081C2;margin: 0 auto;">上传文件：</span><input type="file" title="上传文件"/></td>
	        <td colspan="3"><ui:linkButton icon="icon-file-add">上传</ui:linkButton></td>
	    </tr>
	</table>
</div>

<table id="newsTable" class="easyui-datagrid" data-options="
    rownumbers : true,
    striped : true,
    fitColumns : true,
    border : false,
    fit : true,
    singleSelect: true,
    toolbar:'#createNewFolderToolBar'">
    <thead>
        <tr>
            <th data-options="field:'fileType'" align="center"> </th>
            <th data-options="field:'fileName'" width="15">文件名称</th>
            <th data-options="field:'fileSize'">文件大小</th>
            <th data-options="field:'filePath'" width="15">文件路径</th>
            <th data-options="field:'opt'" align="center">操作</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="f" items="${fileList}">
            <tr>
                <td>
                    <c:if test="${f.folder}"><img src="${basePath}static/common/images/folder.png" width="16" height="16"></img></c:if>
                    <c:if test="${!f.folder}"><img src="${basePath}static/common/images/menu.jpg" width="16" height="16"></img></c:if>
                </td>
                <td><a class="common_a" onclick="viewFileOrFolderInfo('${f.absoludePath}/${f.fileName}', '${f.fileName}', ${f.folder});">${f.fileName}</a></td>
                <td>
                    <c:if test="${f.folder}"></c:if>
                    <c:if test="${!f.folder}">${f.fileSize}</c:if>
                </td>
                <td>${f.filePath}</td>
                <td>
                    <c:if test="${!f.folder && !jg:isImage(f.fileName)}"><a href="javascript:void(0)" class="common_a" onclick="viewFileOrFolderInfo('${f.absoludePath}/${f.fileName}', '${f.fileName}', ${f.folder});">[ 修改 ]</a></c:if>
                    <c:if test="${f.folder || jg:isImage(f.fileName)}"><a href="javascript:void(0)" class="light_gray" style="cursor: text">[ 修改 ]</a></c:if>
                    <a href="javascript:void(0)" class="common_a">[ 删除 ]</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<c:if test="${pageType == 'static'}">
	<script type="text/javascript">
	    function viewFileOrFolderInfo(filePath, fileName, isFolder){
	    	var regS = new RegExp("/","g");
	    	filePath = filePath.replace(regS,"\\\\");
	    	if(!isFolder){
				$("#resourcesOnlineModifyLayout").layout('panel','center').panel({
					title : " [ " + fileName + " ] 页面内容",
					href:"${basePath}manage/jspManage/fileContent.action?filePath=" + filePath+ "&fileName=" + fileName
				});
				$('#resourcesOnlineModifyLayout').layout('panel','center').panel('refresh');
			} else{
				$("#resourcesOnlineModifyLayout").layout('panel','center').panel({
					title : " [ " + fileName + " ] 目录文件列表",
					href:"${basePath}manage/jspManage/fileList.action?filePath=" + filePath
				});
				$('#resourcesOnlineModifyLayout').layout('panel','center').panel('refresh');
			}
	    }
	</script>
</c:if>

<c:if test="${pageType == 'jsp'}">
	<script type="text/javascript">
	    function viewFileOrFolderInfo(filePath, fileName, isFolder){
	    	var regS = new RegExp("/","g");
	    	filePath = filePath.replace(regS,"\\\\");
	    	if(!isFolder){
				$("#jspOnlineModifyLayout").layout('panel','center').panel({
					title : " [ " + fileName + " ] 页面内容",
					href:"${basePath}manage/jspManage/fileContent.action?filePath=" + filePath+ "&fileName=" + fileName
				});
				$('#jspOnlineModifyLayout').layout('panel','center').panel('refresh');
			} else{
				$("#jspOnlineModifyLayout").layout('panel','center').panel({
					title : " [ " + fileName + " ] 目录文件列表",
					href:"${basePath}manage/jspManage/fileList.action?filePath=" + filePath
				});
				$('#jspOnlineModifyLayout').layout('panel','center').panel('refresh');
			}
	    }
	</script>
</c:if>
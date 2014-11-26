<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<ul id="resourcesFilesTree" class="easyui-tree" data-options="url:'${basePath}manage/jspManage/resourcesFiles.action',method:'get',animate:true,lines:true"></ul>
<script type="text/javascript">
	$(function(){
		$('#resourcesFilesTree').tree({
		    onClick:function(node){//单击事件  
				var filePath = node.attributes.filePath;// 取得文件的路径
		    	if(!node.attributes.folder){// 判断不是文件夹
					getResourcesContent(filePath, node.text);
		    	} else{
		    		getResourcesList(filePath, node.text);
		    	}
		    }  
		});
	});
	
	function getResourcesContent(filePath, fileName){
		$("#resourcesOnlineModifyLayout").layout('panel','center').panel({
			title : " [ " + fileName + " ] 页面内容",
			href:"${basePath}manage/jspManage/fileContent.action?filePath=" + filePath + "&fileName=" + fileName
		});
		$('#resourcesOnlineModifyLayout').layout('panel','center').panel('refresh');
	}
	
	function getResourcesList(filePath, fileName){
		$("#resourcesOnlineModifyLayout").layout('panel','center').panel({
			title : " [ " + fileName + " ] 目录文件列表",
			href:"${basePath}manage/jspManage/fileList.action?filePath=" + filePath
		});
		$('#resourcesOnlineModifyLayout').layout('panel','center').panel('refresh');
	}
</script>
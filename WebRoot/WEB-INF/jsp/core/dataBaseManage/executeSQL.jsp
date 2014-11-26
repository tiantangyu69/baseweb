<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<form action="${basePath}manage/dataBaseManage/executeSQL.action" method="post" id="executeSQLForm">
    <div style="margin: 10px auto auto 0">
        <textarea rows="2" cols="2" style="width: 800px;height: 500px;" name="sql"></textarea>
    </div>
    <a id="executeSQLButton" class="easyui-linkbutton">执行查询</a>
</form>

<script>
	$(function(){
		$("#executeSQLButton").click(function(){
			$("#executeSQLForm").ajaxSubmit(function(msg){
				if(msg == "1"){
					alert("执行成功！")
				}
			});
		});
	});
</script>
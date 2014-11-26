<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<script type="text/javascript">
var setting = {
		data: {
			simpleData: {
				enable: true
			}
		},
		check: {
			enable: true
		}
	};

	var zNodes =[
		<c:forEach var="r" items="${list}" varStatus="status">
		    <c:if test="${!status.last}">
		        {id : ${r.id}, pId : ${r.parentId}, name : "${r.name}", open : true <c:if test="${r.attribute5 == '1'}">,checked : true</c:if>},
		    </c:if>
		    <c:if test="${status.last}">
		        {id : ${r.id}, pId : ${r.parentId}, name : "${r.name}", open : true <c:if test="${r.attribute5 == '1'}">,checked : true</c:if>}
		    </c:if>
		</c:forEach>
	];

	$(document).ready(function(){
		$.fn.zTree.init($("#role_resource_tree"), setting, zNodes);
	});
</script>
<ul class="ztree" id="role_resource_tree"></ul>
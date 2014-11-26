<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<c:forEach var="user" items="${manageUserList}">
    <div style="height:20px;line-height:20px;margin-bottom: 2px;">
        <div style="float: left;"><img style='display:inline' src='${basePath}static/common/images/people2.jpg'/></div>
        <div style="float: left;">
            <c:if test="${sessionScope.user.username != user.username}">
                <img style='display:inline;height: 19px;width: 19px;cursor: pointer;' onclick="sendWebLetter('${user.username}');" title="发站内信" src='${basePath}static/common/images/letter.jpg'/>
            </c:if>
            <c:if test="${sessionScope.user.username == user.username}">
                <img style='display:inline;height: 19px;width: 19px;' src='${basePath}static/common/images/letter2.jpg'/>
            </c:if>
        </div>
        <div style="float: left;font-weight:bold;">&nbsp;${user.username}</div>
    </div>
</c:forEach>

<%-- 发送站内信窗口 --%>
<div id="sendWebLetter_Window" title="发送站内信"></div>

<script type="text/javascript">
	var sendWebLetter = function(username){
		var width = 980;
		var height = 600;
		var title = "发送站内信";
		$("#sendWebLetter_Window").window( {
			minimizable : false,
			width : width,
			height : height,
			title : title,
			modal : true,
			iconCls : "icon-letter",
			href : "${basePath}manage/manageUser/sendWebsiteLetter.action?username=" + username 
		});
	}
</script>
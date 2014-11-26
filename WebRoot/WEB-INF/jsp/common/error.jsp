<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" session="true" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>" />
    <title>出错了</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Page-Enter" content="revealTrans(duration=3,transtion=23)" />
	<meta http-equiv="Page-Exit" content="revealTrans(duration=3，transtion=23)" /> 
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
	<style type="text/css">
		#errorPage{margin-top:100px;}
		input{font-size:12px}
		td{font-size:12px}
		 #errorTips{text-align:center;background:url(images/error/emessage.gif) no-repeat scroll 120px 0;}
		a{color:#1b6ad8;text-decoration:none}
		a:hover{color:red}
	</style>
</head>
<body>
<table id="errorPage" cellspacing="0" cellpadding="0" width="540px" align="center" border="0">
	<tr>
		<td valign="top" height="270px">
			<img width="329px" height="211px" src="<%=basePath%>static/common/images/error/error.gif" alt="出错了" />			
			<p id="errorTips">无法访问本页的原因是：您所请求的页面不存在或权限不够！</p>
        </td>
	</tr>
	<tr>
		<td align="center">
		<table cellspacing="0" cellpadding="0" width="480px" border="0">
			<tbody>
			<tr>
				<td width="7px"><img height="26px" width="7px" src="<%=basePath%>static/common/images/error/left.gif" alt="left" /></td>
				<td style="background:url(<%=basePath%>static/common/images/error/bg.gif);"><div align="center"><font class="p6"><a href="<%=basePath%>index.action">返回首页</a>　 　|　 <a  href="javascript:history.go(-1)">返回出错页</a>　 　|　　 <a href="javascript:void(window.close());">关闭本页</a></font> </div></td>
				<td width="7px"><img src="<%=basePath%>static/common/images/error/right.gif" alt="right" /></td>
			</tr>
			</tbody>
		</table>
        </td>
	</tr>
</table>
</body>
</html>
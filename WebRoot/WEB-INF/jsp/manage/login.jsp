<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
	request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台管理登录页面</title>
    <link rel="stylesheet" type="text/css" href="${basePath}static/common/css/common.css"></link>
    <link rel="stylesheet" type="text/css" href="${basePath}static/manage/css/login.css"></link>
    <script type="text/javascript" src="${basePath}static/common/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${basePath}static/common/js/jquery.webbase-1.0.1.js"></script>
    <script type="text/javascript" src="${basePath}static/manage/js/login.js"></script>
    <script type="text/javascript" src="${basePath}static/common/js/iepng.js"></script>
    <script type="text/javascript" src="${basePath}static/common/js/jquery.cookie.js"></script>
    <!--[if lt IE 7]>
    <script src="${basePath}static/common/js/iepng.js" type="text/javascript"></script>
    <script type="text/javascript">
        EvPNG.fix('div, ul, img, li, input'); //EvPNG.fix('包含透明PNG图片的标签'); 多个标签之间用英文逗号隔开。
    </script>
    <![endif]-->
</head>
<body>
    <div id="login">
        <div class="inner">
            <div style="position: absolute;left: -8px;top: -8px;"><img src="${basePath}static/manage/images/typelogin.png"></img></div>
            <div class="logo"><img src="${basePath}static/manage/images/toplogo-jeecg.png"></div>
            <div class="formLogin">
                <form name="formLogin" id="formLogin" action="${basePath}manageLogin.action" check="loginController.do?checkuser" method="post">
                    <table class="input_280">
                        <tr style="height: 25px;">
                            <td colspan="3">
                                <div class="float_left" id="errorImage" style="<c:if test='${empty tips}'>display: none;</c:if>"><img src="${basePath}static/manage/images/error.png" width="25" height="25"/></div>
                                <div class="float_left" id="errorMsg" style='font-size:12px;color:red;height: 25px;line-height: 25px;'>${tips}</div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <div class="inputDiv userinput">
                                    <input class="input_box" name="username" type="text" id="username" value="" maxlength="30"></input>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <div class="inputDiv pwdinput">
                                    <input class="input_box" name="password" type="password" id="password" value="" maxlength="30"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td width="100"><input style="height: 35px;font-size: 16px;width: 100px;border: 1px solid #e2e2e2;line-height: 35px" name="code" type="text" id="code" maxlength="4" class="input_120"></td>
                            <td width="80"><img id="codeImg" src="/kaptcha.jpg" style="cursor: pointer;"></td>
                            <td width="100"><a id="changeCode" class="common_a" href="javascript:void(0)">看不清？换一张</a></td>
                        </tr>
                        <tr height="20"></tr>
                        <tr>
                            <td>
                                <div style="margin-top: 5px;" class="float_left"><input id="rememberAccount" type="checkbox"/></div>
                                <div style="height: 30px;line-height: 30px;" class="float_left"><label for="rememberAccount">记住用户名 </label></div>
                            </td>
                            <td colspan="2" align="right">
                                <div class="login_btn float_right" id="resetForm">重置</div>
                                <div class="login_btn float_right" id="but_login">登录</div>
                            </td>
                        </tr>
                    </table>
              </form>
          </div>
      </div>
      <div class="shadow"></div>
  </div>
  <div class="versionBar">
      <div>© 版权所有 BaseWeb ( 推荐使用IE8+,谷歌浏览器可以获得更快,更安全的页面响应速度 ) 技术支持:BaseWeb</div>
  </div>
  <%-- 账号核实动态图片 --%>
  <div id="preload" class="proload">
      <img src="${basePath}static/manage/images/preloader.gif"></img>
      <span>&nbsp;&nbsp;账号核实中...</span>
  </div>
</body>
</html>
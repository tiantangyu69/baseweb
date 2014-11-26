<%@ page language="java" pageEncoding="utf-8"%>
<%-- 包含所有的标签库 --%>
<%@ include file="/common/manage/taglib.jsp" %>
<%-- 菜单列表 --%>
<div class="easyui-accordion" data-options="fit:true, border:false">
    <c:forEach var="menuvo" items="${menuList}">
        <div title="${menuvo.manageMenu.name}" data-options="iconCls:'icon-mini-add'" class="overflow_auto">
            <ul>
                <c:forEach var="subMenu" items="${menuvo.manageMenuList}">
                    <li onmouseover="changeMenuColor(this)" onmouseout="backMenuColor(this)" class="nav_menu_li" onclick="setmain('${subMenu.name}', '${basePath}${subMenu.url}')">
                        <div style="float: left"><img style="height: 16px;line-height: 16px;margin-top: 4px;" src="${basePath}static/common/images/menu.jpg"></img></div>
                        <div style="float: left"><span>&nbsp;${subMenu.name}</span></div>
                    </li>    
                </c:forEach>        
            </ul>
        </div>
    </c:forEach>
</div>
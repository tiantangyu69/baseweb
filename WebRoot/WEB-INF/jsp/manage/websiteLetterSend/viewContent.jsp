<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div style="background-color: #D5EFFA;padding-left: 5px;">
    <div style="height: 25px;line-height: 25px;">主题：${websiteLetterSend.title}</div>
    <div style="height: 25px;line-height: 25px;">接收人：${websiteLetterSend.manageUserId}</div>
    <div style="height: 25px;line-height: 25px;">发送时间：${websiteLetterSend.sendTime}</div>
    <div style="height: 25px;line-height: 25px;">内容：</div>
</div>
<div style="padding: 2px">${websiteLetterSend.content}</div>
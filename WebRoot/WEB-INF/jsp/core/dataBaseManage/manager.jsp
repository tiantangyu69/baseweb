<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<div class="easyui-tabs" data-optaions="fit:true,border:false">
    <div title="系统参数配置" data-options="iconCls:'icon-edit'"></div>
    <div title="数据源参数配置" data-options="iconCls:'icon-edit',href:'${basePath}manage/dataBaseManage/dataSourceSettings.action'"></div>
</div>
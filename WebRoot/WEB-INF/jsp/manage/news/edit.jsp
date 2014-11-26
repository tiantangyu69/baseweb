<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<script type="text/javascript">
	$(function(){
		
		$(function() {
			$("#updateNewsFile").uploadify({
				'buttonText' : '上传图片',
				'fileTypeDesc' : 'Image Files',
				'fileTypeExts' : '*.gif; *.jpg; *.png',
				'fileSizeLimit' : '10240KB',
				height        : 30,
				swf           : '${basePath}static/common/js/uploadify/uploadify.swf',
				uploader      : '${basePath}manage/file/uploadify.action',
				width         : 120,
				'onUploadSuccess' : function(file, data, response) {
					$("#updateNewsPicPrev").attr("src", "${basePath}" + data);
					$("#updateNewsPic").val(data);
				}
			});
		});
	});
</script>

<form action="${basePath}/manage/news/edit.action" method="post" id="edit_news_form">
    <table class="common_table">
        <input type="hidden" value="${news.id}" name="id"/>
        <tr>
            <th width="10%" align="right">栏目：</th>
            <td width="90%" colspan="3">
                <ui:combobox value="${news.itemId}" cssClass="input_240" required="true" name="itemId" url="${basePath}manage/dictionaryValue/queryCombobox.action?dictionaryTypeId=1" textField="value" valueField="id"/>
            </td>
        </tr>
        <tr>
            <th align="right">标题：</th>
            <td><input class="input_240 easyui-validatebox" data-options="required:true" type="text" name="title" value="${news.title}"/></td>
            <th width="10%" align="right">来源：</th>
            <td width="40%">
                <input class="input_120" type="text" name="source" value="${news.source}"/>
                <span>url：</span>
                <ui:urlbox cssClass="input_120" name="sourceUrl" value="${news.sourceUrl}"/>
            </td>
        </tr>
        <tr>
            <th align="right">导语：</th>
            <td colspan="3"><input class="textarea_240" maxlength="250" type="text" name="attribute1" value="${news.attribute1}"/></td>
        </tr>
        <tr>
            <th align="right">新闻类型：</th>
            <td colspan="3">
                <ui:combobox value="${news.newsTypeId}" cssClass="input_240" required="true" name="newsTypeId" url="${basePath}manage/dictionaryValue/queryCombobox.action?dictionaryTypeId=2" textField="value" valueField="id"/>
            </td>
        </tr>
        <tr>
            <th align="right">焦点图：</th>
            <td>
                <input type="file" name="multipartFiles" id="updateNewsFile" />&nbsp;&nbsp;建议图片大小（370*190像素）
            </td>
            <th align="right">图片预览：</th>
            <td>
                <input id="updateNewsPic" type="hidden" value="${news.picPath}" name="picPath" id=""/>
                <img id="updateNewsPicPrev" alt="预览" name="picPath" class="preview_pic" src="${basePath}${news.picPath}">
            </td>
        </tr>
        <tr>
            <th align="right">发布日期：</th>
            <td colspan="3">
                <ui:WdatePicker cssClass="input_240" name="deployDate" value="${news.deployDate}" readonly="readonly"/>
                <span style="color: gray;">留空则为当天发布时间</span>
            </td>
        </tr>
        <tr>
            <th align="right">内容：</th>
            <td colspan="3"><ui:UEditor id="updateNewsContent" cssClass="common_editor" name="content" value="${news.content}"/></td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="news.edit()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="news.cancelEdit()">关闭</a>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<script type="text/javascript">
	$(function(){
		$(function() {
			$("#addNewsFile").uploadify({
				'buttonText' : '上传图片',
				'fileTypeDesc' : 'Image Files',
				'fileTypeExts' : '*.gif; *.jpg; *.png',
				'fileSizeLimit' : '10240KB',
				height        : 30,
				swf           : '${basePath}static/common/js/uploadify/uploadify.swf',
				uploader      : '${basePath}manage/file/uploadify.action',
				width         : 120,
				'onUploadSuccess' : function(file, data, response) {
					$("#addNewsPicPrev").attr("src", "${basePath}" + data);
					$("#addNewsPic").val(data);
				}
			});
		});
	});
</script>

<form action="${basePath}/manage/news/add.action" method="post" id="add_news_form">
    <table class="common_table">
        <tr>
            <th width="10%" align="right">栏目：</th>
            <td width="90%" colspan="3">
                <ui:combobox cssClass="input_240" required="true" name="itemId" url="${basePath}manage/dictionaryValue/queryCombobox.action?dictionaryTypeId=1" textField="value" valueField="id"/>
            </td>
        </tr>
        <tr>
            <th align="right">标题：</th>
            <td><ui:input cssClass="input_240" required="true" name="title" validType="length[0,100]"/></td>
            <th width="10%" align="right">来源：</th>
            <td width="40%">
                <input class="input_120" type="text" name="source"/>
                <span>url：</span>
                <ui:urlbox cssClass="input_120" name="sourceUrl"/>
            </td>
        </tr>
        <tr>
            <th align="right">导语：</th>
            <td colspan="3"><input class="textarea_240" maxlength="250" type="text" name="attribute1"/></td>
        </tr>
        <tr>
            <th align="right">新闻类型：</th>
            <td colspan="3">
                <ui:combobox cssClass="input_240" required="true" name="newsTypeId" url="${basePath}manage/dictionaryValue/queryCombobox.action?dictionaryTypeId=2" textField="value" valueField="id"/>
            </td>
        </tr>
        <tr>
            <th align="right">焦点图：</th>
            <td><input id="addNewsFile" class="input_240" type="text"/>&nbsp;&nbsp;建议图片大小（370*190像素）</td>
            <th align="right">图片预览：</th>
            <td>
                <input type="hidden" value="" name="picPath" id="addNewsPic"/>
                <img id="addNewsPicPrev" alt="预览" class="preview_pic">
            </td>
        </tr>
        <tr>
            <th align="right">发布日期：</th>
            <td colspan="3">
                <ui:WdatePicker cssClass="input_240" readonly="readonly" name="deployDate" defaultTime="true"/>
                <span style="color: gray;">留空则为当天发布时间</span>
            </td>
        </tr>
        <tr>
            <th align="right">内容：</th>
            <td colspan="3">
                <ui:UEditor id="newsContent${jg:uuid()}" cssClass="common_editor" name="content"/>
            </td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="news.add()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="news.cancelAdd()">关闭</a>
</div>
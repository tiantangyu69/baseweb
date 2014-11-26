<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#addLogoFile").uploadify({
			'buttonText' : '上传图片',
			'fileTypeDesc' : 'Image Files',
			'fileTypeExts' : '*.gif; *.jpg; *.png',
			'fileSizeLimit' : '10240KB',
			height        : 30,
			swf           : '${basePath}static/common/js/uploadify/uploadify.swf',
			uploader      : '${basePath}manage/file/uploadify.action',
			width         : 120,
			'onUploadSuccess' : function(file, data, response) {
				$("#addLogoPicPrev").attr("src", "${basePath}" + data);
				$("#addLogoPic").val(data);
			}
		});
	});
</script>

<form action="${basePath}/manage/websiteLogo/add.action" method="post" id="add_websiteLogo_form">
    <table class="common_table">
        <tr>
            <th width="15%" align="right">logo编号：</th>
            <td width="85%">
                <input type="text" class="input_240 easyui-validatebox" data-options="required:true" name="attribute1"/>
            </td>
        </tr>
        <tr>
            <th width="15%" align="right">logo名称：</th>
            <td width="85%">
                <select class="input_240" name="name">
                    <option value="前台主页面logo">前台主页面logo</option>
                    <option value="后台主页面logo">后台主页面logo</option>
                    <option value="后台登录页面logo">后台登录页面logo</option>
                </select>
            </td>
        </tr>
        <tr>
            <th align="right">上传图片：</th>
            <td><input id="addLogoFile" class="input_240" type="text"/>前台主页面logo大小建议（410*84）、后台登录页面大小建议（575*60）、后台主页面logo大小建议（600*50）</td>
        </tr>
        <tr>
            <th align="right">图片预览：</th>
            <td>
                <input type="hidden" value="" name="picUrl" id="addLogoPic"/>
                <img id="addLogoPicPrev" alt="预览" class="preview_pic2">
            </td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="websiteLogo.add()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="websiteLogo.cancelAdd()">关闭</a>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#updateLogoFile").uploadify({
			'buttonText' : '上传图片',
			'fileTypeDesc' : 'Image Files',
			'fileTypeExts' : '*.gif; *.jpg; *.png',
			'fileSizeLimit' : '10240KB',
			height        : 30,
			swf           : '${basePath}static/common/js/uploadify/uploadify.swf',
			uploader      : '${basePath}manage/file/uploadify.action',
			width         : 120,
			'onUploadSuccess' : function(file, data, response) {
				$("#updateLogoPicPrev").attr("src", "${basePath}" + data);
				$("#updateLogoPic").val(data);
			}
		});
	});
</script>

<form action="${basePath}/manage/websiteLogo/edit.action" method="post" id="edit_websiteLogo_form">
    <table class="common_table">
        <input type="hidden" value="${websiteLogo.id}" name="id"/>
        
        <tr>
            <th width="15%" align="right">logo编号：</th>
            <td width="85%">
                <input type="text" class="input_240 easyui-validatebox" data-options="required:true" name="attribute1" value="${websiteLogo.attribute1}"/>
            </td>
        </tr>
        <tr>
            <th width="15%" align="right">logo名称：</th>
            <td width="85%">
                <select class="input_240" name="name">
                    <option value="前台主页面logo" <c:if test="${websiteLogo.name == '前台主页面logo'}">selected="selected"</c:if>>前台主页面logo</option>
                    <option value="后台主页面logo" <c:if test="${websiteLogo.name == '后台主页面logo'}">selected="selected"</c:if>>后台主页面logo</option>
                    <option value="后台登录页面logo" <c:if test="${websiteLogo.name == '后台登录页面logo'}">selected="selected"</c:if>>后台登录页面logo</option>
                </select>
            </td>
        </tr>
        
        <tr>
            <th align="right">上传图片：</th>
            <td><input type="file" name="multipartFiles" id="updateLogoFile" />前台主页面logo大小建议（410*84）、后台登录页面大小建议（575*60）、后台主页面logo大小建议（600*50）</td>
        </tr>
        <tr>
            <th align="right">图片预览：</th>
            <td>
                <input id="updateLogoPic" type="hidden" value="${websiteLogo.picUrl}" name="picUrl"/>
                <img id="updateLogoPicPrev" alt="预览" class="preview_pic2" src="${basePath}${websiteLogo.picUrl}">
            </td>
        </tr>
    </table>
</form>
<div class="floatright absolute_right_botton_10px">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="websiteLogo.edit()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="websiteLogo.cancelEdit()">关闭</a>
</div>
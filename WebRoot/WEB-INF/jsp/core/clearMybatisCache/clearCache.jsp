<%@ page language="java" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function(){
		$("#clearCacheButton").click(function(){
			$.messager.confirm('提示','您确定要清除mybatis缓存吗?',function(result){
		        if (result){
		        	$.post("manage/cache/clearCache.action", function(){
		        		$.messager.alert('提示',"缓存清除成功！",'info');
		        	});
		        }
		    });
		});
	});
</script>
<h3 style="padding: 0 0 0 5px;margin: 0;height: 30px;line-height: 30px;">此页面为清除数据缓存页面，该功能主要针对直接从数据库中修改的数据无法在缓存中得到修改，从而在页面中无法看到数据的变化，
点击清除缓存按钮来清除数据缓存。</h3>
&nbsp;&nbsp;<a id="clearCacheButton" class="easyui-linkbutton">清除缓存</a>

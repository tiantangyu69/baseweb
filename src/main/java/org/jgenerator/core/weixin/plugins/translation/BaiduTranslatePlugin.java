/**
 * 
 */
package org.jgenerator.core.weixin.plugins.translation;

import org.jgenerator.core.weixin.plugins.Plugin;
import org.jgenerator.core.weixin.util.WeiXinMessageUtil;

/**
 * @author LIZHITAO 百度翻译插件
 * 
 */
public class BaiduTranslatePlugin implements Plugin {

	public String getClickTip() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(WeiXinMessageUtil.emoji(0xe148)).append("在线翻译使用指南")
				.append("\n\n");
		buffer.append("在线翻译为用户提供专业的多语言翻译服务，目前支持以下翻译方向：").append("\n");
		buffer.append("    中 -> 英").append("\n");
		buffer.append("    英 -> 中").append("\n");
		buffer.append("    日 -> 中").append("\n\n");
		buffer.append("使用示例：").append("\n");
		buffer.append("    翻译我是中国人").append("\n");
		buffer.append("    翻译dream").append("\n");
		buffer.append("    翻译さようなら").append("\n\n");
		buffer.append("回复“?”显示主菜单");
		return buffer.toString();
	}

	public String getExecuteResult(String messageContent) {
		String keyWord = messageContent.replaceAll("^翻译", "").trim();
		if ("".equals(keyWord)) {
			return "";
		} else {
			return BaiduTranslateService.translate(keyWord,
					"h2zGT12xsck1wWlGvHzZe2O3&q");
		}
	}

	public boolean isExecute(String content) {
		if (content.startsWith("翻译")) {
			return true;
		}
		return false;
	}
}

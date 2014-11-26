/**
 * 
 */
package org.jgenerator.core.weixin.util.replaymsg;

import java.util.Date;

import org.jgenerator.core.weixin.model.request.TextAcceptMessage;
import org.jgenerator.core.weixin.model.response.TextReplayMessage;
import org.jgenerator.core.weixin.util.WeiXinMessageUtil;

/**
 * @author LIZHITAO 单图文消息范例
 */
public class SimpleTextMessage {
	public static String getMessage(TextAcceptMessage message, String content) {

		TextReplayMessage newsMessage = new TextReplayMessage();
		newsMessage.setToUserName(message.getFromUserName());
		newsMessage.setFromUserName(message.getToUserName());
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(WeiXinMessageUtil.REQ_MESSAGE_TYPE_TEXT);
		newsMessage.setContent(content);
		return WeiXinMessageUtil.textMessageToXml(newsMessage);
	}
}

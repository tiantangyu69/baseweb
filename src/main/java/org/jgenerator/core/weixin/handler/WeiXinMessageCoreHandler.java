package org.jgenerator.core.weixin.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jgenerator.core.weixin.model.request.BaseEventMessage;
import org.jgenerator.core.weixin.model.request.ImageAcceptMessage;
import org.jgenerator.core.weixin.model.request.LinkAcceptMessage;
import org.jgenerator.core.weixin.model.request.LocationAcceptMessage;
import org.jgenerator.core.weixin.model.request.MenuEventMessage;
import org.jgenerator.core.weixin.model.request.TextAcceptMessage;
import org.jgenerator.core.weixin.model.request.VoiceAcceptMessage;
import org.jgenerator.core.weixin.util.WeiXinMessageUtil;
import org.jgenerator.core.weixin.util.XML2AcceptMessage;

/**
 * 核心服务类
 * 
 * @author LIZHITAO
 */
public abstract class WeiXinMessageCoreHandler {

	/**
	 * 接受发送方发送的消息后默认回复的消息
	 */
	public static final String DEFAULE_RESPONSE_MESSAGE = "";

	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public String processRequest(HttpServletRequest request) {
		try {
			Map<String, String> requestMap = WeiXinMessageUtil
					.parseXml(request);// 获取并解析发送者发送的xml格式消息

			return replayMessage(requestMap);// 处理接受的消息并回复消息
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 回复接受的消息
	 * 
	 * @param requestMap
	 * @return
	 */
	public String replayMessage(Map<String, String> requestMap) {
		String msgType = requestMap.get("MsgType");// 获取消息类型

		if (WeiXinMessageUtil.isTextAcceptMessage(msgType)) {// 文本消息
			TextAcceptMessage message = XML2AcceptMessage
					.getTextObject(requestMap);
			return handleTextMessage(message);
		} else if (WeiXinMessageUtil.isImageAcceptMessage(msgType)) {// 图片消息
			ImageAcceptMessage message = XML2AcceptMessage
					.getImageObject(requestMap);
			return handleImageMessage(message);
		} else if (WeiXinMessageUtil.isLocationAcceptMessage(msgType)) {// 地理位置消息
			LocationAcceptMessage message = XML2AcceptMessage
					.getLocationObject(requestMap);
			return handleLocationMessage(message);
		} else if (WeiXinMessageUtil.isLinkAcceptMessage(msgType)) {// 链接消息
			LinkAcceptMessage message = XML2AcceptMessage
					.getLinkObject(requestMap);
			return handleLinkMessage(message);
		} else if (WeiXinMessageUtil.isVoiceAcceptMessage(msgType)) {// 语音消息
			VoiceAcceptMessage message = XML2AcceptMessage
					.getVoiceObject(requestMap);
			return handleVoiceMessage(message);
		} else if (WeiXinMessageUtil.isEventAcceptMessage(msgType)) {// 事件推送
			String eventType = requestMap.get("Event");// 事件类型

			if (eventType.equals(WeiXinMessageUtil.EVENT_TYPE_SUBSCRIBE)) {// 订阅事件
				BaseEventMessage event = XML2AcceptMessage
						.geteEventObject(requestMap);
				return handleSubscribeEvent(event);
			} else if (eventType
					.equals(WeiXinMessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {// 取消订阅事件
				BaseEventMessage event = XML2AcceptMessage
						.geteEventObject(requestMap);
				return handleSubscribeEvent(event);
			} else if (eventType.equals(WeiXinMessageUtil.EVENT_TYPE_CLICK)) {// 自定义菜单点击事件
				MenuEventMessage event = XML2AcceptMessage
						.geteMenuEventObject(requestMap);
				return handleClickEvent(event);
			}
		}
		return DEFAULE_RESPONSE_MESSAGE;// 返回空字符串则不像用户回复消息
	}

	/**
	 * 处理文本消息
	 * 
	 * @param message
	 * @return
	 */
	public abstract String handleTextMessage(TextAcceptMessage message);

	/**
	 * 处理图片消息
	 * 
	 * @param message
	 * @return
	 */
	public abstract String handleImageMessage(ImageAcceptMessage message);

	/**
	 * 处理地理信息消息
	 * 
	 * @param message
	 * @return
	 */
	public abstract String handleLocationMessage(LocationAcceptMessage message);

	/**
	 * 处理链接消息
	 * 
	 * @param message
	 * @return
	 */
	public abstract String handleLinkMessage(LinkAcceptMessage message);

	/**
	 * 处理音频消息
	 * 
	 * @param message
	 * @return
	 */
	public abstract String handleVoiceMessage(VoiceAcceptMessage message);

	/**
	 * 处理订阅事件
	 * 
	 * @param event
	 * @return
	 */
	public abstract String handleSubscribeEvent(BaseEventMessage event);

	/**
	 * 处理取消订阅事件
	 * 
	 * @param event
	 * @return
	 */
	public abstract String handleUnsbscribeEvent(BaseEventMessage event);

	/**
	 * 处理菜单点击事件
	 * 
	 * @param event
	 * @return
	 */
	public abstract String handleClickEvent(MenuEventMessage event);
}

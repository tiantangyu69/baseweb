package org.jgenerator.core.weixin.util;

import java.util.Map;

import org.jgenerator.core.weixin.model.request.BaseEventMessage;
import org.jgenerator.core.weixin.model.request.ImageAcceptMessage;
import org.jgenerator.core.weixin.model.request.LinkAcceptMessage;
import org.jgenerator.core.weixin.model.request.LocationAcceptMessage;
import org.jgenerator.core.weixin.model.request.MenuEventMessage;
import org.jgenerator.core.weixin.model.request.TextAcceptMessage;
import org.jgenerator.core.weixin.model.request.VoiceAcceptMessage;

/**
 * 
 * @author LIZHITAO 将接收的xml消息转换为实体对象
 */
public class XML2AcceptMessage {
	/**
	 * 获取文本消息对象
	 * @param requestMap
	 * @return
	 */
	public static TextAcceptMessage getTextObject(Map<String, String> requestMap) {
		String toUserName = requestMap.get("ToUserName");// 公众帐号
		String fromUserName = requestMap.get("FromUserName");// 发送方帐号（open_id）
		String createTime = requestMap.get("CreateTime");// 消息创建时间 （整型）
		String msgType = requestMap.get("MsgType");// 消息类型
		String content = requestMap.get("Content");// 文本消息内容
		String msgId = requestMap.get("MsgId");// 消息id，64位整型

		TextAcceptMessage message = new TextAcceptMessage();
		message.setToUserName(toUserName);
		message.setFromUserName(fromUserName);
		message.setCreateTime(Long.parseLong(createTime));
		message.setMsgType(msgType);
		message.setContent(content);
		message.setMsgId(Long.parseLong(msgId));
		
		return message;
	}
	
	/**
	 * 获得图片消息对象
	 * @param requestMap
	 * @return
	 */
	public static ImageAcceptMessage getImageObject(Map<String, String> requestMap) {
		String toUserName = requestMap.get("ToUserName");// 公众帐号
		String fromUserName = requestMap.get("FromUserName");// 发送方帐号（open_id）
		String createTime = requestMap.get("CreateTime");// 消息创建时间 （整型）
		String msgType = requestMap.get("MsgType");// 消息类型
		String msgId = requestMap.get("MsgId");// 消息id，64位整型
		String picUrl = requestMap.get("PicUrl");// 链接地址

		ImageAcceptMessage message = new ImageAcceptMessage();
		message.setToUserName(toUserName);
		message.setFromUserName(fromUserName);
		message.setCreateTime(Long.parseLong(createTime));
		message.setMsgType(msgType);
		message.setPicUrl(picUrl);
		message.setMsgId(Long.parseLong(msgId));
		
		return message;
	}
	
	/**
	 * 获得地理信息对象
	 * @param requestMap
	 * @return
	 */
	public static LocationAcceptMessage getLocationObject(Map<String, String> requestMap) {
		String toUserName = requestMap.get("ToUserName");// 公众帐号
		String fromUserName = requestMap.get("FromUserName");// 发送方帐号（open_id）
		String createTime = requestMap.get("CreateTime");// 消息创建时间 （整型）
		String msgType = requestMap.get("MsgType");// 消息类型
		String msgId = requestMap.get("MsgId");// 消息id，64位整型
		String location_X = requestMap.get("Location_X");// 地理位置纬度
		String location_Y = requestMap.get("Location_Y");// 地理位置经度
		String scale = requestMap.get("Scale");// 地图缩放大小
		String label = requestMap.get("Label");// 地理位置信息

		LocationAcceptMessage message = new LocationAcceptMessage();
		message.setToUserName(toUserName);
		message.setFromUserName(fromUserName);
		message.setCreateTime(Long.parseLong(createTime));
		message.setMsgType(msgType);
		message.setMsgId(Long.parseLong(msgId));
		message.setLocation_X(location_X);
		message.setLocation_Y(location_Y);
		message.setScale(scale);
		message.setLabel(label);
		
		return message;
	}

	/**
	 * 获得链接对象
	 * @param requestMap
	 * @return
	 */
	public static LinkAcceptMessage getLinkObject(Map<String, String> requestMap) {
		String toUserName = requestMap.get("ToUserName");// 公众帐号
		String fromUserName = requestMap.get("FromUserName");// 发送方帐号（open_id）
		String createTime = requestMap.get("CreateTime");// 消息创建时间 （整型）
		String msgType = requestMap.get("MsgType");// 消息类型
		String msgId = requestMap.get("MsgId");// 消息id，64位整型
		String title = requestMap.get("Title");// 消息标题
		String description = requestMap.get("Description");// 消息描述
		String url = requestMap.get("Url");// 链接地址

		LinkAcceptMessage message = new LinkAcceptMessage();
		message.setToUserName(toUserName);
		message.setFromUserName(fromUserName);
		message.setCreateTime(Long.parseLong(createTime));
		message.setMsgType(msgType);
		message.setMsgId(Long.parseLong(msgId));
		message.setTitle(title);
		message.setDescription(description);
		message.setUrl(url);
		
		return message;
	}

	/**
	 * 获得音频对象
	 * @param requestMap
	 * @return
	 */
	public static VoiceAcceptMessage getVoiceObject(Map<String, String> requestMap) {
		String toUserName = requestMap.get("ToUserName");// 公众帐号
		String fromUserName = requestMap.get("FromUserName");// 发送方帐号（open_id）
		String createTime = requestMap.get("CreateTime");// 消息创建时间 （整型）
		String msgType = requestMap.get("MsgType");// 消息类型
		String msgId = requestMap.get("MsgId");// 消息id，64位整型
		String mediaId = requestMap.get("MediaId");// 媒体id
		String format = requestMap.get("Format");// 语音格式

		VoiceAcceptMessage message = new VoiceAcceptMessage();
		message.setToUserName(toUserName);
		message.setFromUserName(fromUserName);
		message.setCreateTime(Long.parseLong(createTime));
		message.setMsgType(msgType);
		message.setMsgId(Long.parseLong(msgId));
		message.setMediaId(mediaId);
		message.setFormat(format);
		
		return message;
	}

	/**
	 * 获取订阅和取消订阅的事件消息对象
	 * @param requestMap
	 * @return
	 */
	public static BaseEventMessage geteEventObject(Map<String, String> requestMap) {
		String toUserName = requestMap.get("ToUserName");// 公众帐号
		String fromUserName = requestMap.get("FromUserName");// 发送方帐号（open_id）
		String createTime = requestMap.get("CreateTime");// 消息创建时间 （整型）
		String msgType = requestMap.get("MsgType");// 消息类型
		String event = requestMap.get("Event");// 事件类型，subscribe(订阅)、unsubscribe(取消订阅)

		BaseEventMessage eventMessage = new BaseEventMessage();
		eventMessage.setToUserName(toUserName);
		eventMessage.setFromUserName(fromUserName);
		eventMessage.setCreateTime(Long.parseLong(createTime));
		eventMessage.setMsgType(msgType);
		eventMessage.setEvent(event);
		
		return eventMessage;
	}

	/**
	 * 获取自定义菜单点击事件对象
	 * @param requestMap
	 * @return
	 */
	public static MenuEventMessage geteMenuEventObject(Map<String, String> requestMap) {
		String toUserName = requestMap.get("ToUserName");// 公众帐号
		String fromUserName = requestMap.get("FromUserName");// 发送方帐号（open_id）
		String createTime = requestMap.get("CreateTime");// 消息创建时间 （整型）
		String msgType = requestMap.get("MsgType");// 消息类型
		String event = requestMap.get("Event");// 事件类型，subscribe(订阅)、unsubscribe(取消订阅)
		String eventKey = requestMap.get("EventKey");// 消息类型

		MenuEventMessage eventMessage = new MenuEventMessage();
		eventMessage.setToUserName(toUserName);
		eventMessage.setFromUserName(fromUserName);
		eventMessage.setCreateTime(Long.parseLong(createTime));
		eventMessage.setMsgType(msgType);
		eventMessage.setEvent(event);
		eventMessage.setEventKey(eventKey);
		
		return eventMessage;
	}
}

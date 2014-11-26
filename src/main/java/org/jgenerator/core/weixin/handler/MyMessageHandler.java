/**
 * 
 */
package org.jgenerator.core.weixin.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.jgenerator.core.weixin.model.request.BaseEventMessage;
import org.jgenerator.core.weixin.model.request.ImageAcceptMessage;
import org.jgenerator.core.weixin.model.request.LinkAcceptMessage;
import org.jgenerator.core.weixin.model.request.LocationAcceptMessage;
import org.jgenerator.core.weixin.model.request.MenuEventMessage;
import org.jgenerator.core.weixin.model.request.TextAcceptMessage;
import org.jgenerator.core.weixin.model.request.VoiceAcceptMessage;
import org.jgenerator.core.weixin.model.response.Music;
import org.jgenerator.core.weixin.model.response.TextReplayMessage;
import org.jgenerator.core.weixin.plugins.Plugin;
import org.jgenerator.core.weixin.plugins.music.BaiduMusicPlugin;
import org.jgenerator.core.weixin.plugins.translation.BaiduTranslatePlugin;
import org.jgenerator.core.weixin.util.WeiXinMessageUtil;
import org.jgenerator.core.weixin.util.replaymsg.SimpleMusicMessage;
import org.jgenerator.core.weixin.util.replaymsg.SimpleTextMessage;
import org.springframework.stereotype.Repository;

/**
 * @author LIZHITAO
 * 
 */
@Repository
public class MyMessageHandler extends WeiXinMessageCoreHandler {
	private List<Plugin> plugins;

	public MyMessageHandler() {
		this.plugins = new ArrayList<Plugin>();
		plugins.add(new BaiduTranslatePlugin());
		plugins.add(new BaiduMusicPlugin());
	}

	@Override
	public String handleTextMessage(TextAcceptMessage message) {
		for (Plugin p : plugins) {
			if (p.isExecute(message.getContent())) {
				if (p instanceof BaiduMusicPlugin) {
					return SimpleMusicMessage.getMessage(message, (Music) JSONObject
							.toBean(JSONObject.fromObject(p
									.getExecuteResult(message.getContent())),
									Music.class));
				} else {
					String msg = SimpleTextMessage.getMessage(message, p
							.getExecuteResult(message.getContent()));
					return msg;
				}
			}
		}
		return DEFAULE_RESPONSE_MESSAGE;
	}

	@Override
	public String handleImageMessage(ImageAcceptMessage message) {
		TextReplayMessage textMessage = new TextReplayMessage();
		textMessage.setToUserName(message.getFromUserName());
		textMessage.setFromUserName(message.getToUserName());
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(WeiXinMessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setContent("您发送的图片链接为：" + message.getPicUrl());
		return WeiXinMessageUtil.textMessageToXml(textMessage);
	}

	@Override
	public String handleLinkMessage(LinkAcceptMessage message) {
		TextReplayMessage textMessage = new TextReplayMessage();
		textMessage.setToUserName(message.getFromUserName());
		textMessage.setFromUserName(message.getToUserName());
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(WeiXinMessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setContent("您发送的超链接为：" + message.getUrl());
		return WeiXinMessageUtil.textMessageToXml(textMessage);
	}

	@Override
	public String handleLocationMessage(LocationAcceptMessage message) {
		TextReplayMessage textMessage = new TextReplayMessage();
		textMessage.setToUserName(message.getFromUserName());
		textMessage.setFromUserName(message.getToUserName());
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(WeiXinMessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setContent("您发送的地理信息为：纬度-" + message.getLocation_X()
				+ " 经度-" + message.getLocation_Y() + " 描述："
				+ message.getLabel());
		return WeiXinMessageUtil.textMessageToXml(textMessage);
	}

	@Override
	public String handleVoiceMessage(VoiceAcceptMessage message) {
		TextReplayMessage textMessage = new TextReplayMessage();
		textMessage.setToUserName(message.getFromUserName());
		textMessage.setFromUserName(message.getToUserName());
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(WeiXinMessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setContent("您发送的语音id为：" + message.getMediaId());
		return WeiXinMessageUtil.textMessageToXml(textMessage);
	}

	@Override
	public String handleClickEvent(MenuEventMessage event) {
		String respContent = DEFAULE_RESPONSE_MESSAGE;
		TextReplayMessage textMessage = new TextReplayMessage();
		textMessage.setToUserName(event.getFromUserName());
		textMessage.setFromUserName(event.getToUserName());
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(WeiXinMessageUtil.RESP_MESSAGE_TYPE_TEXT);
		// 事件KEY值，与创建自定义菜单时指定的KEY值对应
		String eventKey = event.getEventKey();
		if (eventKey.equals("11")) {
			respContent = "天气预报菜单项被点击！";
		} else if (eventKey.equals("12")) {
			respContent = "公交查询菜单项被点击！";
		} else if (eventKey.equals("13")) {
			respContent = "周边搜索菜单项被点击！";
		} else if (eventKey.equals("14")) {
			for (Plugin p : plugins) {
				if (p instanceof BaiduTranslatePlugin) {
					respContent = p.getClickTip();
					break;
				}
			}
		} else if (eventKey.equals("21")) {
			for (Plugin p : plugins) {
				if (p instanceof BaiduMusicPlugin) {
					respContent = p.getClickTip();
					break;
				}
			}
		} else if (eventKey.equals("22")) {
			respContent = "经典游戏菜单项被点击！";
		} else if (eventKey.equals("23")) {
			respContent = "美女电台菜单项被点击！";
		} else if (eventKey.equals("24")) {
			respContent = "人脸识别菜单项被点击！";
		} else if (eventKey.equals("25")) {
			respContent = "聊天唠嗑菜单项被点击！";
		} else if (eventKey.equals("31")) {
			respContent = "Q友圈菜单项被点击！";
		} else if (eventKey.equals("32")) {
			respContent = "电影排行榜菜单项被点击！";
		} else if (eventKey.equals("33")) {
			respContent = "幽默笑话菜单项被点击！";
		}
		textMessage.setContent(respContent);
		return WeiXinMessageUtil.textMessageToXml(textMessage);
	}

	@Override
	public String handleSubscribeEvent(BaseEventMessage event) {
		return "感谢关注！";
	}

	@Override
	public String handleUnsbscribeEvent(BaseEventMessage event) {
		return "";
	}
}

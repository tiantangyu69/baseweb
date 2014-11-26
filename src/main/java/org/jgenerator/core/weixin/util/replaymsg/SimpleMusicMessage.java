/**
 * 
 */
package org.jgenerator.core.weixin.util.replaymsg;

import java.util.Date;

import org.jgenerator.core.weixin.model.request.TextAcceptMessage;
import org.jgenerator.core.weixin.model.response.Music;
import org.jgenerator.core.weixin.model.response.MusicReplayMessage;
import org.jgenerator.core.weixin.util.WeiXinMessageUtil;

/**
 * @author LIZHITAO 单图文消息范例
 */
public class SimpleMusicMessage {
	public static String getMessage(TextAcceptMessage message, Music music) {
		MusicReplayMessage musicMessage = new MusicReplayMessage();
		musicMessage.setToUserName(message.getFromUserName());
		musicMessage.setFromUserName(message.getToUserName());
		musicMessage.setCreateTime(new Date().getTime());
		musicMessage.setMsgType(WeiXinMessageUtil.RESP_MESSAGE_TYPE_MUSIC);
		musicMessage.setMusic(music);
		return WeiXinMessageUtil.musicMessageToXml(musicMessage);
	}
}

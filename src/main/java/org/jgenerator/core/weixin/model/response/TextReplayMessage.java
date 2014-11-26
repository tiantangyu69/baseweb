package org.jgenerator.core.weixin.model.response;

/**
 * 文本消息
 * 
 * @author LIZHITAO
 */
public class TextReplayMessage extends BaseReplayMessage {
	// 回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
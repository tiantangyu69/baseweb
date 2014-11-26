package org.jgenerator.core.weixin.model.request;

/**
 * 音频消息
 * 
 * @author LIZHITAO
 */
public class VoiceAcceptMessage extends BaseAcceptMessage {
	// 媒体ID
	private String MediaId;
	// 语音格式
	private String Format;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

}

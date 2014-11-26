package org.jgenerator.core.weixin.model.request;

/**
 * 图片消息
 * 
 * @author LIZHITAO
 */
public class ImageAcceptMessage extends BaseAcceptMessage {
	// 图片链接
	private String PicUrl;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

}

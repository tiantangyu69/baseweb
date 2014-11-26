/**
 * 
 */
package org.jgenerator.core.weixin.model.request;

/**
 * @author LIZHITAO
 * 微信文本消息
 */
public class TextAcceptMessage extends BaseAcceptMessage {
	// 消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}

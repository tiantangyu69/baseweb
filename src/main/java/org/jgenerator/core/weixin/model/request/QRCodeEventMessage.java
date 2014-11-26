/**
 * 
 */
package org.jgenerator.core.weixin.model.request;

/**
 * @author LIZHITAO 扫描带参数二维码事件
 */
public class QRCodeEventMessage extends BaseEventMessage {
	private String EventKey;// 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
	private String Ticket;// 二维码的ticket，可用来换取二维码图片

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

}

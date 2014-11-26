/**
 * 
 */
package org.jgenerator.core.weixin.model.request;

/**
 * @author LIZHITAO
 * 点击菜单拉取消息时的事件推送
 */
public class MenuEventMessage extends BaseEventMessage {
	private String EventKey;// 事件KEY值，与自定义菜单接口中KEY值对应

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

}

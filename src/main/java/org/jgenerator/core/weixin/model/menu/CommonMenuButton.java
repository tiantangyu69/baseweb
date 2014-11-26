/**
 * 
 */
package org.jgenerator.core.weixin.model.menu;

/**
 * @author LIZHITAO
 * 微信普通按钮
 */
public class CommonMenuButton extends BaseMenuButton {
	private String type;
	private String key;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}

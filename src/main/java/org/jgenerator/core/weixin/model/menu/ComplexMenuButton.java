/**
 * 
 */
package org.jgenerator.core.weixin.model.menu;

/**
 * @author LIZHITAO 微信复杂按钮
 */
public class ComplexMenuButton extends BaseMenuButton {
	private BaseMenuButton[] sub_button;

	public BaseMenuButton[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(BaseMenuButton[] subButton) {
		sub_button = subButton;
	}

}

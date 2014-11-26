/**
 * 
 */
package org.jgenerator.core.weixin.demo;

import org.jgenerator.core.weixin.manager.MenuManager;
import org.jgenerator.core.weixin.model.menu.BaseMenuButton;
import org.jgenerator.core.weixin.model.menu.CommonMenuButton;
import org.jgenerator.core.weixin.model.menu.ComplexMenuButton;
import org.jgenerator.core.weixin.model.menu.Menu;
import org.jgenerator.core.weixin.model.menu.ViewMenuButton;

/**
 * @author LIZHITAO 创建菜单的范例
 */
public class MenuDemo extends MenuManager {
	@Override
	protected Menu getMenu() {
		CommonMenuButton btn11 = new CommonMenuButton();
		btn11.setName("天气预报");
		btn11.setType("click");
		btn11.setKey("11");

		CommonMenuButton btn12 = new CommonMenuButton();
		btn12.setName("公交查询");
		btn12.setType("click");
		btn12.setKey("12");

		CommonMenuButton btn13 = new CommonMenuButton();
		btn13.setName("周边搜索");
		btn13.setType("click");
		btn13.setKey("13");

		CommonMenuButton btn14 = new CommonMenuButton();
		btn14.setName("在线翻译");
		btn14.setType("click");
		btn14.setKey("14");

		CommonMenuButton btn15 = new CommonMenuButton();
		btn15.setName("电影排行榜");
		btn15.setType("click");
		btn15.setKey("32");

		CommonMenuButton btn21 = new CommonMenuButton();
		btn21.setName("歌曲点播");
		btn21.setType("click");
		btn21.setKey("21");

		CommonMenuButton btn22 = new CommonMenuButton();
		btn22.setName("经典游戏");
		btn22.setType("click");
		btn22.setKey("22");

		CommonMenuButton btn23 = new CommonMenuButton();
		btn23.setName("美女电台");
		btn23.setType("click");
		btn23.setKey("23");

		CommonMenuButton btn24 = new CommonMenuButton();
		btn24.setName("人脸识别");
		btn24.setType("click");
		btn24.setKey("24");

		CommonMenuButton btn25 = new CommonMenuButton();
		btn25.setName("聊天唠嗑");
		btn25.setType("click");
		btn25.setKey("25");

		CommonMenuButton btn31 = new CommonMenuButton();
		btn31.setName("Q友圈");
		btn31.setType("click");
		btn31.setKey("31");

		CommonMenuButton btn33 = new CommonMenuButton();
		btn33.setName("幽默笑话");
		btn33.setType("click");
		btn33.setKey("33");

		CommonMenuButton btn34 = new CommonMenuButton();
		btn34.setName("用户反馈");
		btn34.setType("click");
		btn34.setKey("34");

		CommonMenuButton btn35 = new CommonMenuButton();
		btn35.setName("关于我们");
		btn35.setType("click");
		btn35.setKey("35");

		ViewMenuButton btn32 = new ViewMenuButton();
		btn32.setName("使用帮助");
		btn32.setType("view");
		btn32.setUrl("http://liufeng.gotoip2.com/xiaoqrobot/help.jsp");

		ComplexMenuButton mainBtn1 = new ComplexMenuButton();
		mainBtn1.setName("生活助手");
		mainBtn1.setSub_button(new BaseMenuButton[] { btn11, btn12, btn13,
				btn14, btn15 });

		ComplexMenuButton mainBtn2 = new ComplexMenuButton();
		mainBtn2.setName("休闲驿站");
		mainBtn2.setSub_button(new BaseMenuButton[] { btn21, btn22, btn23,
				btn24, btn25 });

		ComplexMenuButton mainBtn3 = new ComplexMenuButton();
		mainBtn3.setName("更多");
		mainBtn3.setSub_button(new BaseMenuButton[] { btn31, btn33, btn34,
				btn35, btn32 });

		/**
		 * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项
		 * 
		 * 
		 * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？
		 * 
		 * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：
		 * 
		 * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
		 */
		Menu menu = new Menu();
		menu.setButton(new BaseMenuButton[] { mainBtn1, mainBtn2, mainBtn3 });

		return menu;
	}

	public static void main(String[] args) {
		String appId = "wx556280d4b4dbfa9f";// 第三方用户唯一凭证
		String appSecret = "ed2af8fcbcf665819ae3ea2938e179f7";// 第三方用户唯一凭证密钥
		MenuManager manager = new MenuDemo();
		manager.createMenu(appId, appSecret);
	}

}

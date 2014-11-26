/**
 * 
 */
package org.jgenerator.core.weixin.manager;

import org.jgenerator.core.weixin.model.AccessToken;
import org.jgenerator.core.weixin.model.menu.Menu;
import org.jgenerator.core.weixin.util.AccessTokenUtil;
import org.jgenerator.core.weixin.util.MenuUtil;

/**
 * @author LIZHITAO 微信菜单创建管理类
 */
public abstract class MenuManager {
	/**
	 * 创建菜单
	 * 
	 * @param appId
	 *            第三方用户唯一凭证
	 * @param appSecret
	 *            第三方用户唯一凭证密钥
	 * @param menu
	 *            自定义菜单
	 */
	public void createMenu(String appId, String appSecret) {
		AccessToken token = AccessTokenUtil.getAccessToken(appId, appSecret);// 调用接口获取创建菜单的access_token

		if (null != token) {
			int result = MenuUtil.createMenu(getMenu(), token.getToken());// 调用接口创建菜单

			if (0 == result) {// 判断菜单创建结果
				System.out.println("菜单创建成功！");
			} else {
				System.out.println("菜单创建失败，错误码：" + result);
			}
		}
	}

	/**
	 * 查询菜单
	 * 
	 * @param appId
	 *            第三方用户唯一凭证
	 * @param appSecret
	 *            第三方用户唯一凭证密钥
	 * @return
	 */
	public String queryMenu(String appId, String appSecret) {
		AccessToken token = AccessTokenUtil.getAccessToken(appId, appSecret);// 调用接口获取创建菜单的access_token
		if (null != token) {
			String menu = MenuUtil.queryMenu(token.getToken());
			return menu;
		} else {
			return "";
		}
	}

	/**
	 * 删除菜单
	 * 
	 * @param appId
	 *            第三方用户唯一凭证
	 * @param appSecret
	 *            第三方用户唯一凭证密钥
	 */
	public void deleteMenu(String appId, String appSecret) {
		AccessToken token = AccessTokenUtil.getAccessToken(appId, appSecret);// 调用接口获取创建菜单的access_token
		if (null != token) {
			MenuUtil.deleteMenu(token.getToken());
		} else {
		}
	}

	/**
	 * 创建菜单时组装菜单数据
	 * 
	 * @return
	 */
	protected abstract Menu getMenu();
}

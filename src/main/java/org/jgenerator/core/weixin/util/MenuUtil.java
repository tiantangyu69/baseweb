/**
 * 
 */
package org.jgenerator.core.weixin.util;

import net.sf.json.JSONObject;

import org.jgenerator.core.weixin.model.menu.Menu;

/**
 * @author LIZHITAO 微信菜单util
 */
public class MenuUtil {
	// 菜单创建（POST） 限100（次/天）
	public static String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	public static String MENU_QUERY_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	public static String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	/**
	 * 创建菜单
	 * 
	 * @param menu
	 *            菜单实例
	 * @param accessToken
	 *            有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	public static int createMenu(Menu menu, String accessToken) {
		int result = 0;

		// 拼装创建菜单的url
		String url = MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		// 调用接口创建菜单
		JSONObject jsonObject = HttpsRequestUtil.httpRequest(url, "POST",
				jsonMenu);

		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				System.out.println("创建菜单失败 errcode:{} errmsg:{}"
						+ jsonObject.getInt("errcode")
						+ jsonObject.getString("errmsg"));
			}
		}

		return result;
	}

	/**
	 * 查询菜单
	 * 
	 * @param accessToken
	 * @return
	 */
	public static String queryMenu(String accessToken) {
		// 拼装创建菜单的url
		String url = MENU_QUERY_URL.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String menu = HttpsRequestUtil.httpRequest(url, "GET");
		return menu;
	}

	/**
	 * 删除菜单
	 * 
	 * @param accessToken
	 */
	public static void deleteMenu(String accessToken) {
		// 拼装创建菜单的url
		String url = MENU_DELETE_URL.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		HttpsRequestUtil.httpRequest(url, "GET");
		System.out.println("菜单删除成功！");
	}
}

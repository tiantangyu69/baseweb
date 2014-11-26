/**
 * 
 */
package org.jgenerator.core.weixin.util;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.jgenerator.core.weixin.model.AccessToken;

/**
 * @author LIZHITAO 凭证access_token的获取类
 */
public class AccessTokenUtil {
	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	/**
	 * 获取access_token
	 * 
	 * @param appid
	 *            凭证
	 * @param appsecret
	 *            密钥
	 * @return
	 */
	public static AccessToken getAccessToken(String appid,
			String appsecret) {
		AccessToken accessToken = null;

		String requestUrl = ACCESS_TOKEN_URL.replace("APPID", appid).replace(
				"APPSECRET", appsecret);
		JSONObject jsonObject = HttpsRequestUtil.httpRequest(requestUrl, "GET",
				null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				System.out.println("获取token失败 errcode:{} errmsg:{}"
						+ jsonObject.getInt("errcode")
						+ jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}
}

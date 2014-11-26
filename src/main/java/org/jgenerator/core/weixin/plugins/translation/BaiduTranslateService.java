package org.jgenerator.core.weixin.plugins.translation;

import java.io.UnsupportedEncodingException;

import org.jgenerator.core.weixin.plugins.Plugin;
import org.jgenerator.core.weixin.util.HttpsRequestUtil;
import com.google.gson.Gson;

/**
 * 
 * @author LIZHITAO 百度翻译服务
 */
public class BaiduTranslateService {
	/**
	 * utf编码
	 * 
	 * @param source
	 * @return
	 */
	public static String urlEncodeUTF8(String source) {
		String result = source;
		try {
			result = java.net.URLEncoder.encode(source, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 翻译（中->英 英->中 日->中 ）
	 * 
	 * @param source
	 * @return
	 */
	public static String translate(String source, String client_id) {
		String dst = null;

		// 组装查询地址
		String requestUrl = "http://openapi.baidu.com/public/2.0/bmt/translate?client_id="
				+ client_id + "={keyWord}&from=auto&to=auto";
		// 对参数q的值进行urlEncode utf-8编码
		requestUrl = requestUrl.replace("{keyWord}", urlEncodeUTF8(source));

		// 查询并解析结果
		try {
			// 查询并获取返回结果
			String json = HttpsRequestUtil.httpRequest(requestUrl);
			// 通过Gson工具将json转换成TranslateResult对象
			TranslateResult translateResult = new Gson().fromJson(json,
					TranslateResult.class);
			// 取出translateResult中的译文
			dst = translateResult.getTrans_result().get(0).getDst();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (null == dst)
			dst = "翻译系统异常，请稍候尝试！";
		return dst;
	}

	public static void main(String[] args) {
		Plugin plugin = new BaiduTranslatePlugin();
		System.out.println(plugin.getExecuteResult("翻译草泥马"));
	}
}
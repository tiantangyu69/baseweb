package org.jgenerator.core.weixin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.jgenerator.core.weixin.handler.WeiXinMessageCoreHandler;
import org.jgenerator.core.weixin.util.WeiXinSignUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 微信开发者接口
 * 
 * @author LIZHITAO
 * 
 */
@Controller
@Scope("request")
public class WeiXinCoreAction {
	private static final long serialVersionUID = 756754074696664021L;
	
	public static final String TOKEN = "jsagacity";// 开发者账号自定义的TOKEN
	@Resource
	private WeiXinMessageCoreHandler handler;// 消息处理器

	/**
	 * Function:微信开发模式接口配置
	 * 
	 * @author LIZHITAO
	 * @return
	 */
	@RequestMapping(value = "/weixinService", method = RequestMethod.GET)
	@ResponseBody
	public String weixinService(String signature, String timestamp,
			String nonce, String echostr) {
		// 随机字符串
		if (StringUtils.isNotEmpty(echostr)) {
			echostr = WeiXinSignUtil.checkAuthentication(signature, timestamp,
					nonce, echostr, TOKEN);
			// 验证通过返回随即字串
			return echostr;
		}
		return null;
	}

	/**
	 * 接收微信消息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/weixinService", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String weixinService(HttpServletRequest request) {
		String responseMessage = handler.processRequest(request);// 微信消息处理器
		return responseMessage;// 返回处理后的消息
	}

}
/**
 * 
 */
package org.jgenerator.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.jgenerator.core.servlet.OnlineManageUserCount;
import org.jgenerator.core.util.ManageMenuUtil;
import org.jgenerator.model.ManageUser;
import org.jgenerator.service.ManageUserService;
import org.sagacity.util.datetime.DateTimeUtil;
import org.sagacity.util.http.NetUtil;
import org.sagacity.util.security.EncrypMD5;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LIZHITAO
 * 
 */
@Controller
@Scope("request")
public class ManagerMainController {
	public static final String MODULE_PATH = "manage/";
	@Resource
	private ManageUserService manageUserServiceImpl;
	@Resource
	private ManageMenuUtil manageMenuUtil;

	@RequestMapping(value = "/toManageLogin")
	public String toManageLogin(HttpServletRequest request) {
		if(null != request.getSession()){
			String sessionId = request.getSession().getId();
			// 限制一个浏览器上登录两个账号
			if(OnlineManageUserCount.sessionMap.containsKey(sessionId)){
				return "redirect:manageMain.action";
			}
		}
		return MODULE_PATH + "login";
	}

	@RequestMapping(value = "/manageLogin", method = RequestMethod.POST)
	public String manageLogin(ManageUser manageUser, Model model, HttpServletRequest request, String code) {
		if (StringUtils.isBlank(manageUser.getUsername())
				|| StringUtils.isBlank(manageUser.getPassword())) {
			model.addAttribute("tips", "用户名或密码不能为空或空格，请您重新输入！");
			return MODULE_PATH + "login";
		}

		HttpSession session = request.getSession();
		String realKaptcha = (String) session
		.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);// 获取验证码
		if(!code.equalsIgnoreCase(realKaptcha)){
			model.addAttribute("tips", "您输入的验证码有误，请您重新输入！");
			return MODULE_PATH + "login";
		}
		/**
		 * 超级管理员
		 */
		if(manageMenuUtil.isSuperAdmin(manageUser.getUsername(), manageUser.getPassword())){
			ManageUser user = new ManageUser();
			user.setId(-999999);
			user.setUsername(manageUser.getUsername());
			user.setPassword(manageUser.getPassword());
			request.getSession().setAttribute("user", user);
			return "redirect:manageMain.action";
		}
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("username", manageUser.getUsername());
		params.put("password", EncrypMD5.encode(manageUser.getPassword()));
		List<ManageUser> users = manageUserServiceImpl.findAll(params);
		if (null != users && users.size() > 0) {
			if (users.get(0).getStatus() == 1) {
				request.getSession().setAttribute("user", users.get(0));
				ManageUser user2 = new ManageUser();
				user2.setId(users.get(0).getId());
				user2.setLastLoginTime(DateTimeUtil.getCurrentDateTime());
				user2.setLastLoginIP(NetUtil.getRemortIP(request, null));
				manageUserServiceImpl.saveOrUpdate(user2);
				return "redirect:manageMain.action";
			} else {
				model.addAttribute("tips", "您的账号被管理员停用了，请您联系管理员！");
				return MODULE_PATH + "login";
			}
		} else {
			model.addAttribute("tips", "您输入的账号或密码错误，请您重新输入！");
			return MODULE_PATH + "login";
		}
	}
	
	@RequestMapping(value = "manageMain")
	public String manageMain(){
		return MODULE_PATH + "main";
	}

	@RequestMapping(value = "/manageLogout")
	public String manageLogout(HttpSession session, Model model) {
		session.removeAttribute("user");
		session.invalidate();
		return MODULE_PATH + "login";
	}
	
	/**
	 * 防止长时间不操作session过期
	 * @param 
	 * @name refreshSession
	 * @active
	 * @state
	 * @type String
	 * @time 上午09:47:58
	 * @exception/throws
	 * @see
	 * @since
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/manage/refreshSession", method = RequestMethod.POST)
	@ResponseBody
	public String refreshSession(HttpSession session){
		ManageUser user = (ManageUser) session.getAttribute("user");
		System.out.println(user.getUsername());
		return "1";
	}
	
	/**
	 * 测试自定义标签库
	 * @return
	 */
	@RequestMapping(value = "/portal/taglib")
	public String testTaglib(Model model){
		model.addAttribute("title", "这是一个测试主题");
		model.addAttribute("content", "<span style='color:red'>这是一个测试内容！</span>");
		return MODULE_PATH + "taglib";
	}

	/**
	 * 验证验证码是否正确
	 * @param 
	 * @name captchaValidate
	 * @active
	 * @state
	 * @type boolean
	 * @time 上午10:42:09
	 * @exception/throws
	 * @see
	 * @since
	 * @param code
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "captchaValidate")
	@ResponseBody
	public boolean captchaValidate(String code, HttpSession session){
		boolean flag = false;
		String realKaptcha = (String) session
		.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);// 获取验证码
		if(code.equalsIgnoreCase(realKaptcha)){
			flag = true;
		}
		return flag;
	}
}

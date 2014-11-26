package org.jgenerator.controller;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.math.RandomUtils;
import org.jgenerator.core.util.mail.SendMail;
import org.jgenerator.model.PortalUser;
import org.jgenerator.service.PortalUserService;
import org.sagacity.util.security.EncrypBase64;
import org.sagacity.util.security.EncrypMD5;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class ForgetPasswordController {
	public static final String PORTAL_MODULE_PATH = "portal/forgetPassword/";
	@Resource
	private PortalUserService portalUserServiceImpl;
	@Resource
	private SendMail sendMail; 
	
	/**
	 * 检查该用户名是否存在
	 * @param 
	 * @name isExistUsername
	 * @active
	 * @state
	 * @type boolean
	 * @time 下午02:37:13
	 * @exception/throws
	 * @see
	 * @since
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/portal/forgetPassword/isExistUsername")
	@ResponseBody
	public boolean isExistUsername(String username){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", username);
		int count = portalUserServiceImpl.queryPage(params, 1, 1).getDataList().size();// 查询该用户名是否存在
		if(count < 1){
			return false;// 该用户名不存在
		}
		return true;
	}
	
	/**
	 * 验证修改密码的数字是否正确
	 * @param 
	 * @name isRightCode
	 * @active
	 * @state
	 * @type boolean
	 * @time 下午04:17:14
	 * @exception/throws
	 * @see
	 * @since
	 * @param code
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/isRightCode", method = RequestMethod.POST)
	@ResponseBody
	public boolean isRightCode(String code, HttpSession session){
		if(null == session || null == session.getAttribute("forgetCode")){
			return false;
		} else{
			String orgCode = (String)session.getAttribute("forgetCode");
			if(null != orgCode && orgCode.equals(code)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 前往忘记密码第一步
	 * @param 
	 * @name toStepOne
	 * @active
	 * @state
	 * @type String
	 * @time 下午01:11:23
	 * @exception/throws
	 * @see
	 * @since
	 * @return
	 */
	@RequestMapping(value = "/portal/forgetPassword/toStepOne")
	public String toStepOne(){
		return PORTAL_MODULE_PATH + "stepOne";
	}
	
	/**
	 * 忘记密码第一步
	 * @param 
	 * @name stepOne
	 * @active
	 * @state
	 * @type String
	 * @time 下午01:11:23
	 * @exception/throws
	 * @see
	 * @since
	 * @return
	 */
	@RequestMapping(value = "/portal/forgetPassword/stepOne", method = RequestMethod.POST)
	public String stepOne(String username, HttpSession session){
		session.setAttribute("forgetUser", username);
		return "redirect:/portal/forgetPassword/toStepTwo.action?param=" + EncrypBase64.encode(username) + "&token" + UUID.randomUUID()+ "&uuid=" + EncrypBase64.encode("true");
	}
	/**
	 * 前往忘记密码第二步页面
	 * @param 
	 * @name toStepTwo
	 * @active
	 * @state
	 * @type String
	 * @time 下午02:13:44
	 * @exception/throws
	 * @see
	 * @since
	 * @param username
	 * @return
	 */
	@RequestMapping("/portal/forgetPassword/toStepTwo")
	public String toStepTwo(String param, String uuid, Model model, HttpSession session){
		if(param != null && uuid != null && Boolean.parseBoolean(EncrypBase64.decode(uuid))){
			param = EncrypBase64.decode(param);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("username", param);
			if(portalUserServiceImpl.queryPage(params, 1, 1).getDataList().size() > 0){
				String email = portalUserServiceImpl.queryPage(params, 1, 1).getDataList().get(0).getEmail();
				model.addAttribute("email", email);
				session.setAttribute("pemail", email);
			}
			return PORTAL_MODULE_PATH + "stepTwo";
		}
		return PORTAL_MODULE_PATH + "stepOne";
	}
	
	/**
	 * 第二步操作
	 * @param 
	 * @name stepTwo
	 * @active
	 * @state
	 * @type String
	 * @time 下午06:53:52
	 * @exception/throws
	 * @see
	 * @since
	 * @param session
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/portal/forgetPassword/stepTwo", method = RequestMethod.POST)
	public String stepTwo(HttpSession session, String code){
		if(null == session || null == session.getAttribute("forgetCode")){
			return PORTAL_MODULE_PATH + "stepOne";
		} else{
			String orgCode = (String)session.getAttribute("forgetCode");
			if(null != code && orgCode.equals(code)){
				return "redirect:/portal/forgetPassword/toStepThree.action?param=" + EncrypBase64.encode(code) + "&token=" + UUID.randomUUID()+ "&uuid=" + EncrypBase64.encode("true");
			}
		}
		return PORTAL_MODULE_PATH + "stepOne";
	}
	
	/**
	 * 前往第三步操作
	 * @param 
	 * @name toStepThree
	 * @active
	 * @state
	 * @type String
	 * @time 下午07:16:52
	 * @exception/throws
	 * @see
	 * @since
	 * @param uuid
	 * @param param
	 * @param session
	 * @return
	 */
	@RequestMapping("/portal/forgetPassword/toStepThree")
	public String toStepThree(String uuid, String param, HttpSession session){
		String orgCode = (String)session.getAttribute("forgetCode");
		if(null != param && null != orgCode &&  orgCode.equals(EncrypBase64.decode(param))){
			return PORTAL_MODULE_PATH + "stepThree";
		}
		return PORTAL_MODULE_PATH + "stepOne";
	}
	
	@RequestMapping("/portal/forgetPassword/stepThree")
	public String stepThree(String password, HttpSession session){
		if(null != session && null != session.getAttribute("forgetUser") && password != null){
			String forgetUser = (String) session.getAttribute("forgetUser");
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("username", forgetUser);
			if(portalUserServiceImpl.queryPage(params, 1, 1).getDataList().size() > 0){
				PortalUser user = portalUserServiceImpl.queryPage(params, 1, 1).getDataList().get(0);
				user.setPassword(EncrypMD5.encode(password));
				portalUserServiceImpl.saveOrUpdate(user);
				return "redirect:/portal/forgetPassword/toStepFour.action?param=" + EncrypBase64.encode("true") + "&uuid=" + UUID.randomUUID();
			}
		}
		return PORTAL_MODULE_PATH + "stepOne";
	}
	
	/**
	 * 重置成功页面
	 * @param 
	 * @name toStepFour
	 * @active
	 * @state
	 * @type String
	 * @time 下午07:24:41
	 * @exception/throws
	 * @see
	 * @since
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/portal/forgetPassword/toStepFour")
	public String toStepFour(String param) {
		if (null != param && EncrypBase64.decode(param).equals("true")
				&& Boolean.parseBoolean(EncrypBase64.decode(param))) {
			return PORTAL_MODULE_PATH + "stepFour";
		}
		return PORTAL_MODULE_PATH + "stepOne";
	}
	
	/**
	 * 发送密码重置邮件
	 * @param 
	 * @name sendMail
	 * @active
	 * @state
	 * @type String
	 * @time 下午03:39:55
	 * @exception/throws
	 * @see
	 * @since
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	@ResponseBody
	public String sendMail(HttpSession session){
		String code = "";
		if(null == session || null == session.getAttribute("forgetCode")){
			code = String.valueOf(RandomUtils.nextInt(999999));
		} else{
			code = (String)session.getAttribute("forgetCode");
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<p><div style='font-size:14px'>尊敬的用户：</div>");
		sb.append("<div style='font-size:14px'>您好！</div> ");
		sb.append("<div style='font-size:14px'>您在我们的网站中申请忘记密码服务，本邮件为系统自动发出的验证邮件。如果您没有做相关的操作，可能是该用户误填了您的邮箱地址，请直接忽略此邮件。</div> ");
		sb.append("<div style='font-size:14px'>如果确认是您自己的操作，请将以下的验证码复制到网站的验证码输入框中，验证成功后将帮助您重置密码，请确保本邮箱的安全和持续可用。</div><br/>");
		sb.append("<div style='font-size:14px'>验证码（该验证码半小时内有效）：</div>");
		sb.append("<div style='font-size:14px;font-weight:bolder;color:green'>" + code+ "</div></p>");
		if (session.getAttribute("pemail") != null) {
			String email = (String) session.getAttribute("pemail");
			try {
				sendMail.sendHtmlTextMail(email, "伟龙会员忘记密码重置邮件，请勿回复！", sb.toString());
				session.setAttribute("forgetCode", code);
			} catch (Exception e) {
				return "0";// 发送失败
			}
		}else{
			return "-1";
		}
		return "1";// 发送成功
	}
}
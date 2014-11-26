/*******************************************************
 * @author LIZHITAO
 * @date 2013-8-30 上午09:49:42
 * @name ManageUserInterceptor.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.jgenerator.core.constant.CoreConstant;
import org.jgenerator.model.ManageUser;
import org.jgenerator.model.SystemLog;
import org.jgenerator.model.SystemLogConfig;
import org.jgenerator.service.SystemLogConfigService;
import org.jgenerator.service.SystemLogService;
import org.sagacity.util.datetime.DateTimeUtil;
import org.sagacity.util.http.NetUtil;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author LIZHITAO
 * 
 */
public class SystemLogInterceptor extends HandlerInterceptorAdapter {
	@Resource
	private SystemLogConfigService systemLogConfigServiceImpl;
	@Resource
	private SystemLogService systemLogServiceImpl;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI();// 过滤后台管理路径
		HttpSession session = request.getSession();
		ManageUser user = (ManageUser) session.getAttribute("user");
		if ((url.indexOf("/manage/") > -1 || url.endsWith("manageMain.action"))
				&& !url.equals("/manageLogin.action")) {
			SystemLogConfig slc = new SystemLogConfig();
			slc.setUrl(url);
			List<SystemLogConfig> list = systemLogConfigServiceImpl.queryPage(
					slc, 1, 1, null, null).getDataList();
			if (list.size() == 0) {
				slc.setName("拦截器添加");
				slc.setOptionName("");
				slc.setRecord(false);
				systemLogConfigServiceImpl.save(slc);
			}
		}
		if (null != user && !user.getUsername().equals(CoreConstant.SUPERADMIN)) {
			SystemLogConfig slc = new SystemLogConfig();
			slc.setRecord(true);
			List<SystemLogConfig> list = systemLogConfigServiceImpl.queryPage(
					slc, 1, Integer.MAX_VALUE, null, null).getDataList();
			for (SystemLogConfig s : list) {
				if (!StringUtils.isBlank(s.getUrl()) && s.getUrl().equals(url)) {
					SystemLog log = new SystemLog();
					log
							.setName(" [ " + s.getName() + " ] " + user.getUsername() + " "
									+ s.getOptionName());
					if (StringUtils.isNotBlank(s.getProperty())
							&& StringUtils.isNotBlank(request.getParameter(s
									.getProperty()))) {
						log.setName(log.getName()
								+ " \""
								+ (String) request
										.getParameter(s.getProperty()) + "\"");
					}
					log.setUsername(user.getUsername());
					log.setIp(NetUtil.getRemortIP(request, null));
					log.setOptTime(DateTimeUtil.getCurrentDateTime());
					log.setAttribute1(s.getAttribute1());
					systemLogServiceImpl.save(log);
					break;
				}
			}

			if (url.equals("/manageLogout.action")) {
				SystemLog log = new SystemLog();
				log.setName(" [ 用户 ] " + user.getUsername() + " 退出系统 ");
				log.setUsername(user.getUsername());
				log.setIp(NetUtil.getRemortIP(request, null));
				log.setOptTime(DateTimeUtil.getCurrentDateTime());
				log.setAttribute1("退出");
				systemLogServiceImpl.save(log);
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		String url = request.getRequestURI();
		if (url.equals("/manageLogin.action")) {
			HttpSession session = request.getSession();
			ManageUser user = (ManageUser) session.getAttribute("user");
			if (null != user && !user.getUsername().equals(CoreConstant.SUPERADMIN)) {
				SystemLog log = new SystemLog();
				log.setName(" [ 用户 ] " + user.getUsername() + " 登录系统 ");
				log.setUsername(user.getUsername());
				log.setIp(NetUtil.getRemortIP(request, null));
				log.setOptTime(DateTimeUtil.getCurrentDateTime());
				log.setAttribute1("登录");
				systemLogServiceImpl.save(log);
			}
		}
	}

}

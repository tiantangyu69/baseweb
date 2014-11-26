/*******************************************************
 * @author LIZHITAO
 * @date 2013-8-30 上午09:49:42
 * @name ManageUserInterceptor.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.interceptor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jgenerator.core.util.ManageMenuUtil;
import org.jgenerator.model.ManageRoleResources;
import org.jgenerator.model.ManageUser;
import org.jgenerator.model.ManageUserRole;
import org.jgenerator.model.Resources;
import org.jgenerator.service.ManageRoleResourcesService;
import org.jgenerator.service.ManageUserRoleService;
import org.jgenerator.service.ResourcesService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author LIZHITAO
 * 
 */
public class ManageUserInterceptor extends HandlerInterceptorAdapter {
	@Resource
	private ResourcesService resourcesServiceImpl;
	@Resource
	private ManageUserRoleService manageUserRoleServiceImpl;
	@Resource
	private ManageRoleResourcesService manageRoleResourcesService;
	@Resource
	private ManageMenuUtil manageMenuUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI();
		// 过滤个人中心
		if(url.indexOf("/portal/personalCenter/") > -1){
			if (null == request.getSession()
					|| null == request.getSession().getAttribute("portalUser")) {
				response.sendRedirect("/login.action");// 用户未登录则跳到登录页面
				return false;
			} else{
				return true;
			}
		}
		// 过滤后台管理路径
		if(url.indexOf("/manage/") > -1 || url.endsWith("manageMain.action")){
			if(url.endsWith("uploadify.action")){
				return true;
			}
			if (null == request.getSession()
					|| null == request.getSession().getAttribute("user")) {
				response.sendRedirect("toManageLogin.action");// 用户未登录则跳到登录页面
				return false;
			}
			ManageUser user = (ManageUser) request.getSession().getAttribute(
					"user");// 获取当前登录用户
			Set<Resources> rs = getResources(user);// 加载用户的权限
			List<Resources> resources = resourcesServiceImpl.findAll();// 需要权限控制的资源
			for (Resources r : resources) {
				if (!r.getUrl().equals("")) {
					if (url.indexOf(r.getUrl()) > -1) {// 该资源需要权限控制
						if (rs.contains(r)) {
							return true;
						} else {
							return false;
						}
					}
				}
				continue;
			}
		} else {
			return true;
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
	}
	
	private Set<Resources> getResources(ManageUser user) {
		Set<Resources> l = new HashSet<Resources>();
		if (manageMenuUtil.isSuperAdmin(user.getUsername(), user.getPassword())) {// 如果为超级管理员则具有所有权限
			List<Resources> re = resourcesServiceImpl.findAll();
			for (Resources r : re) {
				l.add(r);
			}
			return l;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", user.getId());
		List<ManageUserRole> list = manageUserRoleServiceImpl.findAll(params);
		for (ManageUserRole m : list) {
			Map<String, Object> params2 = new HashMap<String, Object>();
			params2.put("manageRoleId", m.getRoleId());
			List<ManageRoleResources> list2 = manageRoleResourcesService
					.findAll(params2);
			for (ManageRoleResources mr : list2) {
				Resources r = resourcesServiceImpl.fetch(mr.getResourceId());
				l.add(r);
			}
		}
		return l;
	}

}

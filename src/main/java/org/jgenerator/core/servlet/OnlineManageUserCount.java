/*******************************************************
 * @author 李智涛
 * @date 2013-7-18 上午10:51:00
 * @name SingleUserLoginControl.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.core.servlet;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.jgenerator.model.ManageUser;

/**
 * @author 李智涛
 * @atction 用户控制一个账号只能进行一次登录
 * 
 */
public class OnlineManageUserCount implements HttpSessionAttributeListener,HttpSessionListener  {
	// 存放登录的用户的sessionId 和 username
	public static Map<String, ManageUser> sessionMap = new HashMap<String, ManageUser>();

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		if (null != event.getSession().getAttribute("user")) {// 取得后台用户登录的用户名
			ManageUser p = (ManageUser) event.getSession().getAttribute("user");
			String sessionId = event.getSession().getId();
			if (!sessionMap.containsValue(p)) {
				sessionMap.put(sessionId, p);
			}
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// session失效时移除map中的用户
		String sessionId = event.getSession().getId();
		if(sessionMap.containsKey(sessionId)){
			sessionMap.remove(sessionId);
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		// session失效时移除map中的用户
		String sessionId = event.getSession().getId();
		if(sessionMap.containsKey(sessionId)){
			sessionMap.remove(sessionId);
		}
	}

}

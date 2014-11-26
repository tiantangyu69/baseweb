/*******************************************************
 * @author LIZHITAO
 * @date 2014-1-9 上午10:53:11
 * @name OnlineManageUserCountController.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.core.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jgenerator.controller.ManageUserController;
import org.jgenerator.core.constant.CoreConstant;
import org.jgenerator.core.servlet.OnlineManageUserCount;
import org.jgenerator.model.ManageUser;
import org.jgenerator.service.ManageUserService;
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
public class OnlineManageUserCountController {
	@Resource
	private ManageUserService manageUserServiceImpl;
	private Integer refreshSeconds = 60;

	@RequestMapping(value = "manage/manageUser/getOnlineManageUserList", method = RequestMethod.POST)
	@ResponseBody
	public List<String> getOnlineManageUserList() {
		List<String> list = new ArrayList<String>();
		Map<String, ManageUser> map = OnlineManageUserCount.sessionMap;
		for (Map.Entry<String, ManageUser> entry : map.entrySet()) {
			if (!entry.getValue().getUsername().equals(CoreConstant.SUPERADMIN)) {
				list.add(entry.getValue().getUsername());
			}
		}
		return list;
	}

	@RequestMapping(value = "manage/manageUser/getOnlineManageUserList2")
	@ResponseBody
	public List<ManageUser> getOnlineManageUserList2() {
		List<ManageUser> list = new ArrayList<ManageUser>();
		Map<String, ManageUser> map = OnlineManageUserCount.sessionMap;
		for (Map.Entry<String, ManageUser> entry : map.entrySet()) {
			if (entry.getValue().getId() > 0) {
				list.add(manageUserServiceImpl.fetch(entry.getValue().getId()));
			}
		}
		return list;
	}

	@RequestMapping(value = "manage/manageUser/toOnlineManageUserList")
	public String toOnlineManageUserList(Model model) {
		model.addAttribute("refreshSeconds", refreshSeconds);
		return ManageUserController.MODULE_PATH + "onlineManageUserList";
	}

	public Integer getRefreshSeconds() {
		return refreshSeconds;
	}

	public void setRefreshSeconds(Integer refreshSeconds) {
		this.refreshSeconds = refreshSeconds;
	}

}

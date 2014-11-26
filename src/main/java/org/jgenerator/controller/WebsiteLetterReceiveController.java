package org.jgenerator.controller;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.jgenerator.core.constant.CoreConstant;
import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.ManageUser;
import org.jgenerator.model.WebsiteLetterReceive;
import org.jgenerator.model.WebsiteLetterSend;
import org.jgenerator.model.entityArray.WebsiteLetterReceiveArray;
import org.jgenerator.service.ManageUserService;
import org.jgenerator.service.WebsiteLetterReceiveService;
import org.jgenerator.service.WebsiteLetterSendService;
import org.sagacity.util.datetime.DateTimeUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class WebsiteLetterReceiveController {
	public static final String MODULE_PATH = "manage/websiteLetterReceive/";
	@Resource
	private WebsiteLetterReceiveService websiteLetterReceiveServiceImpl;
	@Resource
	private WebsiteLetterSendService websiteLetterSendServiceImpl;
	@Resource
	private ManageUserService manageUserServiceImpl;

	@RequestMapping(value = "/manage/websiteLetterReceive/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/websiteLetterReceive/query")
	@ResponseBody
	public Map<String, Object> query(WebsiteLetterReceive websiteLetterReceive, 
		Integer page, Integer rows, HttpSession session) {
		ManageUser user = (ManageUser) session.getAttribute("user");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("receiveUser", user.getUsername());
		Pager<WebsiteLetterReceive> pager = websiteLetterReceiveServiceImpl.queryPage(params,
				page, rows);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", pager.getDataList());
		return result;
	}
	
	@RequestMapping(value = "/manage/websiteLetterReceive/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/websiteLetterReceive/add")
	@ResponseBody
	public String add(WebsiteLetterReceive websiteLetterReceive){
		websiteLetterReceiveServiceImpl.save(websiteLetterReceive);
		return "1";
	}
	
	@RequestMapping(value = "/manage/websiteLetterReceive/toEdit")
	public String toEdit(Model model, Integer id){
		WebsiteLetterReceive websiteLetterReceive = websiteLetterReceiveServiceImpl.fetch(id);
		model.addAttribute("websiteLetterReceive", websiteLetterReceive);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/websiteLetterReceive/edit")
	@ResponseBody
	public String edit(WebsiteLetterSend websiteLetterSend){
		websiteLetterSend.setSendTime(DateTimeUtil.getCurrentDateTime());
		WebsiteLetterReceive websiteLetterReceive = new WebsiteLetterReceive();
		websiteLetterReceive.setTitle(websiteLetterSend.getTitle());
		websiteLetterReceive.setContent(websiteLetterSend.getContent());
		websiteLetterReceive.setSendTime(websiteLetterSend.getSendTime());
		if(websiteLetterSend.getManageUserId() == -999999){
			websiteLetterReceive.setManageUserId("系统维护管理员");
		}else{
			websiteLetterReceive.setManageUserId(manageUserServiceImpl.fetch(websiteLetterSend.getManageUserId()).getUsername());
		}
		if(websiteLetterSend.getReceiveUser().equals("系统维护管理员")){
			websiteLetterSend.setReceiveUser(CoreConstant.SUPERADMIN);
		}
		websiteLetterReceive.setReceiveUser(websiteLetterSend.getReceiveUser());
		websiteLetterReceive.setStatus(0);
		websiteLetterReceiveServiceImpl.save(websiteLetterReceive);
		websiteLetterSendServiceImpl.save(websiteLetterSend);
		return "1";
	}
	
	@RequestMapping(value = "/manage/websiteLetterReceive/deleteByIds")
	@ResponseBody
	public String deleteByIds(WebsiteLetterReceiveArray array){
		if(null != array && null != array.getWebsiteLetterReceiveArray()){
			for(WebsiteLetterReceive entity : array.getWebsiteLetterReceiveArray()){
				websiteLetterReceiveServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
	
	@RequestMapping(value = "/manage/websiteLetterReceive/getUnreadWebsiteLetterCount")
	@ResponseBody
	public Integer getUnreadWebsiteLetterCount(WebsiteLetterReceive websiteLetterReceive, 
		Integer page, Integer rows, HttpSession session) {
		ManageUser user = (ManageUser) session.getAttribute("user");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("receiveUser", user.getUsername());
		params.put("status", 0);
		Pager<WebsiteLetterReceive> pager = websiteLetterReceiveServiceImpl.queryPage(params,
				page, rows);
		return  pager.getTotalCount();
	}
	

	@RequestMapping(value = "/manage/websiteLetterReceive/viewContent")
	public String viewContent(Model model, Integer id){
		WebsiteLetterReceive websiteLetterReceive = websiteLetterReceiveServiceImpl.fetch(id);
		model.addAttribute("websiteLetterReceive", websiteLetterReceive);
		return MODULE_PATH + "viewContent";
	}
	
	/**
	 * 查收站内信
	 * @param 
	 * @name receive
	 * @active
	 * @state
	 * @type String
	 * @time 下午02:52:56
	 * @exception/throws
	 * @see
	 * @since
	 * @param websiteLetterReceive
	 * @return
	 */
	@RequestMapping(value = "/manage/websiteLetterReceive/receive", method = RequestMethod.POST)
	@ResponseBody
	public String receive(WebsiteLetterReceive websiteLetterReceive){
		websiteLetterReceive.setStatus(1);
		websiteLetterReceiveServiceImpl.saveOrUpdate(websiteLetterReceive);
		return "1";
	}
}
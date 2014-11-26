package org.jgenerator.controller;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.ManageUser;
import org.jgenerator.model.WebsiteLetterReceive;
import org.jgenerator.model.WebsiteLetterSend;
import org.jgenerator.model.entityArray.WebsiteLetterSendArray;
import org.jgenerator.service.ManageUserService;
import org.jgenerator.service.WebsiteLetterReceiveService;
import org.jgenerator.service.WebsiteLetterSendService;
import org.sagacity.util.datetime.DateTimeUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class WebsiteLetterSendController {
	public static final String MODULE_PATH = "manage/websiteLetterSend/";
	@Resource
	private WebsiteLetterSendService websiteLetterSendServiceImpl;
	@Resource
	private WebsiteLetterReceiveService websiteLetterReceiveServiceImpl;
	@Resource
	private ManageUserService manageUserServiceImpl;

	@RequestMapping(value = "/manage/websiteLetterSend/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/websiteLetterSend/query")
	@ResponseBody
	public Map<String, Object> query(WebsiteLetterSend websiteLetterSend, 
		Integer page, Integer rows, HttpSession session) {
		ManageUser user = (ManageUser) session.getAttribute("user");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("manageUserId", user.getId());
		
		Pager<WebsiteLetterSend> pager = websiteLetterSendServiceImpl.queryPage(params,page, rows);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", pager.getDataList());
		return result;
	}
	
	@RequestMapping(value = "/manage/websiteLetterSend/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/websiteLetterSend/add")
	@ResponseBody
	public String add(WebsiteLetterSend websiteLetterSend){
		websiteLetterSend.setSendTime(DateTimeUtil.getCurrentDateTime());
		String[] users = websiteLetterSend.getReceiveUser().split(",");
		for(String u : users){
			WebsiteLetterReceive websiteLetterReceive = new WebsiteLetterReceive();
			websiteLetterReceive.setTitle(websiteLetterSend.getTitle());
			websiteLetterReceive.setContent(websiteLetterSend.getContent());
			websiteLetterReceive.setSendTime(websiteLetterSend.getSendTime());
			if(websiteLetterSend.getManageUserId() == -999999){
				websiteLetterReceive.setManageUserId("系统维护管理员");
			}else{
				websiteLetterReceive.setManageUserId(manageUserServiceImpl.fetch(websiteLetterSend.getManageUserId()).getUsername());
			}
			websiteLetterReceive.setReceiveUser(u);
			websiteLetterReceive.setStatus(0);
			websiteLetterReceiveServiceImpl.save(websiteLetterReceive);
		}
		websiteLetterSendServiceImpl.save(websiteLetterSend);
		return "1";
	}
	
	@RequestMapping(value = "/manage/websiteLetterSend/toEdit")
	public String toEdit(Model model, Integer id){
		WebsiteLetterSend websiteLetterSend = websiteLetterSendServiceImpl.fetch(id);
		model.addAttribute("websiteLetterSend", websiteLetterSend);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/websiteLetterSend/edit")
	@ResponseBody
	public String edit(WebsiteLetterSend websiteLetterSend){
		websiteLetterSendServiceImpl.saveOrUpdate(websiteLetterSend);
		return "1";
	}
	
	@RequestMapping(value = "/manage/websiteLetterSend/deleteByIds")
	@ResponseBody
	public String deleteByIds(WebsiteLetterSendArray array){
		if(null != array && null != array.getWebsiteLetterSendArray()){
			for(WebsiteLetterSend entity : array.getWebsiteLetterSendArray()){
				websiteLetterSendServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
	
	@RequestMapping(value = "/manage/websiteLetterSend/viewContent")
	public String viewContent(Model model, Integer id){
		WebsiteLetterSend websiteLetterSend = websiteLetterSendServiceImpl.fetch(id);
		model.addAttribute("websiteLetterSend", websiteLetterSend);
		return MODULE_PATH + "viewContent";
	}
}
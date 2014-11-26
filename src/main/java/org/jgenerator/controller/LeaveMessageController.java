package org.jgenerator.controller;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.LeaveMessage;
import org.jgenerator.model.PortalUser;
import org.jgenerator.model.entityArray.LeaveMessageArray;
import org.jgenerator.service.LeaveMessageService;
import org.sagacity.util.datetime.DateTimeUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class LeaveMessageController {
	public static final String MODULE_PATH = "manage/leaveMessage/";
	public static final String PORTAL_MODULE_PATH = "portal/leaveMessage/";
	@Resource
	private LeaveMessageService leaveMessageServiceImpl;

	@RequestMapping(value = "/manage/leaveMessage/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/leaveMessage/query")
	@ResponseBody
	public Map<String, Object> query(LeaveMessage leaveMessage, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<LeaveMessage> pager = leaveMessageServiceImpl.queryPage(leaveMessage,
				page, rows, orderBy, sortBy);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", pager.getDataList());
		return result;
	}
	
	@RequestMapping(value = "/manage/leaveMessage/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/portal/leaveMessage/add")
	@ResponseBody
	public String add(LeaveMessage leaveMessage, HttpSession session){
		leaveMessage.setStatus(0);
		leaveMessage.setDeployTime(DateTimeUtil.getCurrentDateTime());
		
		PortalUser user = (PortalUser) session.getAttribute("portalUser");
		leaveMessage.setAttribute1(user.getUsername());
		leaveMessageServiceImpl.save(leaveMessage);
		return "1";
	}
	
	@RequestMapping(value = "/manage/leaveMessage/toEdit")
	public String toEdit(Model model, Integer id){
		LeaveMessage leaveMessage = leaveMessageServiceImpl.fetch(id);
		model.addAttribute("leaveMessage", leaveMessage);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/leaveMessage/edit")
	@ResponseBody
	public String edit(LeaveMessage leaveMessage){
		leaveMessage.setStatus(1);
		leaveMessageServiceImpl.saveOrUpdate(leaveMessage);
		return "1";
	}
	
	@RequestMapping(value = "/manage/leaveMessage/deleteByIds")
	@ResponseBody
	public String deleteByIds(LeaveMessageArray array){
		if(null != array && null != array.getLeaveMessageArray()){
			for(LeaveMessage entity : array.getLeaveMessageArray()){
				leaveMessageServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
	
	@RequestMapping(value = "/portal/leaveMessage/list")
	public String list(){
		return PORTAL_MODULE_PATH + "list";
	}
}
package org.jgenerator.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jgenerator.core.model.GroupCount;
import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.PortalUser;
import org.jgenerator.model.WebsiteAccessRecords;
import org.jgenerator.model.entityArray.WebsiteAccessRecordsArray;
import org.jgenerator.service.WebsiteAccessRecordsService;
import org.sagacity.util.datetime.DateTimeUtil;
import org.sagacity.util.http.NetUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class WebsiteAccessRecordsController {
	public static final String MODULE_PATH = "manage/websiteAccessRecords/";
	@Resource
	private WebsiteAccessRecordsService websiteAccessRecordsServiceImpl;

	@RequestMapping(value = "/manage/websiteAccessRecords/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/websiteAccessRecords/query")
	@ResponseBody
	public Map<String, Object> query(WebsiteAccessRecords websiteAccessRecords, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<WebsiteAccessRecords> pager = websiteAccessRecordsServiceImpl.queryPage(websiteAccessRecords,
				page, rows, orderBy, sortBy);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", pager.getDataList());
		return result;
	}
	
	@RequestMapping(value = "/manage/websiteAccessRecords/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/websiteAccessRecords/add")
	@ResponseBody
	public String add(WebsiteAccessRecords websiteAccessRecords){
		websiteAccessRecordsServiceImpl.save(websiteAccessRecords);
		return "1";
	}
	
	@RequestMapping(value = "/manage/websiteAccessRecords/toEdit")
	public String toEdit(Model model, Integer id){
		WebsiteAccessRecords websiteAccessRecords = websiteAccessRecordsServiceImpl.fetch(id);
		model.addAttribute("websiteAccessRecords", websiteAccessRecords);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/websiteAccessRecords/edit")
	@ResponseBody
	public String edit(WebsiteAccessRecords websiteAccessRecords){
		websiteAccessRecordsServiceImpl.saveOrUpdate(websiteAccessRecords);
		return "1";
	}
	
	@RequestMapping(value = "/manage/websiteAccessRecords/deleteByIds")
	@ResponseBody
	public String deleteByIds(WebsiteAccessRecordsArray array){
		if(null != array && null != array.getWebsiteAccessRecordsArray()){
			for(WebsiteAccessRecords entity : array.getWebsiteAccessRecordsArray()){
				websiteAccessRecordsServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
	
	@RequestMapping(value = "/manage/websiteAccessRecords/countWebsiteAccessRecords")
	public String countPortalUser(String groupBy, Model model){
		List<GroupCount> list = websiteAccessRecordsServiceImpl.getCount("browserVersion");
		model.addAttribute("countList", list);
		return MODULE_PATH + "count";
	}
	
	/**
	 * 访问记录
	 * @param 
	 * @name insert
	 * @active
	 * @state
	 * @type String
	 * @time 下午04:56:28
	 * @exception/throws
	 * @see
	 * @since
	 * @param websiteAccessRecords
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/portal/websiteAccessRecords/insert", method = RequestMethod.POST)
	@ResponseBody
	public String insert(WebsiteAccessRecords websiteAccessRecords, HttpServletRequest request){
		websiteAccessRecords.setIp(NetUtil.getRemortIP(request, null));
		websiteAccessRecords.setSource(NetUtil.getReferer(request));
		websiteAccessRecords.setViewDate(DateTimeUtil.getCurrentDateTime());
		
		if(null != request.getSession() && null != request.getSession().getAttribute("portalUser")){
			PortalUser u = (PortalUser)request.getSession().getAttribute("portalUser");
			websiteAccessRecords.setViewUser(u.getUsername());
		} else{
			websiteAccessRecords.setViewUser("未注册用户");
		}
		websiteAccessRecordsServiceImpl.save(websiteAccessRecords);
		return "1";
	}
}
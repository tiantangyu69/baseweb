package org.jgenerator.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.PortalUserType;
import org.jgenerator.model.entityArray.PortalUserTypeArray;
import org.jgenerator.service.PortalUserTypeService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class PortalUserTypeController {
	public static final String MODULE_PATH = "manage/portalUserType/";
	@Resource
	private PortalUserTypeService portalUserTypeServiceImpl;

	@RequestMapping(value = "/manage/portalUserType/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/portalUserType/query")
	@ResponseBody
	public Map<String, Object> query(PortalUserType portalUserType, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<PortalUserType> pager = portalUserTypeServiceImpl.queryPage(portalUserType,
				page, rows, orderBy, sortBy);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", pager.getDataList());
		return result;
	}
	
	@RequestMapping(value = "/manage/portalUserType/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/portalUserType/add")
	@ResponseBody
	public String add(PortalUserType portalUserType){
		portalUserTypeServiceImpl.save(portalUserType);
		return "1";
	}
	
	@RequestMapping(value = "/manage/portalUserType/toEdit")
	public String toEdit(Model model, Integer id){
		PortalUserType portalUserType = portalUserTypeServiceImpl.fetch(id);
		model.addAttribute("portalUserType", portalUserType);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/portalUserType/edit")
	@ResponseBody
	public String edit(PortalUserType portalUserType){
		portalUserTypeServiceImpl.saveOrUpdate(portalUserType);
		return "1";
	}
	
	@RequestMapping(value = "/manage/portalUserType/deleteByIds")
	@ResponseBody
	public String deleteByIds(PortalUserTypeArray array){
		if(null != array && null != array.getPortalUserTypeArray()){
			for(PortalUserType entity : array.getPortalUserTypeArray()){
				portalUserTypeServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
	
	@RequestMapping(value = "/manage/portalUserType/queryCombobox")
	@ResponseBody
	public List<PortalUserType> queryCombobox(PortalUserType portalUserType, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<PortalUserType> pager = portalUserTypeServiceImpl.queryPage(portalUserType,
				page, Integer.MAX_VALUE, orderBy, sortBy);
		return pager.getDataList();
	}
}
package org.jgenerator.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.SinglePageType;
import org.jgenerator.model.entityArray.SinglePageTypeArray;
import org.jgenerator.service.SinglePageTypeService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class SinglePageTypeController {
	public static final String MODULE_PATH = "manage/singlePageType/";
	@Resource
	private SinglePageTypeService singlePageTypeServiceImpl;

	@RequestMapping(value = "/manage/singlePageType/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/singlePageType/query")
	@ResponseBody
	public Map<String, Object> query(SinglePageType singlePageType, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<SinglePageType> pager = singlePageTypeServiceImpl.queryPage(singlePageType,
				page, rows, orderBy, sortBy);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", pager.getDataList());
		return result;
	}
	
	@RequestMapping(value = "/manage/singlePageType/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/singlePageType/add")
	@ResponseBody
	public String add(SinglePageType singlePageType){
		singlePageTypeServiceImpl.save(singlePageType);
		return "1";
	}
	
	@RequestMapping(value = "/manage/singlePageType/toEdit")
	public String toEdit(Model model, Integer id){
		SinglePageType singlePageType = singlePageTypeServiceImpl.fetch(id);
		model.addAttribute("singlePageType", singlePageType);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/singlePageType/edit")
	@ResponseBody
	public String edit(SinglePageType singlePageType){
		singlePageTypeServiceImpl.saveOrUpdate(singlePageType);
		return "1";
	}
	
	@RequestMapping(value = "/manage/singlePageType/deleteByIds")
	@ResponseBody
	public String deleteByIds(SinglePageTypeArray array){
		if(null != array && null != array.getSinglePageTypeArray()){
			for(SinglePageType entity : array.getSinglePageTypeArray()){
				singlePageTypeServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
	
	@RequestMapping(value = "/manage/singlePageType/queryCombobox")
	@ResponseBody
	public List<SinglePageType> queryCombobox(SinglePageType singlePageType, 
			Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<SinglePageType> pager = singlePageTypeServiceImpl.queryPage(singlePageType,
				page, Integer.MAX_VALUE, orderBy, sortBy);
		return pager.getDataList();
	}
}
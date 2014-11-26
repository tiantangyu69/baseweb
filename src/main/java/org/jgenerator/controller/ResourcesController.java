package org.jgenerator.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.Resources;
import org.jgenerator.model.entityArray.ResourcesArray;
import org.jgenerator.service.ResourcesService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class ResourcesController {
	public static final String MODULE_PATH = "manage/resources/";
	@Resource
	private ResourcesService resourcesServiceImpl;

	@RequestMapping(value = "/manage/resources/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}
	
	@RequestMapping(value = "/manage/resources/query")
	@ResponseBody
	public List<Resources> query(Resources resources,Integer id) {
		Map<String, Object> params= new HashMap<String, Object>();
		if (null == id) {
			id = -1;
		}else{
			params.remove("id");
		}
		params.put("parentId", id);
		Pager<Resources> pager = resourcesServiceImpl.queryPage(params, 1, Integer.MAX_VALUE);
		if(-1 != id && null != pager.getDataList()){
			for(Resources r : pager.getDataList()){
				r.setState("open");
			}
		}
		return pager.getDataList();
	}
	
	@RequestMapping(value = "/manage/resources/toAdd")
	public String toAdd(){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/resources/add")
	@ResponseBody
	public String add(Resources resources){
		resourcesServiceImpl.save(resources);
		return "1";
	}
	
	@RequestMapping(value = "/manage/resources/toEdit")
	public String toEdit(Model model, Integer id){
		Resources resources = resourcesServiceImpl.fetch(id);
		model.addAttribute("resources", resources);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/resources/edit")
	@ResponseBody
	public String edit(Resources resources){
		resourcesServiceImpl.saveOrUpdate(resources);
		return "1";
	}
	
	@RequestMapping(value = "/manage/resources/deleteByIds")
	@ResponseBody
	public String deleteByIds(ResourcesArray array){
		if(null != array && null != array.getResourcesArray()){
			for(Resources entity : array.getResourcesArray()){
				resourcesServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
}
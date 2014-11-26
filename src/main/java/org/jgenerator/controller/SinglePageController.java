package org.jgenerator.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.SinglePage;
import org.jgenerator.model.entityArray.SinglePageArray;
import org.jgenerator.service.SinglePageService;
import org.jgenerator.service.SinglePageTypeService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class SinglePageController {
	public static final String MODULE_PATH = "manage/singlePage/";
	@Resource
	private SinglePageService singlePageServiceImpl;
	@Resource
	private SinglePageTypeService singlePageTypeServiceImpl;

	@RequestMapping(value = "/manage/singlePage/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/singlePage/query")
	@ResponseBody
	public Map<String, Object> query(SinglePage singlePage, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<SinglePage> pager = singlePageServiceImpl.queryPage(singlePage,
				page, rows, orderBy, sortBy);
		List<SinglePage> list = new ArrayList<SinglePage>();
		for(SinglePage s : pager.getDataList()){
			s.setSinglePageType(singlePageTypeServiceImpl.fetch(s.getSinglePageTypeId()));
			list.add(s);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", list);
		return result;
	}
	
	@RequestMapping(value = "/manage/singlePage/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/singlePage/add")
	@ResponseBody
	public String add(SinglePage singlePage){
		singlePageServiceImpl.save(singlePage);
		return "1";
	}
	
	@RequestMapping(value = "/manage/singlePage/toEdit")
	public String toEdit(Model model, Integer id){
		SinglePage singlePage = singlePageServiceImpl.fetch(id);
		model.addAttribute("singlePage", singlePage);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/singlePage/edit")
	@ResponseBody
	public String edit(SinglePage singlePage){
		singlePageServiceImpl.saveOrUpdate(singlePage);
		return "1";
	}
	
	@RequestMapping(value = "/manage/singlePage/deleteByIds")
	@ResponseBody
	public String deleteByIds(SinglePageArray array){
		if(null != array && null != array.getSinglePageArray()){
			for(SinglePage entity : array.getSinglePageArray()){
				singlePageServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
	
	@RequestMapping(value = "/manage/singlePage/fetchSinglePage")
	public String fetchSinglePage(Integer id, Model model){
		SinglePage s = singlePageServiceImpl.fetch(id);
		model.addAttribute("view", s);
		return MODULE_PATH + "content";
	}
}
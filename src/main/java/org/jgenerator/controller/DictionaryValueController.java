package org.jgenerator.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.DictionaryValue;
import org.jgenerator.model.entityArray.DictionaryValueArray;
import org.jgenerator.service.DictionaryTypeService;
import org.jgenerator.service.DictionaryValueService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class DictionaryValueController {
	public static final String MODULE_PATH = "manage/dictionaryValue/";
	@Resource
	private DictionaryValueService dictionaryValueServiceImpl;
	@Resource
	private DictionaryTypeService dictionaryTypeServiceImpl;

	@RequestMapping(value = "/manage/dictionaryValue/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/dictionaryValue/query")
	@ResponseBody
	public Map<String, Object> query(DictionaryValue dictionaryValue, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<DictionaryValue> pager = dictionaryValueServiceImpl.queryPage(dictionaryValue,
				page, rows, orderBy, sortBy);
		List<DictionaryValue> list = new ArrayList<DictionaryValue>();
		for(DictionaryValue d : pager.getDataList()){
			d.setDictionaryType(dictionaryTypeServiceImpl.fetch(d.getDictionaryTypeId()));
			list.add(d);
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", list);
		return result;
	}
	
	@RequestMapping(value = "/manage/dictionaryValue/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/dictionaryValue/add")
	@ResponseBody
	public String add(DictionaryValue dictionaryValue){
		dictionaryValueServiceImpl.save(dictionaryValue);
		return "1";
	}
	
	@RequestMapping(value = "/manage/dictionaryValue/toEdit")
	public String toEdit(Model model, Integer id){
		DictionaryValue dictionaryValue = dictionaryValueServiceImpl.fetch(id);
		model.addAttribute("dictionaryValue", dictionaryValue);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/dictionaryValue/edit")
	@ResponseBody
	public String edit(DictionaryValue dictionaryValue){
		dictionaryValueServiceImpl.saveOrUpdate(dictionaryValue);
		return "1";
	}
	
	@RequestMapping(value = "/manage/dictionaryValue/deleteByIds")
	@ResponseBody
	public String deleteByIds(DictionaryValueArray array){
		if(null != array && null != array.getDictionaryValueArray()){
			for(DictionaryValue entity : array.getDictionaryValueArray()){
				dictionaryValueServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
	
	@RequestMapping(value = "/manage/dictionaryValue/queryCombobox")
	@ResponseBody
	public List<DictionaryValue> queryCombobox(DictionaryValue dictionaryValue, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dictionaryTypeId", dictionaryValue.getDictionaryTypeId());
		Pager<DictionaryValue> pager = dictionaryValueServiceImpl.queryPage(params, page, Integer.MAX_VALUE);
		return pager.getDataList();
	}
}
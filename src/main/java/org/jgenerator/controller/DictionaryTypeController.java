package org.jgenerator.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.DictionaryType;
import org.jgenerator.model.entityArray.DictionaryTypeArray;
import org.jgenerator.model.vo.Result;
import org.jgenerator.service.DictionaryTypeService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class DictionaryTypeController {
	public static final String MODULE_PATH = "manage/dictionaryType/";
	@Resource
	private DictionaryTypeService dictionaryTypeServiceImpl;

	@RequestMapping(value = "/manage/dictionaryType/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/dictionaryType/query")
	@ResponseBody
	public Map<String, Object> query(DictionaryType dictionaryType, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<DictionaryType> pager = dictionaryTypeServiceImpl.queryPage(dictionaryType,
				page, rows, orderBy, sortBy);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", pager.getDataList());
		return result;
	}
	
	@RequestMapping(value = "/manage/dictionaryType/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/dictionaryType/add")
	@ResponseBody
	public Result add(DictionaryType dictionaryType){
		try{
			dictionaryTypeServiceImpl.save(dictionaryType);
		}catch(Exception e){
			return new Result(Result.ERROR, "字典类型添加失败！");
		}
		return new Result(Result.SUCCESS, "字典类型添加成功！");
	}
	
	@RequestMapping(value = "/manage/dictionaryType/toEdit")
	public String toEdit(Model model, Integer id){
		DictionaryType dictionaryType = dictionaryTypeServiceImpl.fetch(id);
		model.addAttribute("dictionaryType", dictionaryType);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/dictionaryType/edit")
	@ResponseBody
	public Result edit(DictionaryType dictionaryType){
		try{
			dictionaryTypeServiceImpl.saveOrUpdate(dictionaryType);
		}catch(Exception e){
			return new Result(Result.ERROR, "字典类型修改失败！");
		}
		return new Result(Result.SUCCESS, "字典类型修改成功！");
	}
	
	@RequestMapping(value = "/manage/dictionaryType/deleteByIds")
	@ResponseBody
	public Result deleteByIds(DictionaryTypeArray array){
		if(null != array && null != array.getDictionaryTypeArray()){
			try{
				for(DictionaryType entity : array.getDictionaryTypeArray()){
					dictionaryTypeServiceImpl.delete(entity.getId());
				}
			}catch(Exception e){
				return new Result(Result.ERROR, "字典类型删除失败，该类型下含有字典值！");
			}
		}
		return new Result(Result.SUCCESS, "字典类型删除成功！");
	}
	
	@RequestMapping(value = "/manage/dictionaryType/queryCombobox")
	@ResponseBody
	public List<DictionaryType> queryCombobox(DictionaryType dictionaryType, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<DictionaryType> pager = dictionaryTypeServiceImpl.queryPage(dictionaryType,
				page, Integer.MAX_VALUE, orderBy, sortBy);
		return pager.getDataList();
	}
}
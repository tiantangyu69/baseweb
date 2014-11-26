package org.jgenerator.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.Province;
import org.jgenerator.model.entityArray.ProvinceArray;
import org.jgenerator.service.ProvinceService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class ProvinceController {
	public static final String MODULE_PATH = "manage/province/";
	@Resource
	private ProvinceService provinceServiceImpl;

	@RequestMapping(value = "/manage/province/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/province/query")
	@ResponseBody
	public Map<String, Object> query(Province province, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<Province> pager = provinceServiceImpl.queryPage(province,
				page, rows, orderBy, sortBy);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", pager.getDataList());
		return result;
	}
	
	@RequestMapping(value = "/manage/province/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/province/add")
	@ResponseBody
	public String add(Province province){
		provinceServiceImpl.save(province);
		return "1";
	}
	
	@RequestMapping(value = "/manage/province/toEdit")
	public String toEdit(Model model, Integer id){
		Province province = provinceServiceImpl.fetch(id);
		model.addAttribute("province", province);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/province/edit")
	@ResponseBody
	public String edit(Province province){
		provinceServiceImpl.saveOrUpdate(province);
		return "1";
	}
	
	@RequestMapping(value = "/manage/province/deleteByIds")
	@ResponseBody
	public String deleteByIds(ProvinceArray array){
		if(null != array && null != array.getProvinceArray()){
			for(Province entity : array.getProvinceArray()){
				provinceServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
	
	/**
	 * 查询所有省市
	 * @param 
	 * @name queryCombobox
	 * @active
	 * @state
	 * @type List<Province>
	 * @time 下午03:44:01
	 * @exception/throws
	 * @see
	 * @since
	 * @return
	 */
	@RequestMapping(value = "/provinceCombobox")
	@ResponseBody
	public List<Province> queryCombobox(){
		List<Province> list = provinceServiceImpl.findAll();
		return list;
	}
}
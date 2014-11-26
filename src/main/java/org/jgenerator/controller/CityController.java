package org.jgenerator.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.City;
import org.jgenerator.model.entityArray.CityArray;
import org.jgenerator.service.CityService;
import org.jgenerator.service.ProvinceService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class CityController {
	public static final String MODULE_PATH = "manage/city/";
	@Resource
	private CityService cityServiceImpl;
	@Resource
	private ProvinceService provinceServiceImpl;

	@RequestMapping(value = "/manage/city/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/city/query")
	@ResponseBody
	public Map<String, Object> query(City city, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		List<City> list = new ArrayList<City>();
		Pager<City> pager = cityServiceImpl.queryPage(city,
				page, rows, orderBy, sortBy);
		for(City c : pager.getDataList()){
			if(null != c.getProvinceId()){
				c.setProvince(provinceServiceImpl.fetch(c.getProvinceId()));
			}
			list.add(c);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", list);
		return result;
	}
	
	@RequestMapping(value = "/manage/city/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/city/add")
	@ResponseBody
	public String add(City city){
		cityServiceImpl.save(city);
		return "1";
	}
	
	@RequestMapping(value = "/manage/city/toEdit")
	public String toEdit(Model model, Integer id){
		City city = cityServiceImpl.fetch(id);
		model.addAttribute("city", city);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/city/edit")
	@ResponseBody
	public String edit(City city){
		cityServiceImpl.saveOrUpdate(city);
		return "1";
	}
	
	@RequestMapping(value = "/manage/city/deleteByIds")
	@ResponseBody
	public String deleteByIds(CityArray array){
		if(null != array && null != array.getCityArray()){
			for(City entity : array.getCityArray()){
				cityServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
	
	/**
	 * 根据省市查询所有城市
	 * @param 
	 * @name queryByProvinceId
	 * @active
	 * @state
	 * @type List<City>
	 * @time 上午10:41:48
	 * @exception/throws
	 * @see
	 * @since
	 * @param provinceId
	 * @return
	 */
	@RequestMapping(value = "/manage/city/queryByProvinceId")
	@ResponseBody
	public List<City> queryByProvinceId(Integer provinceId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("provinceId", provinceId);
		List<City> list = cityServiceImpl.queryPage(params, 1, Integer.MAX_VALUE).getDataList();
		return list;
	}
}
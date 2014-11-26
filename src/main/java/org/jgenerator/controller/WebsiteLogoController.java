package org.jgenerator.controller;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import org.jgenerator.model.WebsiteLogo;
import org.jgenerator.model.entityArray.WebsiteLogoArray;
import org.jgenerator.service.WebsiteLogoService;
import org.jgenerator.core.util.page.Pager;
import java.util.HashMap;
import java.util.Map;

@Controller
@Scope("request")
public class WebsiteLogoController {
	public static final String MODULE_PATH = "manage/websiteLogo/";
	@Resource
	private WebsiteLogoService websiteLogoServiceImpl;

	@RequestMapping(value = "/manage/websiteLogo/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/websiteLogo/query")
	@ResponseBody
	public Map<String, Object> query(WebsiteLogo websiteLogo, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<WebsiteLogo> pager = websiteLogoServiceImpl.queryPage(websiteLogo,
				page, rows, orderBy, sortBy);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", pager.getDataList());
		return result;
	}
	
	@RequestMapping(value = "/manage/websiteLogo/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/websiteLogo/add")
	@ResponseBody
	public String add(WebsiteLogo websiteLogo){
		websiteLogoServiceImpl.save(websiteLogo);
		return "1";
	}
	
	@RequestMapping(value = "/manage/websiteLogo/toEdit")
	public String toEdit(Model model, Integer id){
		WebsiteLogo websiteLogo = websiteLogoServiceImpl.fetch(id);
		model.addAttribute("websiteLogo", websiteLogo);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/websiteLogo/edit")
	@ResponseBody
	public String edit(WebsiteLogo websiteLogo){
		websiteLogoServiceImpl.saveOrUpdate(websiteLogo);
		return "1";
	}
	
	@RequestMapping(value = "/manage/websiteLogo/deleteByIds")
	@ResponseBody
	public String deleteByIds(WebsiteLogoArray array){
		if(null != array && null != array.getWebsiteLogoArray()){
			for(WebsiteLogo entity : array.getWebsiteLogoArray()){
				websiteLogoServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
}
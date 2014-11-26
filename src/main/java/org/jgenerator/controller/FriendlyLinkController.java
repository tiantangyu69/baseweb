package org.jgenerator.controller;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import org.jgenerator.model.FriendlyLink;
import org.jgenerator.model.entityArray.FriendlyLinkArray;
import org.jgenerator.service.FriendlyLinkService;
import org.jgenerator.core.util.page.Pager;
import java.util.HashMap;
import java.util.Map;

@Controller
@Scope("request")
public class FriendlyLinkController {
	public static final String MODULE_PATH = "manage/friendlyLink/";
	@Resource
	private FriendlyLinkService friendlyLinkServiceImpl;

	@RequestMapping(value = "/manage/friendlyLink/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/friendlyLink/query")
	@ResponseBody
	public Map<String, Object> query(FriendlyLink friendlyLink, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<FriendlyLink> pager = friendlyLinkServiceImpl.queryPage(friendlyLink,
				page, rows, orderBy, sortBy);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", pager.getDataList());
		return result;
	}
	
	@RequestMapping(value = "/manage/friendlyLink/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/friendlyLink/add")
	@ResponseBody
	public String add(FriendlyLink friendlyLink){
		friendlyLinkServiceImpl.save(friendlyLink);
		return "1";
	}
	
	@RequestMapping(value = "/manage/friendlyLink/toEdit")
	public String toEdit(Model model, Integer id){
		FriendlyLink friendlyLink = friendlyLinkServiceImpl.fetch(id);
		model.addAttribute("friendlyLink", friendlyLink);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/friendlyLink/edit")
	@ResponseBody
	public String edit(FriendlyLink friendlyLink){
		friendlyLinkServiceImpl.saveOrUpdate(friendlyLink);
		return "1";
	}
	
	@RequestMapping(value = "/manage/friendlyLink/deleteByIds")
	@ResponseBody
	public String deleteByIds(FriendlyLinkArray array){
		if(null != array && null != array.getFriendlyLinkArray()){
			for(FriendlyLink entity : array.getFriendlyLinkArray()){
				friendlyLinkServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
}
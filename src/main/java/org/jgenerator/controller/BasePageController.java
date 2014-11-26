package org.jgenerator.controller;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import org.jgenerator.model.BasePage;
import org.jgenerator.model.entityArray.BasePageArray;
import org.jgenerator.service.BasePageService;
import org.jgenerator.core.util.page.Pager;
import java.util.HashMap;
import java.util.Map;

@Controller
@Scope("request")
public class BasePageController {
	public static final String MODULE_PATH = "manage/basePage/";
	public static final String PORTAL_MODULE_PATH = "portal/basePage/";
	@Resource
	private BasePageService basePageServiceImpl;

	@RequestMapping(value = "/manage/basePage/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/basePage/query")
	@ResponseBody
	public Map<String, Object> query(BasePage basePage, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<BasePage> pager = basePageServiceImpl.queryPage(basePage,
				page, rows, orderBy, sortBy);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", pager.getDataList());
		return result;
	}
	
	@RequestMapping(value = "/manage/basePage/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/basePage/add")
	@ResponseBody
	public String add(BasePage basePage){
		basePageServiceImpl.save(basePage);
		return "1";
	}
	
	@RequestMapping(value = "/manage/basePage/toEdit")
	public String toEdit(Model model, String code){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", code);
		Pager<BasePage> pager = basePageServiceImpl.queryPage(params, 1, 1);
		if(null != pager.getDataList() && pager.getDataList().size() > 0){
			model.addAttribute("basePage", pager.getDataList().get(0));	
		}
		if(code.equals("base001")){
			// 公司简介页面
			return MODULE_PATH + "companyProfile";
		} else if(code.equals("base002")){
			// 会员注册协议页面
			return MODULE_PATH + "registerProtocol";
		} else if(code.equals("base003")){
			// 联系我们页面
			return MODULE_PATH + "contactUs";
		} else{
			return "";
		}
	}
	
	@RequestMapping(value = "/manage/basePage/edit")
	@ResponseBody
	public String edit(BasePage basePage){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", basePage.getCode());
		Pager<BasePage> pager = basePageServiceImpl.queryPage(params, 1, 1);
		if(null != pager.getDataList() && pager.getDataList().size() > 0){
			basePage.setId(pager.getDataList().get(0).getId());	
		}
		basePageServiceImpl.saveOrUpdate(basePage);
		return "1";
	}
	
	@RequestMapping(value = "/manage/basePage/deleteByIds")
	@ResponseBody
	public String deleteByIds(BasePageArray array){
		if(null != array && null != array.getBasePageArray()){
			for(BasePage entity : array.getBasePageArray()){
				basePageServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
	
	/**
	 * 公司简介
	 * @param 
	 * @name companyInfo
	 * @active
	 * @state
	 * @type String
	 * @time 下午03:32:14
	 * @exception/throws
	 * @see
	 * @since
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/portal/companyInfo")
	public String companyInfo(Model model){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", "base001");
		Pager<BasePage> pager = basePageServiceImpl.queryPage(params, 1, 1);
		if(null != pager.getDataList() && pager.getDataList().size() > 0){
			model.addAttribute("basePage", pager.getDataList().get(0));	
		}
		return PORTAL_MODULE_PATH + "companyInfo";
	}
	
	/**
	 * 联系我们
	 * @param 
	 * @name contactUs
	 * @active
	 * @state
	 * @type String
	 * @time 下午03:32:52
	 * @exception/throws
	 * @see
	 * @since
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/portal/contactUs")
	public String contactUs(Model model){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", "base003");
		Pager<BasePage> pager = basePageServiceImpl.queryPage(params, 1, 1);
		if(null != pager.getDataList() && pager.getDataList().size() > 0){
			model.addAttribute("basePage", pager.getDataList().get(0));	
		}
		return PORTAL_MODULE_PATH + "contactUs";
	}
}
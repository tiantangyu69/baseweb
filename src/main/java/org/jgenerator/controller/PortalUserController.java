package org.jgenerator.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.jgenerator.core.model.GroupCount;
import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.PortalUser;
import org.jgenerator.model.entityArray.PortalUserArray;
import org.jgenerator.service.PortalUserService;
import org.jgenerator.service.PortalUserTypeService;
import org.sagacity.util.datetime.DateTimeUtil;
import org.sagacity.util.security.EncrypMD5;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class PortalUserController {
	public static final String MODULE_PATH = "manage/portalUser/";
	@Resource
	private PortalUserService portalUserServiceImpl;
	
	@Resource
	private PortalUserTypeService portalUserTypeServiceImpl;

	@RequestMapping(value = "/manage/portalUser/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/portalUser/query")
	@ResponseBody
	public Map<String, Object> query(PortalUser portalUser, 
		Integer page, Integer rows, String orderBy, String sortBy) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("portalUserTypeId", portalUser.getPortalUserTypeId());
		params.put("andLikeUsername", StringUtils.trimToNull(portalUser.getUsername()));
		
		Pager<PortalUser> pager = portalUserServiceImpl.queryPage(params,page, rows);
		List<PortalUser> list = new ArrayList<PortalUser>();
		for(PortalUser p : pager.getDataList()){
			p.setPortalUserType(portalUserTypeServiceImpl.fetch(p.getPortalUserTypeId()));
			list.add(p);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", list);
		return result;
	}
	
	@RequestMapping(value = "/manage/portalUser/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/portalUser/add")
	@ResponseBody
	public String add(PortalUser portalUser){
		portalUser.setAttribute3(DateTimeUtil.getCurrentDate("yyyy"));
		if(null != portalUser.getPassword()){
			portalUser.setPassword(EncrypMD5.encode(portalUser.getPassword()));
		}
		portalUser.setAttribute2(DateTimeUtil.getCurrentDate());
		portalUserServiceImpl.save(portalUser);
		return "1";
	}
	
	@RequestMapping(value = "/manage/portalUser/toEdit")
	public String toEdit(Model model, Integer id){
		PortalUser portalUser = portalUserServiceImpl.fetch(id);
		model.addAttribute("portalUser", portalUser);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/portalUser/toValidate")
	public String toValidate(Model model, Integer id){
		PortalUser portalUser = portalUserServiceImpl.fetch(id);
		model.addAttribute("portalUser", portalUser);
		return MODULE_PATH + "validate";
	}

	/**
	 * 审核用户
	 * @param 
	 * @name validate
	 * @active
	 * @state
	 * @type String
	 * @time 下午04:56:56
	 * @exception/throws
	 * @see
	 * @since
	 * @param model
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/manage/portalUser/validate", method = RequestMethod.POST)
	@ResponseBody
	public String validate(Model model, Integer id, String status){
		PortalUser portalUser = new PortalUser();
		portalUser.setId(id);
		portalUser.setAttribute12(status);
		portalUserServiceImpl.saveOrUpdate(portalUser);
		return "1";
	}
	
	@RequestMapping(value = "/manage/portalUser/edit")
	@ResponseBody
	public String edit(PortalUser portalUser){
		if(null != portalUser.getPassword()){
			portalUser.setPassword(EncrypMD5.encode(portalUser.getPassword()));
		}
		portalUserServiceImpl.saveOrUpdate(portalUser);
		return "1";
	}
	
	@RequestMapping(value = "/manage/portalUser/deleteByIds")
	@ResponseBody
	public String deleteByIds(PortalUserArray array){
		if(null != array && null != array.getPortalUserArray()){
			for(PortalUser entity : array.getPortalUserArray()){
				portalUserServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
	
	@RequestMapping(value = "/manage/portalUser/countPortalUser")
	public String countPortalUser(String groupBy, Model model){
		List<GroupCount> list = portalUserServiceImpl.getCount("attribute3");
		model.addAttribute("countList", list);
		return MODULE_PATH + "count";
	}
	
	@RequestMapping(value = "/portal/portalUser/edit", method = RequestMethod.POST)
	@ResponseBody
	public String portalEdit(PortalUser portalUser){
		if(null != portalUser.getPassword()){
			portalUser.setPassword(EncrypMD5.encode(portalUser.getPassword()));
		}
		portalUserServiceImpl.saveOrUpdate(portalUser);
		return "1";
	}
}
package org.jgenerator.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.ManageUserRole;
import org.jgenerator.model.entityArray.ManageUserRoleArray;
import org.jgenerator.service.ManageUserRoleService;
import org.jgenerator.service.ManageUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class ManageUserRoleController {
	public static final String MODULE_PATH = "manage/manageUserRole/";
	@Resource
	private ManageUserRoleService manageUserRoleServiceImpl;
	@Resource
	private ManageUserService manageUserServiceImpl;

	@RequestMapping(value = "/manage/manageUserRole/manager")
	public String manager(Model model, Integer roleId) {
		model.addAttribute("roleId", roleId);
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/manageUserRole/query")
	@ResponseBody
	public Map<String, Object> query(ManageUserRole manageUserRole) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("roleId", manageUserRole.getRoleId());
		Pager<ManageUserRole> pager = manageUserRoleServiceImpl.queryPage(params, 1, Integer.MAX_VALUE);
		if(null != pager.getDataList()){
			for(ManageUserRole mr : pager.getDataList()){
				mr.setManageUser(manageUserServiceImpl.fetch(mr.getUserId()));
			}
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", pager.getDataList());
		return result;
	}
	
	@RequestMapping(value = "/manage/manageUserRole/toAdd")
	public String toAdd(){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/manageUserRole/add")
	@ResponseBody
	public String add(ManageUserRoleArray manageUserRoleArray){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("roleId", manageUserRoleArray.getManageUserRoleArray().get(0).getRoleId());
		Pager<ManageUserRole> pager = manageUserRoleServiceImpl.queryPage(params, 1, Integer.MAX_VALUE);
		for(ManageUserRole m : manageUserRoleArray.getManageUserRoleArray()){
			if(null != pager.getDataList()){
				List<ManageUserRole> list = pager.getDataList();
				if(list.contains(m)){
					continue;
				}
			}
			manageUserRoleServiceImpl.save(m);
		}
		return "1";
	}
	
	@RequestMapping(value = "/manage/manageUserRole/toEdit")
	public String toEdit(Model model, Integer id){
		ManageUserRole manageUserRole = manageUserRoleServiceImpl.fetch(id);
		model.addAttribute("manageUserRole", manageUserRole);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/manageUserRole/edit")
	@ResponseBody
	public String edit(ManageUserRole manageUserRole){
		manageUserRoleServiceImpl.saveOrUpdate(manageUserRole);
		return "1";
	}
	
	@RequestMapping(value = "/manage/manageUserRole/deleteByIds")
	@ResponseBody
	public String deleteByIds(ManageUserRoleArray array){
		if(null != array && null != array.getManageUserRoleArray()){
			for(ManageUserRole entity : array.getManageUserRoleArray()){
				manageUserRoleServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
}
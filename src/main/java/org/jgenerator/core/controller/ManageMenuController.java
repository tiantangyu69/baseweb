package org.jgenerator.core.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.jgenerator.core.util.ManageMenuUtil;
import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.ManageMenu;
import org.jgenerator.model.ManageRoleResources;
import org.jgenerator.model.ManageUser;
import org.jgenerator.model.ManageUserRole;
import org.jgenerator.model.Resources;
import org.jgenerator.model.entityArray.ManageMenuArray;
import org.jgenerator.model.vo.ManageMenuVO;
import org.jgenerator.model.vo.Result;
import org.jgenerator.service.ManageMenuService;
import org.jgenerator.service.ManageRoleResourcesService;
import org.jgenerator.service.ManageUserRoleService;
import org.jgenerator.service.ResourcesService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class ManageMenuController {
	public static final String MODULE_PATH = "core/manageMenu/";
	@Resource
	private ManageMenuService manageMenuServiceImpl;
	@Resource
	private ResourcesService resourcesServiceImpl;
	@Resource
	private ManageUserRoleService manageUserRoleServiceImpl;
	@Resource
	private ManageRoleResourcesService manageRoleResourcesService;
	@Resource
	private ManageMenuUtil manageMenuUtil;

	@RequestMapping(value = "/manage/manageMenu/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/manageMenu/query")
	@ResponseBody
	public List<ManageMenu> query(ManageMenu manageMenu, Integer id) {
		Map<String, Object> params = manageMenu.toHashMap();
		if (null == id) {
			id = -1;
		} else {
			params.remove("id");
		}
		params.put("parentId", id);
		Pager<ManageMenu> pager = manageMenuServiceImpl.queryPage(params, 1,
				Integer.MAX_VALUE);
		if (-1 != id && null != pager.getDataList()) {
			for (ManageMenu m : pager.getDataList()) {
				m.setState("open");
			}
		}
		return pager.getDataList();
	}

	@RequestMapping(value = "/manage/manageMenu/toAdd")
	public String toAdd(Model model) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", -1);
		Pager<ManageMenu> pager = manageMenuServiceImpl.queryPage(params, 1,
				Integer.MAX_VALUE);
		model.addAttribute("menuList", pager.getDataList());
		return MODULE_PATH + "add";
	}

	@RequestMapping(value = "/manage/manageMenu/add")
	@ResponseBody
	public Result add(ManageMenu manageMenu) {
		try{
			manageMenuServiceImpl.save(manageMenu);
		}catch(Exception e){
			return new Result(Result.ERROR, "菜单添加失败!");
		}
		return new Result(Result.SUCCESS, "菜单添加成功!");
	}

	@RequestMapping(value = "/manage/manageMenu/toEdit")
	public String toEdit(Model model, Integer id) {
		ManageMenu manageMenu = manageMenuServiceImpl.fetch(id);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", -1);
		Pager<ManageMenu> pager = manageMenuServiceImpl.queryPage(params, 1,
				Integer.MAX_VALUE);
		model.addAttribute("menuList", pager.getDataList());
		model.addAttribute("manageMenu", manageMenu);
		return MODULE_PATH + "edit";
	}

	@RequestMapping(value = "/manage/manageMenu/edit")
	@ResponseBody
	public Result edit(ManageMenu manageMenu) {
		try{
			manageMenuServiceImpl.saveOrUpdate(manageMenu);
		}catch(Exception e){
			return new Result(Result.ERROR, "菜单修改失败！");
		}
		return new Result(Result.SUCCESS, "菜单修改成功！");
	}

	@RequestMapping(value = "/manage/manageMenu/deleteByIds")
	@ResponseBody
	public Result deleteByIds(ManageMenuArray array) {
		if (null != array && null != array.getManageMenuArray()) {
			try{
				for (ManageMenu entity : array.getManageMenuArray()) {
					manageMenuServiceImpl.delete(entity.getId());
				}
			}catch(Exception e){
				return new Result(Result.ERROR, "菜单删除失败！");
			}
		}
		return new Result(Result.SUCCESS, "菜单删除成功！");
	}

	/**
	 * @active 获取后台管理系统菜单导航
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/manage/manageMenu/getManageMenu")
	public String getManageMenu(Model model, HttpSession session) {
		ManageUser user = (ManageUser) session.getAttribute("user");
		Set<Resources> resources = getResources(user);
		List<ManageMenuVO> list = null;
		if (manageMenuUtil.isSuperAdmin(user.getUsername(), user.getPassword())) {
			list = manageMenuUtil.getSuperAdminMenu();
		} else {
			list = getRealMenu(resources);
		}
		model.addAttribute("menuList", list);
		return MODULE_PATH + "menuList";
	}

	/**
	 * @name importToResources
	 * @active 将菜单表中的数据导入到资源表中，类型为开发菜单的菜单将不被导入
	 * @state
	 * @type String
	 * @time 上午09:26:38
	 * @exception/throws
	 * @see
	 * @since
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/manage/manageMenu/importToResources", method = RequestMethod.POST)
	public String importToResources() {
		List<ManageMenu> menuList = manageMenuServiceImpl.findAll();
		List<Resources> resourcesList = resourcesServiceImpl.findAll();
		if (null != menuList) {
			for (ManageMenu m : menuList) {
				if (m.getType() != 3) {// 不处理开发的菜单
					if (null == resourcesList || resourcesList.size() == 0) {
						Resources r = new Resources();
						r.setId(m.getId());
						r.setCode("r00" + m.getId());
						r.setResourceType(m.getType());
						r.setName(m.getName());
						r.setUrl(m.getUrl());
						r.setParentId(m.getParentId());
						resourcesServiceImpl.save(r);
					} else {
						Resources r = new Resources();
						r.setId(m.getId());
						r.setCode("r00" + m.getId());
						r.setResourceType(m.getType());
						r.setName(m.getName());
						r.setUrl(m.getUrl());
						r.setParentId(m.getParentId());
						if (!resourcesList.contains(r)) {
							resourcesServiceImpl.save(r);
						} else {
							resourcesServiceImpl.saveOrUpdate(r);
						}
					}
				}
			}
		}
		if (null != resourcesList) {
			for (Resources resource : resourcesList) {
				ManageMenu m = new ManageMenu();
				m.setId(resource.getId());
				if (!menuList.contains(m)) {
					resourcesServiceImpl.delete(resource.getId());
				}
			}
		}
		return "1";
	}

	/**
	 * @name getResources
	 * @active 获取当前用户的权限
	 * @state
	 * @type Set<Resources>
	 * @time 上午09:26:21
	 * @exception/throws
	 * @see
	 * @since
	 * @param user
	 * @return
	 */
	private Set<Resources> getResources(ManageUser user) {
		Set<Resources> l = new HashSet<Resources>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", user.getId());
		List<ManageUserRole> list = manageUserRoleServiceImpl.findAll(params);
		for (ManageUserRole m : list) {
			Map<String, Object> params2 = new HashMap<String, Object>();
			params2.put("manageRoleId", m.getRoleId());
			List<ManageRoleResources> list2 = manageRoleResourcesService
					.findAll(params2);
			for (ManageRoleResources mr : list2) {
				Resources r = resourcesServiceImpl.fetch(mr.getResourceId());
				l.add(r);
			}
		}
		return l;
	}

	/**
	 * @name getRealMenu
	 * @active 取得当前登录用户的菜单
	 * @state
	 * @type List<ManageMenuVO>
	 * @time 上午09:09:13
	 * @exception/throws
	 * @see
	 * @since
	 * @param rs
	 * @return
	 */
	private List<ManageMenuVO> getRealMenu(Set<Resources> rs) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", -1);
		List<ManageMenuVO> list = new ArrayList<ManageMenuVO>();
		Pager<ManageMenu> pager = manageMenuServiceImpl.queryPage(params, 1,
				Integer.MAX_VALUE);
		if (null != pager.getDataList()) {
			for (ManageMenu m : pager.getDataList()) {
				Resources r = new Resources();
				r.setId(m.getId());
				if (rs.contains(r)) {
					ManageMenuVO mv = new ManageMenuVO();
					Map<String, Object> params2 = new HashMap<String, Object>();
					params2.put("parentId", m.getId());
					Pager<ManageMenu> pager2 = manageMenuServiceImpl.queryPage(
							params2, 1, Integer.MAX_VALUE);
					mv.setManageMenu(m);
					if(null != pager2.getDataList()){
						List<ManageMenu> subMenu = new ArrayList<ManageMenu>();
						for(ManageMenu m2 :pager2.getDataList()){
							Resources r2 = new Resources();
							r2.setId(m2.getId());
							if (rs.contains(r2)) {
								subMenu.add(m2);
							}
						}
						mv.setManageMenuList(subMenu);
					}
					list.add(mv);
				}
			}
		}
		return list;
	}
	
}
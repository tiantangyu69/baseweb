package org.jgenerator.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.Department;
import org.jgenerator.model.ManageUser;
import org.jgenerator.model.entityArray.ManageUserArray;
import org.jgenerator.model.vo.ManageUserVO;
import org.jgenerator.model.vo.Result;
import org.jgenerator.service.DepartmentService;
import org.jgenerator.service.ManageUserService;
import org.sagacity.util.security.EncrypMD5;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class ManageUserController {
	public static final String MODULE_PATH = "manage/manageUser/";
	@Resource
	private ManageUserService manageUserServiceImpl;
	@Resource
	private DepartmentService departmentServiceImpl;

	@RequestMapping(value = "/manage/manageUser/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/manageUser/query")
	@ResponseBody
	public Map<String, Object> query(ManageUser manageUser, Integer page,
			Integer rows, String orderBy, String sortBy) {
		Pager<ManageUser> pager = null;
		if (null != manageUser.getDepartment()) {
			pager = manageUserServiceImpl.findByDepartmentId(manageUser
					.getDepartment(), manageUser, rows, page);
		} else {
			pager = manageUserServiceImpl.queryPage(manageUser, page, rows,
					null, null);
		}
		List<ManageUser> list = new ArrayList<ManageUser>();
		for (ManageUser u : pager.getDataList()) {
			if (null != u.getDepartment()) {
				u.setDept(departmentServiceImpl.fetch(u.getDepartment()));
			} else {
				Department d = new Department();
				d.setName("未分配部门");
				u.setDept(d);
			}
			list.add(u);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", list);
		return result;
	}

	@RequestMapping(value = "/manage/manageUser/toAdd")
	public String toAdd() {
		return MODULE_PATH + "add";
	}

	@RequestMapping(value = "/manage/manageUser/add")
	@ResponseBody
	public Result add(ManageUser manageUser) {
		try {
			manageUser.setPassword(EncrypMD5.encode("111111"));
			manageUserServiceImpl.save(manageUser);
		} catch (Exception e) {
			return new Result(Result.ERROR, "用户添加失败！");
		}
		return new Result(Result.SUCCESS, "用户添加成功！");
	}

	@RequestMapping(value = "/manage/manageUser/toEdit")
	public String toEdit(Model model, Integer id) {
		ManageUser manageUser = manageUserServiceImpl.fetch(id);
		model.addAttribute("manageUser", manageUser);
		return MODULE_PATH + "edit";
	}

	@RequestMapping(value = "/manage/manageUser/edit")
	@ResponseBody
	public Result edit(ManageUser manageUser) {
		try {
			manageUserServiceImpl.saveOrUpdate(manageUser);
		} catch (Exception e) {
			return new Result(Result.ERROR, "用户修改失败！");
		}
		return new Result(Result.SUCCESS, "用户修改成功！");
	}

	@RequestMapping(value = "/manage/manageUser/deleteByIds")
	@ResponseBody
	public Result deleteByIds(ManageUserArray array) {
		try {
			if (null != array && null != array.getManageUserArray()) {
				for (ManageUser entity : array.getManageUserArray()) {
					manageUserServiceImpl.delete(entity.getId());
				}
			}
		} catch (Exception e) {
			return new Result(Result.ERROR, "用户删除失败！");
		}
		return new Result(Result.SUCCESS, "用户删除成功！");
	}

	/**
	 * 重置用户密码
	 * 
	 * @param array
	 * @return
	 */
	@RequestMapping(value = "/manage/manageUser/resetPassword")
	@ResponseBody
	public String resetPassword(ManageUserArray array) {
		if (null != array && null != array.getManageUserArray()) {
			for (ManageUser entity : array.getManageUserArray()) {
				entity.setPassword(EncrypMD5.encode("111111"));
				manageUserServiceImpl.saveOrUpdate(entity);
			}
		}
		return "1";
	}

	/**
	 * 到个人设置页面
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/manage/manageUser/toPersonSet")
	public String toPersonSet(HttpSession session, Model model) {
		ManageUser user = (ManageUser) session.getAttribute("user");
		Integer id = user.getId();
		user = manageUserServiceImpl.fetch(id);
		model.addAttribute("userInfo", user);
		return MODULE_PATH + "personSet";
	}

	@RequestMapping(value = "/manage/manageUser/selectUser")
	public String selectUser() {
		return MODULE_PATH + "selectUser";
	}

	/**
	 * 到修改密码页面
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/manage/manageUser/toModifyPassword")
	public String toModifyPassword(HttpSession session, Model model) {
		ManageUser user = (ManageUser) session.getAttribute("user");
		Integer id = user.getId();
		user = manageUserServiceImpl.fetch(id);
		model.addAttribute("userInfo", user);
		return MODULE_PATH + "modifyPassword";
	}

	/**
	 * 保存修改密码
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/manageUser/updateModifyPassword")
	@ResponseBody
	public String updateModifyPassword(ManageUserVO manageUserVO) {
		ManageUser sourceuser = manageUserServiceImpl.fetch(manageUserVO
				.getId());
		if (sourceuser.getPassword().equals(
				EncrypMD5.encode(manageUserVO.getPassword()))) {
			ManageUser user = new ManageUser();
			user.setId(manageUserVO.getId());
			user.setPassword(EncrypMD5.encode(manageUserVO.getNewPassword()));
			manageUserServiceImpl.saveOrUpdate(user);
			return "1";
		} else {
			return "2";
		}
	}

	/**
	 * 查询所有人员
	 * 
	 * @param
	 * @name queryAllManageUser
	 * @active
	 * @state
	 * @type String
	 * @time 下午05:26:31
	 * @exception/throws
	 * @see
	 * @since
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/manage/manageUser/queryAllManageUser")
	public String queryAllManageUser(Model model) {
		model.addAttribute("manageUserList", manageUserServiceImpl.findAll());
		return MODULE_PATH + "queryAllManageUser";
	}

	/**
	 * 查询所有人员,返回json数据
	 * 
	 * @param
	 * @name queryCombobox
	 * @active
	 * @state
	 * @type String
	 * @time 下午05:26:31
	 * @exception/throws
	 * @see
	 * @since
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/manage/manageUser/queryCombobox")
	@ResponseBody
	public List<ManageUser> queryCombobox() {
		return manageUserServiceImpl.findAll();
	}

	/**
	 * 发站内信
	 * 
	 * @param
	 * @name sendWebsiteLetter
	 * @active
	 * @state
	 * @type String
	 * @time 上午11:22:39
	 * @exception/throws
	 * @see
	 * @since
	 * @param model
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/manage/manageUser/sendWebsiteLetter")
	public String sendWebsiteLetter(Model model, String username) {
		model.addAttribute("sendUser", username);
		return MODULE_PATH + "sendWebsiteLetter";
	}

	/**
	 * 验证用户名的唯一性
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/manage/manageUser/usernameUnique")
	@ResponseBody
	public boolean usernameUnique(String username) {
		ManageUser user = new ManageUser();
		user.setUsername(username);
		if (manageUserServiceImpl.queryPage(user, 1, 1, null, null)
				.getDataList().size() > 0) {
			return false;
		}
		return true;
	}
}
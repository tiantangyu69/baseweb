package org.jgenerator.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.Department;
import org.jgenerator.model.ManageUser;
import org.jgenerator.model.entityArray.DepartmentArray;
import org.jgenerator.model.vo.Result;
import org.jgenerator.service.DepartmentService;
import org.jgenerator.service.ManageUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class DepartmentController {
	public static final String MODULE_PATH = "manage/department/";
	@Resource
	private DepartmentService departmentServiceImpl;
	@Resource
	private ManageUserService manageUserServiceImpl;

	@RequestMapping(value = "/manage/department/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/department/query")
	@ResponseBody
	public List<Department> query(Department department, Integer id,
			Integer page, Integer rows, String orderBy, String sortBy) {
		return departmentServiceImpl.getDepartmentTree();
	}

	@RequestMapping(value = "/manage/department/toAdd")
	public String toAdd(Model model) {
		return MODULE_PATH + "add";
	}

	@RequestMapping(value = "/manage/department/add")
	@ResponseBody
	public Result add(Department department) {
		if (null == department.getParentDepartment()) {
			department.setParentDepartment(-1);
		}
		try {
			departmentServiceImpl.save(department);
		} catch (Exception e) {
			return new Result(Result.ERROR, "部门添加失败！");
		}
		return new Result(Result.SUCCESS, "部门添加成功！");
	}

	@RequestMapping(value = "/manage/department/toEdit")
	public String toEdit(Model model, Integer id) {
		Department department = departmentServiceImpl.fetch(id);
		model.addAttribute("department", department);
		return MODULE_PATH + "edit";
	}

	@RequestMapping(value = "/manage/department/edit")
	@ResponseBody
	public Result Result(Department department) {
		try {
			departmentServiceImpl.saveOrUpdate(department);
		} catch (Exception e) {
			return new Result(Result.ERROR, "部门修改失败！");
		}
		return new Result(Result.SUCCESS, "部门修改成功！");
	}

	@RequestMapping(value = "/manage/department/deleteByIds")
	@ResponseBody
	public Result deleteByIds(DepartmentArray array) {
		if (null != array && null != array.getDepartmentArray()) {
			try {
				for (Department entity : array.getDepartmentArray()) {
					Department d = new Department();
					d.setParentDepartment(entity.getId());
					int size = departmentServiceImpl.queryPage(d, 1, 1, null,
							null).getDataList().size();
					if (size > 0) {
						return new Result(2, "[ " + departmentServiceImpl.fetch(entity.getId()).getName() + "] 部门下含有子部门，无法删除！");
					}
					ManageUser user = new ManageUser();
					user.setDepartment(entity.getId());
					if(manageUserServiceImpl.findAll(user).size() > 0){
						return new Result(3, "[ " + departmentServiceImpl.fetch(entity.getId()).getName() + "] 部门下包含人员列表，无法删除！");
					}
					
					departmentServiceImpl.delete(entity.getId());
				}
			} catch (Exception e) {
				return new Result(Result.ERROR, "部门删除失败！");
			}
		}
		return new Result(Result.SUCCESS, "部门删除成功！");
	}

	@RequestMapping(value = "/manage/department/queryCombox")
	@ResponseBody
	public List<Department> queryCombox(Integer id, Department department,
			Integer page, Integer rows, String orderBy, String sortBy) {
		return departmentServiceImpl.getDepartmentTree();
	}

	@RequestMapping(value = "/manage/department/queryCombox2")
	@ResponseBody
	public List<Department> queryCombox2() {
		List<Department> list = new ArrayList<Department>();
		Department defaultDept = new Department();
		defaultDept.setId(-1);
		defaultDept.setText("无上级部门");
		defaultDept.setState("open");
		defaultDept.setIconCls("icon-mini-add");
		list.add(defaultDept);
		for (Department d : departmentServiceImpl.getDepartmentTree()) {
			list.add(d);
		}
		return list;
	}

	@RequestMapping(value = "/manage/department/managerUsers")
	public String managerUsers(Integer department, Model model) {
		model.addAttribute("department", department);
		return MODULE_PATH + "departmentUsers";
	}

	@RequestMapping(value = "/manage/department/queryUsers")
	@ResponseBody
	public Map<String, Object> queryUsers(ManageUser manageUser, Integer page,
			Integer rows, String orderBy, String sortBy, Integer department) {
		if ("输入用户名查询".equals(manageUser.getUsername())) {
			manageUser.setUsername(null);
		}

		ManageUser user = new ManageUser();
		user.setAndLikeUsername(StringUtils
				.trimToNull(manageUser.getUsername()));
		user.setDepartment(department);
		Pager<ManageUser> pager = manageUserServiceImpl.findByDepartmentId(
				department, user, rows, page);
		// Map<String, Object> params = new HashMap<String, Object>();
		// params.put("andLikeUsername", StringUtils.trimToNull(manageUser
		// .getUsername()));
		// params.put("department", department);
		//
		// Pager<ManageUser> pager = manageUserServiceImpl.queryPage(params,
		// page,
		// rows);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", pager.getDataList());
		return result;
	}
}
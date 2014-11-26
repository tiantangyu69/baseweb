package org.jgenerator.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.core.util.page.Pager;
import org.jgenerator.dao.ManageUserDao;
import org.jgenerator.model.Department;
import org.jgenerator.model.ManageUser;
import org.jgenerator.service.DepartmentService;
import org.jgenerator.service.ManageUserService;
import org.springframework.stereotype.Service;

@Service
public class ManageUserServiceImpl extends
		BaseServiceImpl<ManageUser, ManageUserDao> implements ManageUserService {
	@Resource
	private ManageUserDao daoImpl;
	@Resource
	private DepartmentService departmentServiceImpl;

	@Override
	public ManageUserDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(ManageUserDao daoImpl) {
		this.daoImpl = daoImpl;
	}

	@Override
	public Pager<ManageUser> findByDepartmentId(Integer department,
			ManageUser user, Integer pageSize, Integer currentPage) {
		if(null == department){
			department = -1;
		}
		List<String> list = new ArrayList<String>();
		list.add(department.toString());
		recursiveDepartment(list, department);
		return daoImpl.findByDepartmentId(list, pageSize, currentPage, user.toHashMap());
	}

	private List<String> recursiveDepartment(List<String> list2, int parentId) {
		Department d = new Department();
		d.setParentDepartment(parentId);
		Map<String, Object> params = d.toHashMap();
		List<Department> list = departmentServiceImpl.queryPage(params, 1,
				Integer.MAX_VALUE).getDataList();
		for (Department dept : list) {
			list2.add(dept.getId().toString());
			recursiveDepartment(list2, dept.getId());
		}
		return list2;
	}
}
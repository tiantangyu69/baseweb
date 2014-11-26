package org.jgenerator.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.dao.DepartmentDao;
import org.jgenerator.model.Department;
import org.jgenerator.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department, DepartmentDao> implements DepartmentService{
	@Resource
	private DepartmentDao daoImpl;
	
	@Override
	public DepartmentDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(DepartmentDao daoImpl) {
		this.daoImpl = daoImpl;
	}

	@Override
	public List<Department> getDepartmentTree() {
		List<Department> list = new ArrayList<Department>();
		return recursiveDepartment(list, -1);
	}
	
	private List<Department> recursiveDepartment(List<Department> list, int parentId){
		Department d = new Department();
		d.setParentDepartment(parentId);
		Map<String, Object> params = d.toHashMap();
		list = daoImpl.queryPage(params, 1, Integer.MAX_VALUE).getDataList();
		for(Department dept : list){
			dept.setText(dept.getName());
			dept.setState("open");
			dept.setIconCls("icon-mini-add");
			dept.setChildren(recursiveDepartment(list, dept.getId()));
		}
		return list;
	}
}
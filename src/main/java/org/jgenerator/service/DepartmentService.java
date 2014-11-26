package org.jgenerator.service;
import java.util.List;

import org.jgenerator.core.service.BaseService;
import org.jgenerator.dao.DepartmentDao;
import org.jgenerator.model.Department;

public interface DepartmentService extends BaseService<Department, DepartmentDao>{
	public List<Department> getDepartmentTree();
}
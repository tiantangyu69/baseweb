package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.DepartmentDao;
import org.jgenerator.model.Department;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl extends BaseDaoImpl<Department, Integer> implements DepartmentDao{
}
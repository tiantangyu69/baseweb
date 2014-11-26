package org.jgenerator.dao;
import java.util.List;
import java.util.Map;

import org.jgenerator.core.dao.BaseDao;
import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.ManageUser;

public interface ManageUserDao extends BaseDao<ManageUser, Integer>{
	Pager<ManageUser> findByDepartmentId(List<String> departments, Integer pageSize, Integer currentPage, Map<String, Object> params);
}
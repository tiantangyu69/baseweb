package org.jgenerator.service;

import org.jgenerator.core.service.BaseService;
import org.jgenerator.core.util.page.Pager;
import org.jgenerator.dao.ManageUserDao;
import org.jgenerator.model.ManageUser;

public interface ManageUserService extends
		BaseService<ManageUser, ManageUserDao> {
	Pager<ManageUser> findByDepartmentId(Integer department,
			ManageUser user, Integer pageSize, Integer currentPage);
}
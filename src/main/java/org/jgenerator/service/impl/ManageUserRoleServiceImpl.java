package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.ManageUserRoleService;
import org.jgenerator.dao.ManageUserRoleDao;
import org.jgenerator.model.ManageUserRole;

@Service
public class ManageUserRoleServiceImpl extends BaseServiceImpl<ManageUserRole, ManageUserRoleDao> implements ManageUserRoleService{
	@Resource
	private ManageUserRoleDao daoImpl;
	
	@Override
	public ManageUserRoleDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(ManageUserRoleDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
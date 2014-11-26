package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.ManageRoleService;
import org.jgenerator.dao.ManageRoleDao;
import org.jgenerator.model.ManageRole;

@Service
public class ManageRoleServiceImpl extends BaseServiceImpl<ManageRole, ManageRoleDao> implements ManageRoleService{
	@Resource
	private ManageRoleDao daoImpl;
	
	@Override
	public ManageRoleDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(ManageRoleDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
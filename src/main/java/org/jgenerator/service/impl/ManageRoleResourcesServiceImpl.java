package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.ManageRoleResourcesService;
import org.jgenerator.dao.ManageRoleResourcesDao;
import org.jgenerator.model.ManageRoleResources;

@Service
public class ManageRoleResourcesServiceImpl extends BaseServiceImpl<ManageRoleResources, ManageRoleResourcesDao> implements ManageRoleResourcesService{
	@Resource
	private ManageRoleResourcesDao daoImpl;
	
	@Override
	public ManageRoleResourcesDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(ManageRoleResourcesDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
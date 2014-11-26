package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.PortalUserTypeService;
import org.jgenerator.dao.PortalUserTypeDao;
import org.jgenerator.model.PortalUserType;

@Service
public class PortalUserTypeServiceImpl extends BaseServiceImpl<PortalUserType, PortalUserTypeDao> implements PortalUserTypeService{
	@Resource
	private PortalUserTypeDao daoImpl;
	
	@Override
	public PortalUserTypeDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(PortalUserTypeDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
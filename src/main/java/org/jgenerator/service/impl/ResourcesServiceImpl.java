package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.ResourcesService;
import org.jgenerator.dao.ResourcesDao;
import org.jgenerator.model.Resources;

@Service
public class ResourcesServiceImpl extends BaseServiceImpl<Resources, ResourcesDao> implements ResourcesService{
	@Resource
	private ResourcesDao daoImpl;
	
	@Override
	public ResourcesDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(ResourcesDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
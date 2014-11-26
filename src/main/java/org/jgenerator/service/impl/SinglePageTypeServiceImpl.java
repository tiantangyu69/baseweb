package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.SinglePageTypeService;
import org.jgenerator.dao.SinglePageTypeDao;
import org.jgenerator.model.SinglePageType;

@Service
public class SinglePageTypeServiceImpl extends BaseServiceImpl<SinglePageType, SinglePageTypeDao> implements SinglePageTypeService{
	@Resource
	private SinglePageTypeDao daoImpl;
	
	@Override
	public SinglePageTypeDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(SinglePageTypeDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
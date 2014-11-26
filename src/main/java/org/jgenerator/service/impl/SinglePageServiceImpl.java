package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.SinglePageService;
import org.jgenerator.dao.SinglePageDao;
import org.jgenerator.model.SinglePage;

@Service
public class SinglePageServiceImpl extends BaseServiceImpl<SinglePage, SinglePageDao> implements SinglePageService{
	@Resource
	private SinglePageDao daoImpl;
	
	@Override
	public SinglePageDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(SinglePageDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
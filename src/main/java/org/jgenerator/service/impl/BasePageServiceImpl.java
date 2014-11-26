package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.BasePageService;
import org.jgenerator.dao.BasePageDao;
import org.jgenerator.model.BasePage;

@Service
public class BasePageServiceImpl extends BaseServiceImpl<BasePage, BasePageDao> implements BasePageService{
	@Resource
	private BasePageDao daoImpl;
	
	@Override
	public BasePageDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(BasePageDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
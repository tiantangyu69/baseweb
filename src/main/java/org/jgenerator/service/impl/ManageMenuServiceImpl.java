package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.ManageMenuService;
import org.jgenerator.dao.ManageMenuDao;
import org.jgenerator.model.ManageMenu;

@Service
public class ManageMenuServiceImpl extends BaseServiceImpl<ManageMenu, ManageMenuDao> implements ManageMenuService{
	@Resource
	private ManageMenuDao daoImpl;
	
	@Override
	public ManageMenuDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(ManageMenuDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
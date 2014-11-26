package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.SystemLogConfigService;
import org.jgenerator.dao.SystemLogConfigDao;
import org.jgenerator.model.SystemLogConfig;

@Service
public class SystemLogConfigServiceImpl extends BaseServiceImpl<SystemLogConfig, SystemLogConfigDao> implements SystemLogConfigService{
	@Resource
	private SystemLogConfigDao daoImpl;
	
	@Override
	public SystemLogConfigDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(SystemLogConfigDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
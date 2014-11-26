package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.SystemLogService;
import org.jgenerator.dao.SystemLogDao;
import org.jgenerator.model.SystemLog;

@Service
public class SystemLogServiceImpl extends BaseServiceImpl<SystemLog, SystemLogDao> implements SystemLogService{
	@Resource
	private SystemLogDao daoImpl;
	
	@Override
	public SystemLogDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(SystemLogDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
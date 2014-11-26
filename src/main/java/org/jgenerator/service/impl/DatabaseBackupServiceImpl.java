package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.DatabaseBackupService;
import org.jgenerator.dao.DatabaseBackupDao;
import org.jgenerator.model.DatabaseBackup;

@Service
public class DatabaseBackupServiceImpl extends BaseServiceImpl<DatabaseBackup, DatabaseBackupDao> implements DatabaseBackupService{
	@Resource
	private DatabaseBackupDao daoImpl;
	
	@Override
	public DatabaseBackupDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(DatabaseBackupDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
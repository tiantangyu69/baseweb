package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.DatabaseBackupDao;
import org.jgenerator.model.DatabaseBackup;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseBackupDaoImpl extends BaseDaoImpl<DatabaseBackup, Integer> implements DatabaseBackupDao{
}
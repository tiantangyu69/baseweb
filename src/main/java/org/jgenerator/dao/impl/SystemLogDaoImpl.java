package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.SystemLogDao;
import org.jgenerator.model.SystemLog;
import org.springframework.stereotype.Repository;

@Repository
public class SystemLogDaoImpl extends BaseDaoImpl<SystemLog, Integer> implements SystemLogDao{
}
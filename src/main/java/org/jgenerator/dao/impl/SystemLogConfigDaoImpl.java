package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.SystemLogConfigDao;
import org.jgenerator.model.SystemLogConfig;
import org.springframework.stereotype.Repository;

@Repository
public class SystemLogConfigDaoImpl extends BaseDaoImpl<SystemLogConfig, Integer> implements SystemLogConfigDao{
}
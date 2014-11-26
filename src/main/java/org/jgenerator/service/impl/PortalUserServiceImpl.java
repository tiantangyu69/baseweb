package org.jgenerator.service.impl;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.model.GroupCount;
import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.PortalUserService;
import org.jgenerator.dao.PortalUserDao;
import org.jgenerator.model.PortalUser;

@Service
public class PortalUserServiceImpl extends BaseServiceImpl<PortalUser, PortalUserDao> implements PortalUserService{
	@Resource
	private PortalUserDao daoImpl;
	
	@Override
	public PortalUserDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(PortalUserDao daoImpl) {
		this.daoImpl = daoImpl;
	}

	@Override
	public List<GroupCount> getCount(String groupBy) {
		return daoImpl.getCount(groupBy);
	}
	
}
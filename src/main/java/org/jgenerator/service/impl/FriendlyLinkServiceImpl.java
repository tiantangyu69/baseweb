package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.FriendlyLinkService;
import org.jgenerator.dao.FriendlyLinkDao;
import org.jgenerator.model.FriendlyLink;

@Service
public class FriendlyLinkServiceImpl extends BaseServiceImpl<FriendlyLink, FriendlyLinkDao> implements FriendlyLinkService{
	@Resource
	private FriendlyLinkDao daoImpl;
	
	@Override
	public FriendlyLinkDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(FriendlyLinkDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.LeaveMessageService;
import org.jgenerator.dao.LeaveMessageDao;
import org.jgenerator.model.LeaveMessage;

@Service
public class LeaveMessageServiceImpl extends BaseServiceImpl<LeaveMessage, LeaveMessageDao> implements LeaveMessageService{
	@Resource
	private LeaveMessageDao daoImpl;
	
	@Override
	public LeaveMessageDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(LeaveMessageDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
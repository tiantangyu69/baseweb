package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.LeaveMessageDao;
import org.jgenerator.model.LeaveMessage;
import org.springframework.stereotype.Repository;

@Repository
public class LeaveMessageDaoImpl extends BaseDaoImpl<LeaveMessage, Integer> implements LeaveMessageDao{
}
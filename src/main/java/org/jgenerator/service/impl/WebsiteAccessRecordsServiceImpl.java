package org.jgenerator.service.impl;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.model.GroupCount;
import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.WebsiteAccessRecordsService;
import org.jgenerator.dao.WebsiteAccessRecordsDao;
import org.jgenerator.model.WebsiteAccessRecords;

@Service
public class WebsiteAccessRecordsServiceImpl extends BaseServiceImpl<WebsiteAccessRecords, WebsiteAccessRecordsDao> implements WebsiteAccessRecordsService{
	@Resource
	private WebsiteAccessRecordsDao daoImpl;
	
	@Override
	public WebsiteAccessRecordsDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(WebsiteAccessRecordsDao daoImpl) {
		this.daoImpl = daoImpl;
	}

	@Override
	public List<GroupCount> getCount(String groupBy) {
		// TODO Auto-generated method stub
		return daoImpl.getCount(groupBy);
	}
}
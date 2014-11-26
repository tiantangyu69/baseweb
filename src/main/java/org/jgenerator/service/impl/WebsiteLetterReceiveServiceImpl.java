package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.WebsiteLetterReceiveService;
import org.jgenerator.dao.WebsiteLetterReceiveDao;
import org.jgenerator.model.WebsiteLetterReceive;

@Service
public class WebsiteLetterReceiveServiceImpl extends BaseServiceImpl<WebsiteLetterReceive, WebsiteLetterReceiveDao> implements WebsiteLetterReceiveService{
	@Resource
	private WebsiteLetterReceiveDao daoImpl;
	
	@Override
	public WebsiteLetterReceiveDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(WebsiteLetterReceiveDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
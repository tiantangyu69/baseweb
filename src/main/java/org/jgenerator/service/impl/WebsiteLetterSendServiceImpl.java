package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.WebsiteLetterSendService;
import org.jgenerator.dao.WebsiteLetterSendDao;
import org.jgenerator.model.WebsiteLetterSend;

@Service
public class WebsiteLetterSendServiceImpl extends BaseServiceImpl<WebsiteLetterSend, WebsiteLetterSendDao> implements WebsiteLetterSendService{
	@Resource
	private WebsiteLetterSendDao daoImpl;
	
	@Override
	public WebsiteLetterSendDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(WebsiteLetterSendDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
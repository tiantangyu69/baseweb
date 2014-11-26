package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.WebsiteLogoService;
import org.jgenerator.dao.WebsiteLogoDao;
import org.jgenerator.model.WebsiteLogo;

@Service
public class WebsiteLogoServiceImpl extends BaseServiceImpl<WebsiteLogo, WebsiteLogoDao> implements WebsiteLogoService{
	@Resource
	private WebsiteLogoDao daoImpl;
	
	@Override
	public WebsiteLogoDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(WebsiteLogoDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
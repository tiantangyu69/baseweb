package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.NewsService;
import org.jgenerator.dao.NewsDao;
import org.jgenerator.model.News;

@Service
public class NewsServiceImpl extends BaseServiceImpl<News, NewsDao> implements NewsService{
	@Resource
	private NewsDao daoImpl;
	
	@Override
	public NewsDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(NewsDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.CityService;
import org.jgenerator.dao.CityDao;
import org.jgenerator.model.City;

@Service
public class CityServiceImpl extends BaseServiceImpl<City, CityDao> implements CityService{
	@Resource
	private CityDao daoImpl;
	
	@Override
	public CityDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(CityDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
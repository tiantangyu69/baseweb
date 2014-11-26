package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.ProvinceService;
import org.jgenerator.dao.ProvinceDao;
import org.jgenerator.model.Province;

@Service
public class ProvinceServiceImpl extends BaseServiceImpl<Province, ProvinceDao> implements ProvinceService{
	@Resource
	private ProvinceDao daoImpl;
	
	@Override
	public ProvinceDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(ProvinceDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
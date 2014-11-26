package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.DictionaryTypeService;
import org.jgenerator.dao.DictionaryTypeDao;
import org.jgenerator.model.DictionaryType;

@Service
public class DictionaryTypeServiceImpl extends BaseServiceImpl<DictionaryType, DictionaryTypeDao> implements DictionaryTypeService{
	@Resource
	private DictionaryTypeDao daoImpl;
	
	@Override
	public DictionaryTypeDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(DictionaryTypeDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
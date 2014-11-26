package org.jgenerator.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.DictionaryValueService;
import org.jgenerator.dao.DictionaryValueDao;
import org.jgenerator.model.DictionaryValue;

@Service
public class DictionaryValueServiceImpl extends BaseServiceImpl<DictionaryValue, DictionaryValueDao> implements DictionaryValueService{
	@Resource
	private DictionaryValueDao daoImpl;
	
	@Override
	public DictionaryValueDao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(DictionaryValueDao daoImpl) {
		this.daoImpl = daoImpl;
	}
}
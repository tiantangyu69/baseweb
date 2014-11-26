package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.DictionaryValueDao;
import org.jgenerator.model.DictionaryValue;
import org.springframework.stereotype.Repository;

@Repository
public class DictionaryValueDaoImpl extends BaseDaoImpl<DictionaryValue, Integer> implements DictionaryValueDao{
}
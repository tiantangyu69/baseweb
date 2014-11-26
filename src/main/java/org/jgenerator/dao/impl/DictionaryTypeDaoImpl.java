package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.DictionaryTypeDao;
import org.jgenerator.model.DictionaryType;
import org.springframework.stereotype.Repository;

@Repository
public class DictionaryTypeDaoImpl extends BaseDaoImpl<DictionaryType, Integer> implements DictionaryTypeDao{
}
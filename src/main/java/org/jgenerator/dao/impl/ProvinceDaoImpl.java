package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.ProvinceDao;
import org.jgenerator.model.Province;
import org.springframework.stereotype.Repository;

@Repository
public class ProvinceDaoImpl extends BaseDaoImpl<Province, Integer> implements ProvinceDao{
}
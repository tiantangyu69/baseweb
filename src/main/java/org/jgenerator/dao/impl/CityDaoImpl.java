package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.CityDao;
import org.jgenerator.model.City;
import org.springframework.stereotype.Repository;

@Repository
public class CityDaoImpl extends BaseDaoImpl<City, Integer> implements CityDao{
}
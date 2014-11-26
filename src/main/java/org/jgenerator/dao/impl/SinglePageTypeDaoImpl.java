package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.SinglePageTypeDao;
import org.jgenerator.model.SinglePageType;
import org.springframework.stereotype.Repository;

@Repository
public class SinglePageTypeDaoImpl extends BaseDaoImpl<SinglePageType, Integer> implements SinglePageTypeDao{
}
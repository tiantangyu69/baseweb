package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.SinglePageDao;
import org.jgenerator.model.SinglePage;
import org.springframework.stereotype.Repository;

@Repository
public class SinglePageDaoImpl extends BaseDaoImpl<SinglePage, Integer> implements SinglePageDao{
}
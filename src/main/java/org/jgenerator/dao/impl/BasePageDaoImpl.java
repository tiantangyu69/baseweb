package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.BasePageDao;
import org.jgenerator.model.BasePage;
import org.springframework.stereotype.Repository;

@Repository
public class BasePageDaoImpl extends BaseDaoImpl<BasePage, Integer> implements BasePageDao{
}
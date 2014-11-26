package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.NewsDao;
import org.jgenerator.model.News;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDaoImpl extends BaseDaoImpl<News, Integer> implements NewsDao{
}
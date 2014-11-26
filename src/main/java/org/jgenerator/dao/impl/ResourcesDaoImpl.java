package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.ResourcesDao;
import org.jgenerator.model.Resources;
import org.springframework.stereotype.Repository;

@Repository
public class ResourcesDaoImpl extends BaseDaoImpl<Resources, Integer> implements ResourcesDao{
}
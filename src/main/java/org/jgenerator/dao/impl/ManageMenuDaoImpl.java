package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.ManageMenuDao;
import org.jgenerator.model.ManageMenu;
import org.springframework.stereotype.Repository;

@Repository
public class ManageMenuDaoImpl extends BaseDaoImpl<ManageMenu, Integer> implements ManageMenuDao{
}
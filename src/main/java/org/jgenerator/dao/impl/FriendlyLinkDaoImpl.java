package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.FriendlyLinkDao;
import org.jgenerator.model.FriendlyLink;
import org.springframework.stereotype.Repository;

@Repository
public class FriendlyLinkDaoImpl extends BaseDaoImpl<FriendlyLink, Integer> implements FriendlyLinkDao{
}
package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.PortalUserTypeDao;
import org.jgenerator.model.PortalUserType;
import org.springframework.stereotype.Repository;

@Repository
public class PortalUserTypeDaoImpl extends BaseDaoImpl<PortalUserType, Integer> implements PortalUserTypeDao{
}
package org.jgenerator.dao;
import java.util.List;

import org.jgenerator.core.dao.BaseDao;
import org.jgenerator.core.model.GroupCount;
import org.jgenerator.model.PortalUser;

public interface PortalUserDao extends BaseDao<PortalUser, Integer>{
	List<GroupCount> getCount(String groupBy);
}
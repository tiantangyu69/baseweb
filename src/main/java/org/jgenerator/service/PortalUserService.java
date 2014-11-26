package org.jgenerator.service;
import java.util.List;

import org.jgenerator.core.model.GroupCount;
import org.jgenerator.core.service.BaseService;
import org.jgenerator.model.PortalUser;
import org.jgenerator.dao.PortalUserDao;

public interface PortalUserService extends BaseService<PortalUser, PortalUserDao>{
	List<GroupCount> getCount(String groupBy);
}
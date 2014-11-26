package org.jgenerator.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.core.model.GroupCount;
import org.jgenerator.dao.PortalUserDao;
import org.jgenerator.model.PortalUser;
import org.springframework.stereotype.Repository;

@Repository
public class PortalUserDaoImpl extends BaseDaoImpl<PortalUser, Integer>
		implements PortalUserDao {
	public List<GroupCount> getCount(String groupBy) {
		Map<Object, Object> params = new HashMap<Object, Object>();
		params.put("groupBy", groupBy);
		return getSqlSession().selectList(
				getEntityClass().getName() + "Mapper.groupCount", params);
	}
}
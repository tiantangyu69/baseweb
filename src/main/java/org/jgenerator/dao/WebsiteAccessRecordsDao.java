package org.jgenerator.dao;
import java.util.List;

import org.jgenerator.core.dao.BaseDao;
import org.jgenerator.core.model.GroupCount;
import org.jgenerator.model.WebsiteAccessRecords;

public interface WebsiteAccessRecordsDao extends BaseDao<WebsiteAccessRecords, Integer>{
	List<GroupCount> getCount(String groupBy);
}
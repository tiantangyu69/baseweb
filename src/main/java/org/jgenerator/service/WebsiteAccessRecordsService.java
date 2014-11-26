package org.jgenerator.service;
import java.util.List;

import org.jgenerator.core.model.GroupCount;
import org.jgenerator.core.service.BaseService;
import org.jgenerator.model.WebsiteAccessRecords;
import org.jgenerator.dao.WebsiteAccessRecordsDao;

public interface WebsiteAccessRecordsService extends BaseService<WebsiteAccessRecords, WebsiteAccessRecordsDao>{
	List<GroupCount> getCount(String groupBy);
}
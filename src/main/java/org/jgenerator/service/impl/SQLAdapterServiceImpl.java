/*******************************************************
 * @author LIZHITAO
 * @date 2013-10-23 下午02:38:13
 * @name SQLAdapterServiceImpl.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.service.impl;

import javax.annotation.Resource;

import org.jgenerator.core.model.SQLAdapter;
import org.jgenerator.dao.SQLAdapterDao;
import org.jgenerator.service.SQLAdapterService;
import org.springframework.stereotype.Service;

/**
 * @author LIZHITAO
 * 
 */
@Service
public class SQLAdapterServiceImpl implements SQLAdapterService {
	@Resource
	private SQLAdapterDao sqlAdapterDaoImpl;

	/**
	 * @param
	 * @name executeSQL
	 * @active
	 * @state
	 * @type SQLAdapterServiceImpl
	 * @time 下午02:38:13
	 * @see org.jgenerator.service.SQLAdapterService#executeSQL(org.jgenerator.core.model.SQLAdapter)
	 */
	@Override
	public void executeSQL(SQLAdapter adapter) {
		sqlAdapterDaoImpl.executeSQL(adapter);
	}

}

/*******************************************************
 * @author LIZHITAO
 * @date 2013-10-23 下午02:32:34
 * @name SQLAdapterDaoImpl.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.jgenerator.core.model.SQLAdapter;
import org.jgenerator.dao.SQLAdapterDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author LIZHITAO
 * 
 */
@Repository
public class SQLAdapterDaoImpl extends SqlSessionDaoSupport implements
		SQLAdapterDao {
	@Resource(name = "sqlSessionFactory")
	public void setSuperSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	/**
	 * @param
	 * @name executeSQL
	 * @active
	 * @state
	 * @type SQLAdapterDaoImpl
	 * @time 下午02:32:34
	 * @see org.jgenerator.dao.SQLAdapterDao#executeSQL(org.jgenerator.core.model.SQLAdapter)
	 */
	@Override
	public void executeSQL(SQLAdapter adapter) {
		this.getSqlSession().update("org.jgenerator.core.model.SQLAdapterMapper.executeSQL", adapter);
	}

}

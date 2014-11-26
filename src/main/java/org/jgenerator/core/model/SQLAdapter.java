/*******************************************************
 * @author LIZHITAO
 * @date 2013-10-23 下午02:24:27
 * @name SQLAdapter.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.core.model;

/**
 * @author LIZHITAO sql适配器，用于mybatis直接执行sql语句
 */
public class SQLAdapter {
	private String sql;
	
	public SQLAdapter(){}

	public SQLAdapter(String sql) {
		this.sql = sql;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
}

/*******************************************************
 * @author LIZHITAO
 * @date 2013-8-27 上午10:24:32
 * @name JDBCProperty.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.core.model;

/**
 * @author LIZHITAO jdbc属性文件实体
 * 
 */
public class JDBCProperty {
	public static final String DRIVER = "jdbc.driverClassName";
	public static final String URL = "jdbc.url";
	public static final String USERNAME = "jdbc.username";
	public static final String PASSWORD = "jdbc.password";
	public static final String MAXACTIVE = "jdbc.maxActive";
	public static final String MAXIDLE = "jdbc.maxIdle";
	public static final String MINIDLE = "jdbc.minIdle";
	public static final String INITIALSIZE = "jdbc.initialSize";
	public static final String MAXWAIT = "jdbc.maxWait";

	private String driver;
	private String url;
	private String username;
	private String password;
	private String maxActive;
	private String maxIdle;
	private String minIdle;
	private String initialSize;
	private String maxWait;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(String maxActive) {
		this.maxActive = maxActive;
	}

	public String getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(String maxIdle) {
		this.maxIdle = maxIdle;
	}

	public String getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(String minIdle) {
		this.minIdle = minIdle;
	}

	public String getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(String initialSize) {
		this.initialSize = initialSize;
	}

	public String getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(String maxWait) {
		this.maxWait = maxWait;
	}
}

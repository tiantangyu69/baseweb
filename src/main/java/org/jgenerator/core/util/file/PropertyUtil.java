/*******************************************************
 * @author LIZHITAO
 * @date 2013-8-27 上午10:16:43
 * @name PropertyUtil.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.core.util.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.jgenerator.core.model.JDBCProperty;
import org.sagacity.util.ClassPath;

/**
 * @author LIZHITAO 属性文件读取工具类
 * 
 */
public class PropertyUtil {
	/**
	 * @name loadProperty
	 * @active 根据文件名称加载属性文件
	 * @state
	 * @type Properties
	 * @time 上午10:39:06
	 * @exception/throws
	 * @see
	 * @since
	 * @param fileName
	 *            文件名称
	 * @return
	 */
	public Properties loadProperty(String fileName) {
		InputStream in;
		try {
			in = new BufferedInputStream(new FileInputStream(fileName));
			Properties p = new Properties();
			p.load(in);
			in.close();
			return p;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return null;
	}

	/**
	 * @name getJDBCProperty
	 * @active 获得jdbc属性文件项目配置信息
	 * @state
	 * @type JDBCProperty
	 * @time 上午10:39:35
	 * @exception/throws
	 * @see
	 * @since
	 * @return
	 */
	public JDBCProperty getJDBCProperty() {
		PropertyUtil u = new PropertyUtil();
		ClassPath cp = new ClassPath();
		Properties p = u.loadProperty(cp.getClassPath() + File.separator
				+ "jdbc.properties");
		JDBCProperty jdbc = new JDBCProperty();
		if (null != p) {
			jdbc.setDriver(p.getProperty("jdbc.driverClassName"));
			jdbc.setUrl(p.getProperty("jdbc.url"));
			jdbc.setUsername(p.getProperty("jdbc.username"));
			jdbc.setPassword(p.getProperty("jdbc.password"));
			jdbc.setMaxActive(p.getProperty("jdbc.maxActive"));
			jdbc.setMaxIdle(p.getProperty("jdbc.maxIdle"));
			jdbc.setMinIdle(p.getProperty("jdbc.minIdle"));
			jdbc.setInitialSize(p.getProperty("jdbc.initialSize"));
			jdbc.setMaxWait(p.getProperty("jdbc.maxWait"));
		}
		return jdbc;
	}
	
	public void setJDBCProperty(String settings){
		PropertyUtil u = new PropertyUtil();
		ClassPath cp = new ClassPath();
		Properties p = u.loadProperty(cp.getClassPath() + File.separator
				+ "jdbc.properties");
		String[] setting =settings.split(",");
		for(String s : setting){
			String[] p2 = s.split("\\$");
			p.setProperty(p2[0], p2[1]);
		}
		FileOutputStream out;
		try {
			out = FileUtils.openOutputStream(new File(cp.getClassPath() + File.separator
					+ "jdbc.properties"));
	        p.store(out,null);
	        out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

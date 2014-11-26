/*******************************************************
 * @author LIZHITAO
 * @date 2014-1-7 下午04:36:04
 * @name BackupData.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.core.util.database;

import org.jgenerator.core.util.file.PropertyGridUitl;
import org.sagacity.util.bean.CommandUtil;
import org.springframework.stereotype.Component;

/**
 * @author LIZHITAO
 * 
 */
@Component
public class BackupData {
	/**
	 * 备份数据库
	 * @param 
	 * @name backupData
	 * @active
	 * @state
	 * @type boolean
	 * @time 下午02:35:06
	 * @exception/throws
	 * @see
	 * @since
	 * @param absolutePath
	 * @return
	 */
	public boolean backupData(String absolutePath, String tomcatPath) {
		String username = PropertyGridUitl.getJDBCPropertyGrid().get(2).getValue();
		String password = PropertyGridUitl.getJDBCPropertyGrid().get(3).getValue();
		// 数据库备份命令
		String command = "mysqldump -u " + username + " -p" + password + " jgenerator > " + absolutePath;
		CommandUtil.execute(command);// 执行命令
		return true;
	}
	
	/**
	 * 还原数据库
	 * @param 
	 * @name restoreData
	 * @active
	 * @state
	 * @type boolean
	 * @time 下午02:34:54
	 * @exception/throws
	 * @see
	 * @since
	 * @param absolutePath
	 * @return
	 */
	public boolean restoreData(String absolutePath){
		String username = PropertyGridUitl.getJDBCPropertyGrid().get(2).getValue();
		String password = PropertyGridUitl.getJDBCPropertyGrid().get(3).getValue();
		// 数据库备份命令
		String command = "mysql -u " + username + " -p" + password + " jgenerator < " + absolutePath;
		CommandUtil.execute(command);// 执行命令
		return true;
	}
}

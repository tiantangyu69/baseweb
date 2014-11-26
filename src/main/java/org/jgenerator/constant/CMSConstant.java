/*******************************************************
 * @author LIZHITAO
 * @date 2013-8-30 上午09:13:32
 * @name Constant.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.constant;

/**
 * @author LIZHITAO 内容状态常量接口
 * 
 */
public interface CMSConstant {

	/**
	 * 内容发布状态 0表示未发布 1表示已发布
	 */
	int UNDEPLOY = 0;
	int DEPLOYED = 1;
	
	/**
	 * 内容查看状态 0 未查看 1 已查看
	 */
	int NOT_TO_SEE = 0;
	int HAVE_SEE = 1;
}

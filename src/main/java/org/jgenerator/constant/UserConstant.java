/*******************************************************
 * @author LIZHITAO
 * @date 2013-8-30 上午09:13:32
 * @name Constant.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.constant;

/**
 * @author LIZHITAO 用户状态常量接口
 * 
 */
public interface UserConstant {
	/**
	 * 用户级别，普通用户只能看到自己提交的数据，管理员可以看到所有的数据
	 */
	int COMMON_USER = 0; // 普通用户
	int ADMIN_USER = 1; // 管理员用户

	/**
	 * 用户状态 0 表示用户已停用,1 表示用户启用
	 */
	int USER_DISABLE = 0;
	int USER_ENABLE = 1;
}

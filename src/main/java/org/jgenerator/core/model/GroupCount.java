/*******************************************************
 * @author 李智涛
 * @date 2013-10-21 下午03:11:26
 * @name GroupCount.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.core.model;

import java.io.Serializable;

/**
 * @author 李智涛 统计类
 */
public class GroupCount implements Serializable{
	/**
	 * @type long
	 * @field serialVersionUID
	 * @state 
	 */
	private static final long serialVersionUID = 205391080329541643L;
	private String groupCondition;
	private Integer countNumber;

	public String getGroupCondition() {
		return groupCondition;
	}

	public void setGroupCondition(String groupCondition) {
		this.groupCondition = groupCondition;
	}

	public Integer getCountNumber() {
		return countNumber;
	}

	public void setCountNumber(Integer countNumber) {
		this.countNumber = countNumber;
	}
}

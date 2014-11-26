/*******************************************************
 * @author LIZHITAO
 * @date 2013-8-27 上午10:52:02
 * @name PropertyGrid.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.core.model;

/**
 * @author LIZHITAO 属性表格基类
 * 
 */
public interface PropertyGridEditor {
	String TEXT = "text";
	String NUMBERBOX = "numberbox";
	String DATEBOX = "datebox";
	String EMAIL =" {\"type\":\"validatebox\", \"options\":{\"validType\":\"email\"}";
	String CHECKBOX = "{\"type\":\"checkbox\",\"options\":{\"on\":是,\"off\":否}";
}

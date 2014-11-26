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
public class PropertyGrid {
	/**
	 * 属性名
	 */
	private String name;
	/**
	 * 属性值
	 */
	private String value;
	/**
	 * 属性组
	 */
	private String group;
	/**
	 * 属性编辑方式
	 */
	private String editor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}
}

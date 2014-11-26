/**
 * 
 */
package org.jgenerator.core.model;

import java.util.List;

/**
 * @author LIZHITAO easyui tree 对象
 * 
 */
public class EasyuiTree {
	private Integer id;
	private String text;
	private String state = "open";
	private List<EasyuiTree> children;
	private EasyuiTreeAttributes attributes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<EasyuiTree> getChildren() {
		return children;
	}

	public void setChildren(List<EasyuiTree> children) {
		this.children = children;
	}

	public EasyuiTreeAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(EasyuiTreeAttributes attributes) {
		this.attributes = attributes;
	}
}

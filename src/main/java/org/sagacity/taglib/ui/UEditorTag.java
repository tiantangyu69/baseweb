/**
 * 
 */
package org.sagacity.taglib.ui;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

/**
 * @author LIZHITAO 编辑器控件
 */
public class UEditorTag extends SimpleTagSupport {
	private static final long serialVersionUID = 1L;
	private String id;
	private String style;
	private String cssClass;
	private String name;
	private String readonly;
	private String value;
	private boolean required = false;

	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer sb = new StringBuffer();
		if (required) {// 是否必填
			sb.append("<textarea cols=\"2\" rows=\"2\" data-options=\"required:true\" class=\"easyui-validatebox "
							+ StringUtils.trimToEmpty(getCssClass()) + "\"");
		} else {
			sb.append("<textarea cols=\"2\" rows=\"2\" class=\""
					+ StringUtils.trimToEmpty(getCssClass()) + "\"");
		}
		if (StringUtils.isNotBlank(getId())) {
			sb.append(" id=\"" + getId() + "\"");
		}
		if (StringUtils.isNotBlank(getReadonly())) {
			sb.append(" readonly=\"" + getReadonly() + "\"");
		}
		if (StringUtils.isNotBlank(getName())) {
			sb.append(" name=\"" + getName() + "\"");
		}
		if (StringUtils.isNotBlank(getStyle())) {
			sb.append(" style=\"" + getStyle() + "\"");
		}
		sb.append(">" + StringUtils.trimToEmpty(getValue()) + "</textarea>");
		if (StringUtils.isNotBlank(getId())) {
			sb.append("<script type=\"text/javascript\">$(function(){var " + getId()
					+ "Editor = new UE.ui.Editor(); " + getId()
					+ "Editor.render('" + getId() + "');});</script>");
		}
		getJspContext().getOut().write(sb.toString());
		super.doTag();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getReadonly() {
		return readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
}

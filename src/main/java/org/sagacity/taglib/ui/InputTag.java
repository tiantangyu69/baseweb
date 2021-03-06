/**
 * 
 */
package org.sagacity.taglib.ui;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

/**
 * @author LIZHITAO 文本输入框控件
 */
public class InputTag extends SimpleTagSupport {
	private static final long serialVersionUID = 1L;
	private String id;
	private String style;
	private String cssClass;
	private String name;
	private String readonly;
	private String value;
	private boolean required = false;
	private String validType;

	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer sb = new StringBuffer();
		sb.append("<input class=\"easyui-validatebox " + StringUtils.trimToEmpty(getCssClass()) + "\" type=\"text\"");
		if (required) {// 是否必填
			sb.append(" required=\"true\"");
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
		if (StringUtils.isNotBlank(getValue())) {
			sb.append(" value=\"" + getValue() + "\"");
		}
		if (StringUtils.isNotBlank(getValidType())) {
			sb.append(" validType=\"" + getValidType() + "\"");
		}
		sb.append("/>");
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

	public String getValidType() {
		return validType;
	}

	public void setValidType(String validType) {
		this.validType = validType;
	}
}

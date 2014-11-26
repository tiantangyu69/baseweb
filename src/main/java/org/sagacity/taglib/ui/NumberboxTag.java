/**
 * 
 */
package org.sagacity.taglib.ui;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

/**
 * @author LIZHITAO 数字文本输入框控件
 */
public class NumberboxTag extends SimpleTagSupport {
	private static final long serialVersionUID = 1L;
	private String id;
	private String style;
	private String cssClass;
	private String name;
	private String readonly;
	private String value;
	private boolean required = false;
	private Integer maxLength;

	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer sb = new StringBuffer();
		sb.append("<input class=\"easyui-numberbox " + StringUtils.trimToEmpty(getCssClass()) + "\" type=\"text\"");
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
		if (null != getMaxLength()) {
			sb.append(" maxLength=\"" + getMaxLength() + "\"");
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

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}
}

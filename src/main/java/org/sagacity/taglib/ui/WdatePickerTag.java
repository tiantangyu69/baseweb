/**
 * 
 */
package org.sagacity.taglib.ui;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;
import org.sagacity.util.datetime.DateTimeUtil;

/**
 * @author LIZHITAO 日历控件标签
 */
public class WdatePickerTag extends SimpleTagSupport {
	private static final long serialVersionUID = 1L;
	private String id;
	private String style;
	private String cssClass;
	private String name;
	private String params;
	private String readonly;
	private String value;
	private Boolean defaultTime = false;
	private boolean required = false;

	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer sb = new StringBuffer();
		if (defaultTime) {
			setValue(DateTimeUtil.getCurrentDate());
		}
		if (required) {// 是否必填
			sb.append("<input type=\"text\" data-options=\"required:true\" class=\"Wdate easyui-validatebox "
					+ StringUtils.trimToEmpty(getCssClass()) + "\"");
		} else {
			sb.append("<input type=\"text\" class=\"Wdate "
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
		if (StringUtils.isNotBlank(getValue())) {
			sb.append(" value=\"" + getValue() + "\"");
		}
		sb.append(" onClick=\"WdatePicker("
				+ StringUtils.trimToEmpty(getParams()) + ")\"/>");
		getJspContext().getOut().write(sb.toString());
		super.doTag();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
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

	public Boolean getDefaultTime() {
		return defaultTime;
	}

	public void setDefaultTime(Boolean defaultTime) {
		this.defaultTime = defaultTime;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
}

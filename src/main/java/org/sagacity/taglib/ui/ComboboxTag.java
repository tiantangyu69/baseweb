/**
 * 
 */
package org.sagacity.taglib.ui;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

/**
 * @author LIZHITAO 下拉框控件标签
 */
public class ComboboxTag extends SimpleTagSupport {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String style;
	private String cssClass;
	private boolean editable = false;
	private String url;
	private String valueField;
	private String textField;
	private boolean multiple = false;
	private boolean required = false;
	private String value;

	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer sb = new StringBuffer();
		sb.append("<input type=\"text\" editable=\"" + editable + "\" class=\"easyui-combobox "
				+ StringUtils.trimToEmpty(getCssClass()) + "\"");
		if (required) {// 是否必填
			sb.append(" data-options=\"required:true\"");
		} 
		if(multiple){
			sb.append(" multiple=\"" + multiple + "\"");
		}
		if (StringUtils.isNotBlank(getId())) {
			sb.append(" id=\"" + getId() + "\"");
		}
		if (StringUtils.isNotBlank(getName())) {
			sb.append(" name=\"" + getName() + "\"");
		}
		if (StringUtils.isNotBlank(getStyle())) {
			sb.append(" style=\"" + getStyle() + "\"");
		}
		if (StringUtils.isNotBlank(getUrl())) {
			sb.append(" url=\"" + getUrl() + "\"");
		}
		if (StringUtils.isNotBlank(getValueField())) {
			sb.append(" valueField=\"" + getValueField() + "\"");
		}
		if (StringUtils.isNotBlank(getTextField())) {
			sb.append(" textField=\"" + getTextField() + "\"");
		}
		if (StringUtils.isNotBlank(getValue())) {
			sb.append(" value=\"" + getValue() + "\"");
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

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getValueField() {
		return valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	public String getTextField() {
		return textField;
	}

	public void setTextField(String textField) {
		this.textField = textField;
	}

	public boolean isMultiple() {
		return multiple;
	}

	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

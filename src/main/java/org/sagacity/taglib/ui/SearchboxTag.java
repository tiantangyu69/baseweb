/**
 * 
 */
package org.sagacity.taglib.ui;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

/**
 * @author LIZHITAO 搜索文本输入框控件
 */
public class SearchboxTag extends SimpleTagSupport {
	private static final long serialVersionUID = 1L;
	private String id;
	private String style;
	private String cssClass;
	private String name;
	private String value;
	private String prompt;
	private String searcher;
	private String menu;

	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer sb = new StringBuffer();
		sb.append("<input class=\"easyui-searchbox " + StringUtils.trimToEmpty(getCssClass())
						+ "\" type=\"text\"");
		if (StringUtils.isNotBlank(getId())) {
			sb.append(" id=\"" + getId() + "\"");
		}
		if (StringUtils.isNotBlank(getName())) {
			sb.append(" name=\"" + getName() + "\"");
		}
		if (StringUtils.isNotBlank(getMenu())) {
			sb.append(" menu=\"" + getMenu() + "\"");
		}
		if (StringUtils.isNotBlank(getStyle())) {
			sb.append(" style=\"" + getStyle() + "\"");
		}
		if (StringUtils.isNotBlank(getValue())) {
			sb.append(" value=\"" + getValue() + "\"");
		}
		if (StringUtils.isNotBlank(getPrompt())) {
			sb.append(" prompt=\"" + getPrompt() + "\"");
		}
		if (StringUtils.isNotBlank(getSearcher())) {
			sb.append(" searcher=\"" + getSearcher() + "\"");
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getSearcher() {
		return searcher;
	}

	public void setSearcher(String searcher) {
		this.searcher = searcher;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}
}

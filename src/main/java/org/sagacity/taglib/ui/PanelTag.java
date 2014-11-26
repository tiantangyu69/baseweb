/**
 * 
 */
package org.sagacity.taglib.ui;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;

/**
 * @author LIZHITAO
 * 
 */
public class PanelTag extends TagSupport {
	private static final long serialVersionUID = -5831111632414934989L;
	private String id;
	private String cssClass;
	private String title;
	private String style;

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		StringBuffer sb = new StringBuffer();
		sb.append("<div id=\"" + StringUtils.trimToEmpty(getId()) + "\" class=\"easyui-panel "
				+ StringUtils.trimToEmpty(getStyle()) + "\" title=\"" + StringUtils.trimToEmpty(getTitle() )+ "\" style=\""
				+ StringUtils.trimToEmpty(getStyle()) + "\">");
		try {
			out.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
			out.write("</div>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
}

/**
 * 
 */
package org.sagacity.taglib.ui;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;

/**
 * @author LIZHITAO 页面布局控件
 * 
 */
public class LayoutTag extends BodyTagSupport {
	private static final long serialVersionUID = 1L;
	private String id;
	private String cssClass;
	private String title;
	private String style;
	private Boolean border;
	private Boolean fit;

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		StringBuffer sb = new StringBuffer();
		
		// 拼凑data-options 属性
		StringBuffer dataOptions = new StringBuffer();
		if (null != getFit()) {
			dataOptions.append("fit:" + getFit());
		}
		if (null != getBorder() && null == getFit()) {
			dataOptions.append("border:" + getBorder());
		} else if(null != getBorder() && null != getFit()){
			dataOptions.append(", border:" + getBorder());
		}

		// 拼凑div
		sb.append("<div data-options=\"" + dataOptions.toString() + "\" class=\"easyui-layout "
				+ StringUtils.trimToEmpty(getStyle()) + "\"");
		if (StringUtils.isNotBlank(getId())) {
			sb.append(" id=\"" + getId() + "\"");
		}
		if (StringUtils.isNotBlank(getStyle())) {
			sb.append(" style=\"" + getStyle() + "\"");
		}
		if (null != getTitle() && !getTitle().equals("")) {
			sb.append(" title=\"" + getTitle() + "\"");
		}
		sb.append(">");
		try {
			out.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
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

	public Boolean getBorder() {
		return border;
	}

	public void setBorder(Boolean border) {
		this.border = border;
	}

	public Boolean getFit() {
		return fit;
	}

	public void setFit(Boolean fit) {
		this.fit = fit;
	}
}

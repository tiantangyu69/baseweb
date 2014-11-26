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
 * @author LIZHITAO 选项卡控件
 * 
 */
public class TabsTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	private String id;
	private Boolean plain;
	private Boolean fit;
	private Boolean border;
	private String cssClass;
	private String style;

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		StringBuffer sb = new StringBuffer();
		// 拼凑div
		// 拼凑div
		sb.append("<div class=\"easyui-tabs "
				+ StringUtils.trimToEmpty(getStyle()) + "\"");
		if (StringUtils.isNotBlank(getId())) {
			sb.append(" id=\"" + getId() + "\"");
		}
		if (StringUtils.isNotBlank(getStyle())) {
			sb.append(" style=\"" + getStyle() + "\"");
		}
		if (null != getBorder()) {
			sb.append(" border=\"" + getBorder() + "\"");
		}
		if (null != getPlain()) {
			sb.append(" plain=\"" + getPlain() + "\"");
		}
		if (null != getFit()) {
			sb.append(" fit=\"" + getFit() + "\"");
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

	public Boolean getPlain() {
		return plain;
	}

	public void setPlain(Boolean plain) {
		this.plain = plain;
	}

	public Boolean getFit() {
		return fit;
	}

	public void setFit(Boolean fit) {
		this.fit = fit;
	}

}

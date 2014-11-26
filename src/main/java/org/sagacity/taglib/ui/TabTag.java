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
public class TabTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	private String id;
	private String title;
	private String content;
	private String href;
	private Boolean cache;
	private String icon;
	private Boolean collapsible;
	private String cssClass;
	private String style;

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		StringBuffer sb = new StringBuffer();
		// 拼凑div
		// 拼凑div
		sb.append("<div");
		if (StringUtils.isNotBlank(getId())) {
			sb.append(" id=\"" + getId() + "\"");
		}
		if(null != getTitle() && !getTitle().equals("")){
			sb.append(" title=\"" + getTitle()+ "\"");
		}
		if (StringUtils.isNotBlank(getStyle())) {
			sb.append(" style=\"" + getStyle() + "\"");
		}
		if (StringUtils.isNotBlank(getCssClass())) {
			sb.append(" class=\"" + getCssClass() + "\"");
		}
		if (StringUtils.isNotBlank(getContent())) {
			sb.append(" content=\"" + getContent() + "\"");
		}
		if (StringUtils.isNotBlank(getHref())) {
			sb.append(" href=\"" + getHref() + "\"");
		}
		if (null != getCollapsible()) {
			sb.append(" collapsible=\"" + getCollapsible() + "\"");
		}
		if (null != getCache()) {
			sb.append(" cache=\"" + getCache() + "\"");
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Boolean getCache() {
		return cache;
	}

	public void setCache(Boolean cache) {
		this.cache = cache;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Boolean getCollapsible() {
		return collapsible;
	}

	public void setCollapsible(Boolean collapsible) {
		this.collapsible = collapsible;
	}

}

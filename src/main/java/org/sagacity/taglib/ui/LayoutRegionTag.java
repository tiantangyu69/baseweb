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
 * @author LIZHITAO 页面布局控件
 * 
 */
public class LayoutRegionTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	private String id;
	private String region;
	private Boolean split;
	private Boolean border;
	private String href;
	private String icon;
	private String cssClass;
	private String title;
	private String style;
	private boolean collapsed = false;

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		StringBuffer sb = new StringBuffer();
		// 拼凑data-options 属性
		StringBuffer dataOptions = new StringBuffer();
		dataOptions.append("region:'" + region + "', collapsed:" + collapsed);
		if (null != getSplit()) {
			dataOptions.append(", split:" + getSplit());
		}
		if (null != getBorder()) {
			dataOptions.append(", border:" + getBorder());
		}
		if(StringUtils.isNotBlank(icon)){
			dataOptions.append(", iconCls:'" + getIcon() + "'");
		}
		if(StringUtils.isNotBlank(href)){
			dataOptions.append(", href:'" + getHref() + "'");
		}
		// 拼凑div
		sb.append("<div data-options=\"" + dataOptions + "\"");
		if(StringUtils.isNotBlank(getId())){
			sb.append(" id=\"" + getId()+ "\"");
		}
		if(StringUtils.isNotBlank(getCssClass())){
			sb.append(" class=\"" + getCssClass()+ "\"");
		}
		if(StringUtils.isNotBlank(getStyle())){
			sb.append(" style=\"" + getStyle()+ "\"");
		}
		if(null != getTitle() && !getTitle().equals("")){
			sb.append(" title=\"" + getTitle()+ "\"");
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Boolean getSplit() {
		return split;
	}

	public void setSplit(Boolean split) {
		this.split = split;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Boolean getBorder() {
		return border;
	}

	public void setBorder(Boolean border) {
		this.border = border;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public boolean isCollapsed() {
		return collapsed;
	}

	public void setCollapsed(boolean collapsed) {
		this.collapsed = collapsed;
	}

}

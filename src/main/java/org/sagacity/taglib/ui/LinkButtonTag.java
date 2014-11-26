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
 * @author LIZHITAO 按钮控件
 */
public class LinkButtonTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	private String id;
	private String style;
	private String cssClass;
	private String text;
	private String icon;
	private String iconAlign;
	private String onclick;
	private String href;
	private boolean disabled = false;
	private boolean toggle = false;
	private boolean selected = false;
	private boolean plain = false;

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
			out.write("</a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		StringBuffer sb = new StringBuffer();
		sb.append("<a class=\"easyui-linkbutton "
				+ StringUtils.trimToEmpty(getCssClass()) + "\"");
		if (StringUtils.isNotBlank(getId())) {
			sb.append(" id=\"" + getId() + "\"");
		}
		if (StringUtils.isNotBlank(getStyle())) {
			sb.append(" style=\"" + getStyle() + "\"");
		}
		if (StringUtils.isNotBlank(getText())) {
			sb.append(" text=\"" + getText() + "\"");
		}
		if (StringUtils.isNotBlank(getIcon())) {
			sb.append(" iconCls=\"" + getIcon() + "\"");
		}
		if (StringUtils.isNotBlank(getIconAlign())) {
			sb.append(" iconAlign=\"" + getIconAlign() + "\"");
		}
		if (StringUtils.isNotBlank(getOnclick())) {
			sb.append(" onclick=\"" + getOnclick() + "\"");
		}
		if (StringUtils.isNotBlank(getHref())) {
			sb.append(" href=\"" + getHref() + "\"");
		}
		if (disabled) {
			sb.append(" disabled=\"" + disabled + "\"");
		}
		if (toggle) {
			sb.append(" toggle=\"" + toggle + "\"");
		}
		if (selected) {
			sb.append(" selected=\"" + selected + "\"");
		}
		if (plain) {
			sb.append(" plain=\"" + plain + "\"");
		}
		sb.append("</a>");
		try {
			out.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIconAlign() {
		return iconAlign;
	}

	public void setIconAlign(String iconAlign) {
		this.iconAlign = iconAlign;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public boolean isToggle() {
		return toggle;
	}

	public void setToggle(boolean toggle) {
		this.toggle = toggle;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isPlain() {
		return plain;
	}

	public void setPlain(boolean plain) {
		this.plain = plain;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
}
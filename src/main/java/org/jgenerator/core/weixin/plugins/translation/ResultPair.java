package org.jgenerator.core.weixin.plugins.translation;

/**
 * 百度翻译结果
 * 
 * @author LIZHITAO
 */
public class ResultPair {
	private String src;// 原文
	private String dst;// 译文

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getDst() {
		return dst;
	}

	public void setDst(String dst) {
		this.dst = dst;
	}
}
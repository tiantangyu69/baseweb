package org.jgenerator.model;

import org.jgenerator.core.model.Entity;

public class News extends Entity {
	/**
	 * @type long
	 * @field serialVersionUID
	 * @state
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer andLikeId;
	private Integer startLikeId;
	private Integer itemId;
	private Integer andLikeItemId;
	private Integer startLikeItemId;
	private Integer newsTypeId;
	private Integer andLikeNewsTypeId;
	private Integer startLikeNewsTypeId;
	private String title;
	private String andLikeTitle;
	private String startLikeTitle;
	private String author;
	private String andLikeAuthor;
	private String startLikeAuthor;
	private String source;
	private String andLikeSource;
	private String startLikeSource;
	private String sourceUrl;
	private String andLikeSourceUrl;
	private String startLikeSourceUrl;
	private String picPath;
	private String andLikePicPath;
	private String startLikePicPath;
	private String deployDate;
	private String andLikeDeployDate;
	private String startLikeDeployDate;
	private String content;
	private String andLikeContent;
	private String startLikeContent;
	private Integer status;
	private Integer andLikeStatus;
	private Integer startLikeStatus;
	private String deployUsername;
	private String andLikeDeployUsername;
	private String startLikeDeployUsername;
	private String attribute1;
	private String andLikeAttribute1;
	private String startLikeAttribute1;
	private String attribute2;
	private String andLikeAttribute2;
	private String startLikeAttribute2;
	private String attribute3;
	private String andLikeAttribute3;
	private String startLikeAttribute3;
	private String attribute4;
	private String andLikeAttribute4;
	private String startLikeAttribute4;
	private String attribute5;
	private String andLikeAttribute5;
	private String startLikeAttribute5;
	private String attribute6;
	private String andLikeAttribute6;
	private String startLikeAttribute6;
	private String attribute7;
	private String andLikeAttribute7;
	private String startLikeAttribute7;
	private String attribute8;
	private String andLikeAttribute8;
	private String startLikeAttribute8;
	private String attribute9;
	private String andLikeAttribute9;
	private String startLikeAttribute9;
	private String attribute10;
	private String andLikeAttribute10;
	private String startLikeAttribute10;
	private DictionaryValue newsItem;
	private DictionaryValue newsType;

	public DictionaryValue getNewsItem() {
		return newsItem;
	}

	public void setNewsItem(DictionaryValue newsItem) {
		this.newsItem = newsItem;
	}

	public DictionaryValue getNewsType() {
		return newsType;
	}

	public void setNewsType(DictionaryValue newsType) {
		this.newsType = newsType;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setAndLikeId(Integer andLikeId) {
		this.andLikeId = andLikeId;
	}

	public Integer getAndLikeId() {
		return this.andLikeId;
	}

	public void setStartLikeId(Integer startLikeId) {
		this.startLikeId = startLikeId;
	}

	public Integer getStartLikeId() {
		return this.startLikeId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getItemId() {
		return this.itemId;
	}

	public void setAndLikeItemId(Integer andLikeItemId) {
		this.andLikeItemId = andLikeItemId;
	}

	public Integer getAndLikeItemId() {
		return this.andLikeItemId;
	}

	public void setStartLikeItemId(Integer startLikeItemId) {
		this.startLikeItemId = startLikeItemId;
	}

	public Integer getStartLikeItemId() {
		return this.startLikeItemId;
	}

	public void setNewsTypeId(Integer newsTypeId) {
		this.newsTypeId = newsTypeId;
	}

	public Integer getNewsTypeId() {
		return this.newsTypeId;
	}

	public void setAndLikeNewsTypeId(Integer andLikeNewsTypeId) {
		this.andLikeNewsTypeId = andLikeNewsTypeId;
	}

	public Integer getAndLikeNewsTypeId() {
		return this.andLikeNewsTypeId;
	}

	public void setStartLikeNewsTypeId(Integer startLikeNewsTypeId) {
		this.startLikeNewsTypeId = startLikeNewsTypeId;
	}

	public Integer getStartLikeNewsTypeId() {
		return this.startLikeNewsTypeId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setAndLikeTitle(String andLikeTitle) {
		this.andLikeTitle = andLikeTitle;
	}

	public String getAndLikeTitle() {
		return this.andLikeTitle;
	}

	public void setStartLikeTitle(String startLikeTitle) {
		this.startLikeTitle = startLikeTitle;
	}

	public String getStartLikeTitle() {
		return this.startLikeTitle;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAndLikeAuthor(String andLikeAuthor) {
		this.andLikeAuthor = andLikeAuthor;
	}

	public String getAndLikeAuthor() {
		return this.andLikeAuthor;
	}

	public void setStartLikeAuthor(String startLikeAuthor) {
		this.startLikeAuthor = startLikeAuthor;
	}

	public String getStartLikeAuthor() {
		return this.startLikeAuthor;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource() {
		return this.source;
	}

	public void setAndLikeSource(String andLikeSource) {
		this.andLikeSource = andLikeSource;
	}

	public String getAndLikeSource() {
		return this.andLikeSource;
	}

	public void setStartLikeSource(String startLikeSource) {
		this.startLikeSource = startLikeSource;
	}

	public String getStartLikeSource() {
		return this.startLikeSource;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getSourceUrl() {
		return this.sourceUrl;
	}

	public void setAndLikeSourceUrl(String andLikeSourceUrl) {
		this.andLikeSourceUrl = andLikeSourceUrl;
	}

	public String getAndLikeSourceUrl() {
		return this.andLikeSourceUrl;
	}

	public void setStartLikeSourceUrl(String startLikeSourceUrl) {
		this.startLikeSourceUrl = startLikeSourceUrl;
	}

	public String getStartLikeSourceUrl() {
		return this.startLikeSourceUrl;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getPicPath() {
		return this.picPath;
	}

	public void setAndLikePicPath(String andLikePicPath) {
		this.andLikePicPath = andLikePicPath;
	}

	public String getAndLikePicPath() {
		return this.andLikePicPath;
	}

	public void setStartLikePicPath(String startLikePicPath) {
		this.startLikePicPath = startLikePicPath;
	}

	public String getStartLikePicPath() {
		return this.startLikePicPath;
	}

	public void setDeployDate(String deployDate) {
		this.deployDate = deployDate;
	}

	public String getDeployDate() {
		return this.deployDate;
	}

	public void setAndLikeDeployDate(String andLikeDeployDate) {
		this.andLikeDeployDate = andLikeDeployDate;
	}

	public String getAndLikeDeployDate() {
		return this.andLikeDeployDate;
	}

	public void setStartLikeDeployDate(String startLikeDeployDate) {
		this.startLikeDeployDate = startLikeDeployDate;
	}

	public String getStartLikeDeployDate() {
		return this.startLikeDeployDate;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public void setAndLikeContent(String andLikeContent) {
		this.andLikeContent = andLikeContent;
	}

	public String getAndLikeContent() {
		return this.andLikeContent;
	}

	public void setStartLikeContent(String startLikeContent) {
		this.startLikeContent = startLikeContent;
	}

	public String getStartLikeContent() {
		return this.startLikeContent;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setAndLikeStatus(Integer andLikeStatus) {
		this.andLikeStatus = andLikeStatus;
	}

	public Integer getAndLikeStatus() {
		return this.andLikeStatus;
	}

	public void setStartLikeStatus(Integer startLikeStatus) {
		this.startLikeStatus = startLikeStatus;
	}

	public Integer getStartLikeStatus() {
		return this.startLikeStatus;
	}

	public void setDeployUsername(String deployUsername) {
		this.deployUsername = deployUsername;
	}

	public String getDeployUsername() {
		return this.deployUsername;
	}

	public void setAndLikeDeployUsername(String andLikeDeployUsername) {
		this.andLikeDeployUsername = andLikeDeployUsername;
	}

	public String getAndLikeDeployUsername() {
		return this.andLikeDeployUsername;
	}

	public void setStartLikeDeployUsername(String startLikeDeployUsername) {
		this.startLikeDeployUsername = startLikeDeployUsername;
	}

	public String getStartLikeDeployUsername() {
		return this.startLikeDeployUsername;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute1() {
		return this.attribute1;
	}

	public void setAndLikeAttribute1(String andLikeAttribute1) {
		this.andLikeAttribute1 = andLikeAttribute1;
	}

	public String getAndLikeAttribute1() {
		return this.andLikeAttribute1;
	}

	public void setStartLikeAttribute1(String startLikeAttribute1) {
		this.startLikeAttribute1 = startLikeAttribute1;
	}

	public String getStartLikeAttribute1() {
		return this.startLikeAttribute1;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute2() {
		return this.attribute2;
	}

	public void setAndLikeAttribute2(String andLikeAttribute2) {
		this.andLikeAttribute2 = andLikeAttribute2;
	}

	public String getAndLikeAttribute2() {
		return this.andLikeAttribute2;
	}

	public void setStartLikeAttribute2(String startLikeAttribute2) {
		this.startLikeAttribute2 = startLikeAttribute2;
	}

	public String getStartLikeAttribute2() {
		return this.startLikeAttribute2;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getAttribute3() {
		return this.attribute3;
	}

	public void setAndLikeAttribute3(String andLikeAttribute3) {
		this.andLikeAttribute3 = andLikeAttribute3;
	}

	public String getAndLikeAttribute3() {
		return this.andLikeAttribute3;
	}

	public void setStartLikeAttribute3(String startLikeAttribute3) {
		this.startLikeAttribute3 = startLikeAttribute3;
	}

	public String getStartLikeAttribute3() {
		return this.startLikeAttribute3;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	public String getAttribute4() {
		return this.attribute4;
	}

	public void setAndLikeAttribute4(String andLikeAttribute4) {
		this.andLikeAttribute4 = andLikeAttribute4;
	}

	public String getAndLikeAttribute4() {
		return this.andLikeAttribute4;
	}

	public void setStartLikeAttribute4(String startLikeAttribute4) {
		this.startLikeAttribute4 = startLikeAttribute4;
	}

	public String getStartLikeAttribute4() {
		return this.startLikeAttribute4;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	public String getAttribute5() {
		return this.attribute5;
	}

	public void setAndLikeAttribute5(String andLikeAttribute5) {
		this.andLikeAttribute5 = andLikeAttribute5;
	}

	public String getAndLikeAttribute5() {
		return this.andLikeAttribute5;
	}

	public void setStartLikeAttribute5(String startLikeAttribute5) {
		this.startLikeAttribute5 = startLikeAttribute5;
	}

	public String getStartLikeAttribute5() {
		return this.startLikeAttribute5;
	}

	public void setAttribute6(String attribute6) {
		this.attribute6 = attribute6;
	}

	public String getAttribute6() {
		return this.attribute6;
	}

	public void setAndLikeAttribute6(String andLikeAttribute6) {
		this.andLikeAttribute6 = andLikeAttribute6;
	}

	public String getAndLikeAttribute6() {
		return this.andLikeAttribute6;
	}

	public void setStartLikeAttribute6(String startLikeAttribute6) {
		this.startLikeAttribute6 = startLikeAttribute6;
	}

	public String getStartLikeAttribute6() {
		return this.startLikeAttribute6;
	}

	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}

	public String getAttribute7() {
		return this.attribute7;
	}

	public void setAndLikeAttribute7(String andLikeAttribute7) {
		this.andLikeAttribute7 = andLikeAttribute7;
	}

	public String getAndLikeAttribute7() {
		return this.andLikeAttribute7;
	}

	public void setStartLikeAttribute7(String startLikeAttribute7) {
		this.startLikeAttribute7 = startLikeAttribute7;
	}

	public String getStartLikeAttribute7() {
		return this.startLikeAttribute7;
	}

	public void setAttribute8(String attribute8) {
		this.attribute8 = attribute8;
	}

	public String getAttribute8() {
		return this.attribute8;
	}

	public void setAndLikeAttribute8(String andLikeAttribute8) {
		this.andLikeAttribute8 = andLikeAttribute8;
	}

	public String getAndLikeAttribute8() {
		return this.andLikeAttribute8;
	}

	public void setStartLikeAttribute8(String startLikeAttribute8) {
		this.startLikeAttribute8 = startLikeAttribute8;
	}

	public String getStartLikeAttribute8() {
		return this.startLikeAttribute8;
	}

	public void setAttribute9(String attribute9) {
		this.attribute9 = attribute9;
	}

	public String getAttribute9() {
		return this.attribute9;
	}

	public void setAndLikeAttribute9(String andLikeAttribute9) {
		this.andLikeAttribute9 = andLikeAttribute9;
	}

	public String getAndLikeAttribute9() {
		return this.andLikeAttribute9;
	}

	public void setStartLikeAttribute9(String startLikeAttribute9) {
		this.startLikeAttribute9 = startLikeAttribute9;
	}

	public String getStartLikeAttribute9() {
		return this.startLikeAttribute9;
	}

	public void setAttribute10(String attribute10) {
		this.attribute10 = attribute10;
	}

	public String getAttribute10() {
		return this.attribute10;
	}

	public void setAndLikeAttribute10(String andLikeAttribute10) {
		this.andLikeAttribute10 = andLikeAttribute10;
	}

	public String getAndLikeAttribute10() {
		return this.andLikeAttribute10;
	}

	public void setStartLikeAttribute10(String startLikeAttribute10) {
		this.startLikeAttribute10 = startLikeAttribute10;
	}

	public String getStartLikeAttribute10() {
		return this.startLikeAttribute10;
	}

}
package org.jgenerator.model;

import java.util.List;

import org.jgenerator.core.model.Entity;

public class DictionaryValue extends Entity {
	/**
	 * @type long
	 * @field serialVersionUID
	 * @state
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer andLikeId;
	private Integer startLikeId;
	private Integer dictionaryTypeId;
	private Integer andLikeDictionaryTypeId;
	private Integer startLikeDictionaryTypeId;
	private String value;
	private String andLikeValue;
	private String startLikeValue;
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
	private DictionaryType dictionaryType;
	private List<News> newsList;

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public DictionaryType getDictionaryType() {
		return dictionaryType;
	}

	public void setDictionaryType(DictionaryType dictionaryType) {
		this.dictionaryType = dictionaryType;
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

	public void setDictionaryTypeId(Integer dictionaryTypeId) {
		this.dictionaryTypeId = dictionaryTypeId;
	}

	public Integer getDictionaryTypeId() {
		return this.dictionaryTypeId;
	}

	public void setAndLikeDictionaryTypeId(Integer andLikeDictionaryTypeId) {
		this.andLikeDictionaryTypeId = andLikeDictionaryTypeId;
	}

	public Integer getAndLikeDictionaryTypeId() {
		return this.andLikeDictionaryTypeId;
	}

	public void setStartLikeDictionaryTypeId(Integer startLikeDictionaryTypeId) {
		this.startLikeDictionaryTypeId = startLikeDictionaryTypeId;
	}

	public Integer getStartLikeDictionaryTypeId() {
		return this.startLikeDictionaryTypeId;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public void setAndLikeValue(String andLikeValue) {
		this.andLikeValue = andLikeValue;
	}

	public String getAndLikeValue() {
		return this.andLikeValue;
	}

	public void setStartLikeValue(String startLikeValue) {
		this.startLikeValue = startLikeValue;
	}

	public String getStartLikeValue() {
		return this.startLikeValue;
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

}
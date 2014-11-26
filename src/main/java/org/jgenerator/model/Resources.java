package org.jgenerator.model;

import org.jgenerator.core.model.Entity;

public class Resources extends Entity {
	/**
	 * @type long
	 * @field serialVersionUID
	 * @state
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer andLikeId;
	private Integer startLikeId;
	private String code;
	private String andLikeCode;
	private String startLikeCode;
	private String name;
	private String andLikeName;
	private String startLikeName;
	private Integer resourceType;
	private Integer andLikeResourceType;
	private Integer startLikeResourceType;
	private String url;
	private String andLikeUrl;
	private String startLikeUrl;
	private Integer parentId;
	private Integer andLikeParentId;
	private Integer startLikeParentId;
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
	private String state = "closed";

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public void setAndLikeCode(String andLikeCode) {
		this.andLikeCode = andLikeCode;
	}

	public String getAndLikeCode() {
		return this.andLikeCode;
	}

	public void setStartLikeCode(String startLikeCode) {
		this.startLikeCode = startLikeCode;
	}

	public String getStartLikeCode() {
		return this.startLikeCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAndLikeName(String andLikeName) {
		this.andLikeName = andLikeName;
	}

	public String getAndLikeName() {
		return this.andLikeName;
	}

	public void setStartLikeName(String startLikeName) {
		this.startLikeName = startLikeName;
	}

	public String getStartLikeName() {
		return this.startLikeName;
	}

	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

	public Integer getResourceType() {
		return this.resourceType;
	}

	public void setAndLikeResourceType(Integer andLikeResourceType) {
		this.andLikeResourceType = andLikeResourceType;
	}

	public Integer getAndLikeResourceType() {
		return this.andLikeResourceType;
	}

	public void setStartLikeResourceType(Integer startLikeResourceType) {
		this.startLikeResourceType = startLikeResourceType;
	}

	public Integer getStartLikeResourceType() {
		return this.startLikeResourceType;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

	public void setAndLikeUrl(String andLikeUrl) {
		this.andLikeUrl = andLikeUrl;
	}

	public String getAndLikeUrl() {
		return this.andLikeUrl;
	}

	public void setStartLikeUrl(String startLikeUrl) {
		this.startLikeUrl = startLikeUrl;
	}

	public String getStartLikeUrl() {
		return this.startLikeUrl;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setAndLikeParentId(Integer andLikeParentId) {
		this.andLikeParentId = andLikeParentId;
	}

	public Integer getAndLikeParentId() {
		return this.andLikeParentId;
	}

	public void setStartLikeParentId(Integer startLikeParentId) {
		this.startLikeParentId = startLikeParentId;
	}

	public Integer getStartLikeParentId() {
		return this.startLikeParentId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resources other = (Resources) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
package org.jgenerator.model;

import org.jgenerator.core.model.Entity;

public class ManageUserRole extends Entity {
	/**
	 * @type long
	 * @field serialVersionUID
	 * @state
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer andLikeId;
	private Integer startLikeId;
	private Integer userId;
	private Integer andLikeUserId;
	private Integer startLikeUserId;
	private Integer roleId;
	private Integer andLikeRoleId;
	private Integer startLikeRoleId;
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
	private ManageUser manageUser;

	public ManageUser getManageUser() {
		return manageUser;
	}

	public void setManageUser(ManageUser manageUser) {
		this.manageUser = manageUser;
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

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setAndLikeUserId(Integer andLikeUserId) {
		this.andLikeUserId = andLikeUserId;
	}

	public Integer getAndLikeUserId() {
		return this.andLikeUserId;
	}

	public void setStartLikeUserId(Integer startLikeUserId) {
		this.startLikeUserId = startLikeUserId;
	}

	public Integer getStartLikeUserId() {
		return this.startLikeUserId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setAndLikeRoleId(Integer andLikeRoleId) {
		this.andLikeRoleId = andLikeRoleId;
	}

	public Integer getAndLikeRoleId() {
		return this.andLikeRoleId;
	}

	public void setStartLikeRoleId(Integer startLikeRoleId) {
		this.startLikeRoleId = startLikeRoleId;
	}

	public Integer getStartLikeRoleId() {
		return this.startLikeRoleId;
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
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		ManageUserRole other = (ManageUserRole) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
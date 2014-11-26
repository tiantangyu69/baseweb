package org.jgenerator.model;

import org.jgenerator.core.model.Entity;
import java.util.HashMap;

public class ManageUser extends Entity {
	/**
	 * @type long
	 * @field serialVersionUID
	 * @state
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer andLikeId;
	private Integer startLikeId;
	private String username;
	private String andLikeUsername;
	private String startLikeUsername;
	private String password;
	private String andLikePassword;
	private String startLikePassword;
	private String trueName;
	private String andLikeTrueName;
	private String startLikeTrueName;
	private String sex;
	private String andLikeSex;
	private String startLikeSex;
	private String birthday;
	private String andLikeBirthday;
	private String startLikeBirthday;
	private String idCard;
	private String andLikeIdCard;
	private String startLikeIdCard;
	private Integer department;
	private Integer andLikeDepartment;
	private Integer startLikeDepartment;
	private Integer duty;
	private Integer andLikeDuty;
	private Integer startLikeDuty;
	private Integer grade;
	private Integer andLikeGrade;
	private Integer startLikeGrade;
	private String telephone;
	private String andLikeTelephone;
	private String startLikeTelephone;
	private String email;
	private String andLikeEmail;
	private String startLikeEmail;
	private Integer status;
	private Integer andLikeStatus;
	private Integer startLikeStatus;
	private String lastLoginTime;
	private String andLikeLastLoginTime;
	private String startLikeLastLoginTime;
	private String lastLoginIP;
	private String andLikeLastLoginIP;
	private String startLikeLastLoginIP;
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
	private String attribute11;
	private String andLikeAttribute11;
	private String startLikeAttribute11;
	private String attribute12;
	private String andLikeAttribute12;
	private String startLikeAttribute12;
	private String attribute13;
	private String andLikeAttribute13;
	private String startLikeAttribute13;
	private String attribute14;
	private String andLikeAttribute14;
	private String startLikeAttribute14;
	private String attribute15;
	private String andLikeAttribute15;
	private String startLikeAttribute15;
	private String attribute16;
	private String andLikeAttribute16;
	private String startLikeAttribute16;
	private Department dept;

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

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void setAndLikeUsername(String andLikeUsername) {
		this.andLikeUsername = andLikeUsername;
	}

	public String getAndLikeUsername() {
		return this.andLikeUsername;
	}

	public void setStartLikeUsername(String startLikeUsername) {
		this.startLikeUsername = startLikeUsername;
	}

	public String getStartLikeUsername() {
		return this.startLikeUsername;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setAndLikePassword(String andLikePassword) {
		this.andLikePassword = andLikePassword;
	}

	public String getAndLikePassword() {
		return this.andLikePassword;
	}

	public void setStartLikePassword(String startLikePassword) {
		this.startLikePassword = startLikePassword;
	}

	public String getStartLikePassword() {
		return this.startLikePassword;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getTrueName() {
		return this.trueName;
	}

	public void setAndLikeTrueName(String andLikeTrueName) {
		this.andLikeTrueName = andLikeTrueName;
	}

	public String getAndLikeTrueName() {
		return this.andLikeTrueName;
	}

	public void setStartLikeTrueName(String startLikeTrueName) {
		this.startLikeTrueName = startLikeTrueName;
	}

	public String getStartLikeTrueName() {
		return this.startLikeTrueName;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return this.sex;
	}

	public void setAndLikeSex(String andLikeSex) {
		this.andLikeSex = andLikeSex;
	}

	public String getAndLikeSex() {
		return this.andLikeSex;
	}

	public void setStartLikeSex(String startLikeSex) {
		this.startLikeSex = startLikeSex;
	}

	public String getStartLikeSex() {
		return this.startLikeSex;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setAndLikeBirthday(String andLikeBirthday) {
		this.andLikeBirthday = andLikeBirthday;
	}

	public String getAndLikeBirthday() {
		return this.andLikeBirthday;
	}

	public void setStartLikeBirthday(String startLikeBirthday) {
		this.startLikeBirthday = startLikeBirthday;
	}

	public String getStartLikeBirthday() {
		return this.startLikeBirthday;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setAndLikeIdCard(String andLikeIdCard) {
		this.andLikeIdCard = andLikeIdCard;
	}

	public String getAndLikeIdCard() {
		return this.andLikeIdCard;
	}

	public void setStartLikeIdCard(String startLikeIdCard) {
		this.startLikeIdCard = startLikeIdCard;
	}

	public String getStartLikeIdCard() {
		return this.startLikeIdCard;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Integer getDepartment() {
		return this.department;
	}

	public void setAndLikeDepartment(Integer andLikeDepartment) {
		this.andLikeDepartment = andLikeDepartment;
	}

	public Integer getAndLikeDepartment() {
		return this.andLikeDepartment;
	}

	public void setStartLikeDepartment(Integer startLikeDepartment) {
		this.startLikeDepartment = startLikeDepartment;
	}

	public Integer getStartLikeDepartment() {
		return this.startLikeDepartment;
	}

	public void setDuty(Integer duty) {
		this.duty = duty;
	}

	public Integer getDuty() {
		return this.duty;
	}

	public void setAndLikeDuty(Integer andLikeDuty) {
		this.andLikeDuty = andLikeDuty;
	}

	public Integer getAndLikeDuty() {
		return this.andLikeDuty;
	}

	public void setStartLikeDuty(Integer startLikeDuty) {
		this.startLikeDuty = startLikeDuty;
	}

	public Integer getStartLikeDuty() {
		return this.startLikeDuty;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setAndLikeGrade(Integer andLikeGrade) {
		this.andLikeGrade = andLikeGrade;
	}

	public Integer getAndLikeGrade() {
		return this.andLikeGrade;
	}

	public void setStartLikeGrade(Integer startLikeGrade) {
		this.startLikeGrade = startLikeGrade;
	}

	public Integer getStartLikeGrade() {
		return this.startLikeGrade;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setAndLikeTelephone(String andLikeTelephone) {
		this.andLikeTelephone = andLikeTelephone;
	}

	public String getAndLikeTelephone() {
		return this.andLikeTelephone;
	}

	public void setStartLikeTelephone(String startLikeTelephone) {
		this.startLikeTelephone = startLikeTelephone;
	}

	public String getStartLikeTelephone() {
		return this.startLikeTelephone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setAndLikeEmail(String andLikeEmail) {
		this.andLikeEmail = andLikeEmail;
	}

	public String getAndLikeEmail() {
		return this.andLikeEmail;
	}

	public void setStartLikeEmail(String startLikeEmail) {
		this.startLikeEmail = startLikeEmail;
	}

	public String getStartLikeEmail() {
		return this.startLikeEmail;
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

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setAndLikeLastLoginTime(String andLikeLastLoginTime) {
		this.andLikeLastLoginTime = andLikeLastLoginTime;
	}

	public String getAndLikeLastLoginTime() {
		return this.andLikeLastLoginTime;
	}

	public void setStartLikeLastLoginTime(String startLikeLastLoginTime) {
		this.startLikeLastLoginTime = startLikeLastLoginTime;
	}

	public String getStartLikeLastLoginTime() {
		return this.startLikeLastLoginTime;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

	public String getLastLoginIP() {
		return this.lastLoginIP;
	}

	public void setAndLikeLastLoginIP(String andLikeLastLoginIP) {
		this.andLikeLastLoginIP = andLikeLastLoginIP;
	}

	public String getAndLikeLastLoginIP() {
		return this.andLikeLastLoginIP;
	}

	public void setStartLikeLastLoginIP(String startLikeLastLoginIP) {
		this.startLikeLastLoginIP = startLikeLastLoginIP;
	}

	public String getStartLikeLastLoginIP() {
		return this.startLikeLastLoginIP;
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

	public void setAttribute11(String attribute11) {
		this.attribute11 = attribute11;
	}

	public String getAttribute11() {
		return this.attribute11;
	}

	public void setAndLikeAttribute11(String andLikeAttribute11) {
		this.andLikeAttribute11 = andLikeAttribute11;
	}

	public String getAndLikeAttribute11() {
		return this.andLikeAttribute11;
	}

	public void setStartLikeAttribute11(String startLikeAttribute11) {
		this.startLikeAttribute11 = startLikeAttribute11;
	}

	public String getStartLikeAttribute11() {
		return this.startLikeAttribute11;
	}

	public void setAttribute12(String attribute12) {
		this.attribute12 = attribute12;
	}

	public String getAttribute12() {
		return this.attribute12;
	}

	public void setAndLikeAttribute12(String andLikeAttribute12) {
		this.andLikeAttribute12 = andLikeAttribute12;
	}

	public String getAndLikeAttribute12() {
		return this.andLikeAttribute12;
	}

	public void setStartLikeAttribute12(String startLikeAttribute12) {
		this.startLikeAttribute12 = startLikeAttribute12;
	}

	public String getStartLikeAttribute12() {
		return this.startLikeAttribute12;
	}

	public void setAttribute13(String attribute13) {
		this.attribute13 = attribute13;
	}

	public String getAttribute13() {
		return this.attribute13;
	}

	public void setAndLikeAttribute13(String andLikeAttribute13) {
		this.andLikeAttribute13 = andLikeAttribute13;
	}

	public String getAndLikeAttribute13() {
		return this.andLikeAttribute13;
	}

	public void setStartLikeAttribute13(String startLikeAttribute13) {
		this.startLikeAttribute13 = startLikeAttribute13;
	}

	public String getStartLikeAttribute13() {
		return this.startLikeAttribute13;
	}

	public void setAttribute14(String attribute14) {
		this.attribute14 = attribute14;
	}

	public String getAttribute14() {
		return this.attribute14;
	}

	public void setAndLikeAttribute14(String andLikeAttribute14) {
		this.andLikeAttribute14 = andLikeAttribute14;
	}

	public String getAndLikeAttribute14() {
		return this.andLikeAttribute14;
	}

	public void setStartLikeAttribute14(String startLikeAttribute14) {
		this.startLikeAttribute14 = startLikeAttribute14;
	}

	public String getStartLikeAttribute14() {
		return this.startLikeAttribute14;
	}

	public void setAttribute15(String attribute15) {
		this.attribute15 = attribute15;
	}

	public String getAttribute15() {
		return this.attribute15;
	}

	public void setAndLikeAttribute15(String andLikeAttribute15) {
		this.andLikeAttribute15 = andLikeAttribute15;
	}

	public String getAndLikeAttribute15() {
		return this.andLikeAttribute15;
	}

	public void setStartLikeAttribute15(String startLikeAttribute15) {
		this.startLikeAttribute15 = startLikeAttribute15;
	}

	public String getStartLikeAttribute15() {
		return this.startLikeAttribute15;
	}

	public void setAttribute16(String attribute16) {
		this.attribute16 = attribute16;
	}

	public String getAttribute16() {
		return this.attribute16;
	}

	public void setAndLikeAttribute16(String andLikeAttribute16) {
		this.andLikeAttribute16 = andLikeAttribute16;
	}

	public String getAndLikeAttribute16() {
		return this.andLikeAttribute16;
	}

	public void setStartLikeAttribute16(String startLikeAttribute16) {
		this.startLikeAttribute16 = startLikeAttribute16;
	}

	public String getStartLikeAttribute16() {
		return this.startLikeAttribute16;
	}

	@Override
	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> params = new HashMap<String, Object>();

		if (getId() != null) {
			params.put("id", getId());
		}

		if (getAndLikeId() != null) {
			params.put("andLikeId", getAndLikeId());
		}

		if (getStartLikeId() != null) {
			params.put("startLikeId", getStartLikeId());
		}

		if (getUsername() != null) {
			params.put("username", getUsername());
		}

		if (getAndLikeUsername() != null) {
			params.put("andLikeUsername", getAndLikeUsername());
		}

		if (getStartLikeUsername() != null) {
			params.put("startLikeUsername", getStartLikeUsername());
		}

		if (getPassword() != null) {
			params.put("password", getPassword());
		}

		if (getAndLikePassword() != null) {
			params.put("andLikePassword", getAndLikePassword());
		}

		if (getStartLikePassword() != null) {
			params.put("startLikePassword", getStartLikePassword());
		}

		if (getTrueName() != null) {
			params.put("trueName", getTrueName());
		}

		if (getAndLikeTrueName() != null) {
			params.put("andLikeTrueName", getAndLikeTrueName());
		}

		if (getStartLikeTrueName() != null) {
			params.put("startLikeTrueName", getStartLikeTrueName());
		}

		if (getSex() != null) {
			params.put("sex", getSex());
		}

		if (getAndLikeSex() != null) {
			params.put("andLikeSex", getAndLikeSex());
		}

		if (getStartLikeSex() != null) {
			params.put("startLikeSex", getStartLikeSex());
		}

		if (getBirthday() != null) {
			params.put("birthday", getBirthday());
		}

		if (getAndLikeBirthday() != null) {
			params.put("andLikeBirthday", getAndLikeBirthday());
		}

		if (getStartLikeBirthday() != null) {
			params.put("startLikeBirthday", getStartLikeBirthday());
		}

		if (getIdCard() != null) {
			params.put("idCard", getIdCard());
		}

		if (getAndLikeIdCard() != null) {
			params.put("andLikeIdCard", getAndLikeIdCard());
		}

		if (getStartLikeIdCard() != null) {
			params.put("startLikeIdCard", getStartLikeIdCard());
		}

		if (getDepartment() != null) {
			params.put("department", getDepartment());
		}

		if (getAndLikeDepartment() != null) {
			params.put("andLikeDepartment", getAndLikeDepartment());
		}

		if (getStartLikeDepartment() != null) {
			params.put("startLikeDepartment", getStartLikeDepartment());
		}

		if (getDuty() != null) {
			params.put("duty", getDuty());
		}

		if (getAndLikeDuty() != null) {
			params.put("andLikeDuty", getAndLikeDuty());
		}

		if (getStartLikeDuty() != null) {
			params.put("startLikeDuty", getStartLikeDuty());
		}

		if (getGrade() != null) {
			params.put("grade", getGrade());
		}

		if (getAndLikeGrade() != null) {
			params.put("andLikeGrade", getAndLikeGrade());
		}

		if (getStartLikeGrade() != null) {
			params.put("startLikeGrade", getStartLikeGrade());
		}

		if (getTelephone() != null) {
			params.put("telephone", getTelephone());
		}

		if (getAndLikeTelephone() != null) {
			params.put("andLikeTelephone", getAndLikeTelephone());
		}

		if (getStartLikeTelephone() != null) {
			params.put("startLikeTelephone", getStartLikeTelephone());
		}

		if (getEmail() != null) {
			params.put("email", getEmail());
		}

		if (getAndLikeEmail() != null) {
			params.put("andLikeEmail", getAndLikeEmail());
		}

		if (getStartLikeEmail() != null) {
			params.put("startLikeEmail", getStartLikeEmail());
		}

		if (getStatus() != null) {
			params.put("status", getStatus());
		}

		if (getAndLikeStatus() != null) {
			params.put("andLikeStatus", getAndLikeStatus());
		}

		if (getStartLikeStatus() != null) {
			params.put("startLikeStatus", getStartLikeStatus());
		}

		if (getLastLoginTime() != null) {
			params.put("lastLoginTime", getLastLoginTime());
		}

		if (getAndLikeLastLoginTime() != null) {
			params.put("andLikeLastLoginTime", getAndLikeLastLoginTime());
		}

		if (getStartLikeLastLoginTime() != null) {
			params.put("startLikeLastLoginTime", getStartLikeLastLoginTime());
		}

		if (getLastLoginIP() != null) {
			params.put("lastLoginIP", getLastLoginIP());
		}

		if (getAndLikeLastLoginIP() != null) {
			params.put("andLikeLastLoginIP", getAndLikeLastLoginIP());
		}

		if (getStartLikeLastLoginIP() != null) {
			params.put("startLikeLastLoginIP", getStartLikeLastLoginIP());
		}

		if (getAttribute1() != null) {
			params.put("attribute1", getAttribute1());
		}

		if (getAndLikeAttribute1() != null) {
			params.put("andLikeAttribute1", getAndLikeAttribute1());
		}

		if (getStartLikeAttribute1() != null) {
			params.put("startLikeAttribute1", getStartLikeAttribute1());
		}

		if (getAttribute2() != null) {
			params.put("attribute2", getAttribute2());
		}

		if (getAndLikeAttribute2() != null) {
			params.put("andLikeAttribute2", getAndLikeAttribute2());
		}

		if (getStartLikeAttribute2() != null) {
			params.put("startLikeAttribute2", getStartLikeAttribute2());
		}

		if (getAttribute3() != null) {
			params.put("attribute3", getAttribute3());
		}

		if (getAndLikeAttribute3() != null) {
			params.put("andLikeAttribute3", getAndLikeAttribute3());
		}

		if (getStartLikeAttribute3() != null) {
			params.put("startLikeAttribute3", getStartLikeAttribute3());
		}

		if (getAttribute4() != null) {
			params.put("attribute4", getAttribute4());
		}

		if (getAndLikeAttribute4() != null) {
			params.put("andLikeAttribute4", getAndLikeAttribute4());
		}

		if (getStartLikeAttribute4() != null) {
			params.put("startLikeAttribute4", getStartLikeAttribute4());
		}

		if (getAttribute5() != null) {
			params.put("attribute5", getAttribute5());
		}

		if (getAndLikeAttribute5() != null) {
			params.put("andLikeAttribute5", getAndLikeAttribute5());
		}

		if (getStartLikeAttribute5() != null) {
			params.put("startLikeAttribute5", getStartLikeAttribute5());
		}

		if (getAttribute6() != null) {
			params.put("attribute6", getAttribute6());
		}

		if (getAndLikeAttribute6() != null) {
			params.put("andLikeAttribute6", getAndLikeAttribute6());
		}

		if (getStartLikeAttribute6() != null) {
			params.put("startLikeAttribute6", getStartLikeAttribute6());
		}

		if (getAttribute7() != null) {
			params.put("attribute7", getAttribute7());
		}

		if (getAndLikeAttribute7() != null) {
			params.put("andLikeAttribute7", getAndLikeAttribute7());
		}

		if (getStartLikeAttribute7() != null) {
			params.put("startLikeAttribute7", getStartLikeAttribute7());
		}

		if (getAttribute8() != null) {
			params.put("attribute8", getAttribute8());
		}

		if (getAndLikeAttribute8() != null) {
			params.put("andLikeAttribute8", getAndLikeAttribute8());
		}

		if (getStartLikeAttribute8() != null) {
			params.put("startLikeAttribute8", getStartLikeAttribute8());
		}

		if (getAttribute9() != null) {
			params.put("attribute9", getAttribute9());
		}

		if (getAndLikeAttribute9() != null) {
			params.put("andLikeAttribute9", getAndLikeAttribute9());
		}

		if (getStartLikeAttribute9() != null) {
			params.put("startLikeAttribute9", getStartLikeAttribute9());
		}

		if (getAttribute10() != null) {
			params.put("attribute10", getAttribute10());
		}

		if (getAndLikeAttribute10() != null) {
			params.put("andLikeAttribute10", getAndLikeAttribute10());
		}

		if (getStartLikeAttribute10() != null) {
			params.put("startLikeAttribute10", getStartLikeAttribute10());
		}

		if (getAttribute11() != null) {
			params.put("attribute11", getAttribute11());
		}

		if (getAndLikeAttribute11() != null) {
			params.put("andLikeAttribute11", getAndLikeAttribute11());
		}

		if (getStartLikeAttribute11() != null) {
			params.put("startLikeAttribute11", getStartLikeAttribute11());
		}

		if (getAttribute12() != null) {
			params.put("attribute12", getAttribute12());
		}

		if (getAndLikeAttribute12() != null) {
			params.put("andLikeAttribute12", getAndLikeAttribute12());
		}

		if (getStartLikeAttribute12() != null) {
			params.put("startLikeAttribute12", getStartLikeAttribute12());
		}

		if (getAttribute13() != null) {
			params.put("attribute13", getAttribute13());
		}

		if (getAndLikeAttribute13() != null) {
			params.put("andLikeAttribute13", getAndLikeAttribute13());
		}

		if (getStartLikeAttribute13() != null) {
			params.put("startLikeAttribute13", getStartLikeAttribute13());
		}

		if (getAttribute14() != null) {
			params.put("attribute14", getAttribute14());
		}

		if (getAndLikeAttribute14() != null) {
			params.put("andLikeAttribute14", getAndLikeAttribute14());
		}

		if (getStartLikeAttribute14() != null) {
			params.put("startLikeAttribute14", getStartLikeAttribute14());
		}

		if (getAttribute15() != null) {
			params.put("attribute15", getAttribute15());
		}

		if (getAndLikeAttribute15() != null) {
			params.put("andLikeAttribute15", getAndLikeAttribute15());
		}

		if (getStartLikeAttribute15() != null) {
			params.put("startLikeAttribute15", getStartLikeAttribute15());
		}

		if (getAttribute16() != null) {
			params.put("attribute16", getAttribute16());
		}

		if (getAndLikeAttribute16() != null) {
			params.put("andLikeAttribute16", getAndLikeAttribute16());
		}

		if (getStartLikeAttribute16() != null) {
			params.put("startLikeAttribute16", getStartLikeAttribute16());
		}

		return params;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		ManageUser other = (ManageUser) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
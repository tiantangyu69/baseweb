/**
 * 
 */
package org.jgenerator.model.vo;

/**
 * @author LIZHITAO
 * 
 */
public class ManageUserVO {
	private Integer id;
	private String password;
	private String newPassword;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}

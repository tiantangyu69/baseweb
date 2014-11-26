package org.jgenerator.core.model;

import java.io.Serializable;
import java.util.HashMap;

public class Entity implements Serializable {
	private static final long serialVersionUID = 6509066057807634977L;

	private Integer id;

	/**
	 * 操作状态，临时状态，不存到数据库中
	 * <p>
	 * 1.删除
	 * </p>
	 */
	private Integer operaterStatus;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (getId() != null) {
			params.put("id", getId());
		}
		return params;
	}

	public Integer getOperaterStatus() {
		return operaterStatus;
	}

	public void setOperaterStatus(Integer operaterStatus) {
		this.operaterStatus = operaterStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

package org.jgenerator.model;
import java.util.HashMap;
import java.util.List;

import org.jgenerator.core.model.Entity;

public class Department extends Entity{
	/**
	 * @type long
	 * @field serialVersionUID
	 * @state 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer andLikeId;
	private Integer startLikeId; 
	private String name;
	private String andLikeName;
	private String startLikeName; 
	private String departmentNo;
	private String andLikeDepartmentNo;
	private String startLikeDepartmentNo; 
	private String code;
	private String andLikeCode;
	private String startLikeCode; 
	private String url;
	private String andLikeUrl;
	private String startLikeUrl; 
	private Integer parentDepartment;
	private Integer andLikeParentDepartment;
	private Integer startLikeParentDepartment; 
	private Integer sort;
	private Integer andLikeSort;
	private Integer startLikeSort; 
	private String attribute1;
	private String andLikeAttribute1;
	private String startLikeAttribute1; 
	private String attribute2;
	private String andLikeAttribute2;
	private String startLikeAttribute2; 
	private String attribute3;
	private String andLikeAttribute3;
	private String startLikeAttribute3;
	private String state = "closed";
	private List<Department> children;
	private String text;
	private String iconCls;

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
	 
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	
	public String getDepartmentNo() {
		return this.departmentNo;
	}
	
	public void setAndLikeDepartmentNo(String andLikeDepartmentNo) {
		this.andLikeDepartmentNo = andLikeDepartmentNo;
	}
	
	public String getAndLikeDepartmentNo() {
		return this.andLikeDepartmentNo;
	}
	
	public void setStartLikeDepartmentNo(String startLikeDepartmentNo) {
		this.startLikeDepartmentNo = startLikeDepartmentNo;
	}
	
	public String getStartLikeDepartmentNo() {
		return this.startLikeDepartmentNo;
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
	 
	public void setParentDepartment(Integer parentDepartment) {
		this.parentDepartment = parentDepartment;
	}
	
	public Integer getParentDepartment() {
		return this.parentDepartment;
	}
	
	public void setAndLikeParentDepartment(Integer andLikeParentDepartment) {
		this.andLikeParentDepartment = andLikeParentDepartment;
	}
	
	public Integer getAndLikeParentDepartment() {
		return this.andLikeParentDepartment;
	}
	
	public void setStartLikeParentDepartment(Integer startLikeParentDepartment) {
		this.startLikeParentDepartment = startLikeParentDepartment;
	}
	
	public Integer getStartLikeParentDepartment() {
		return this.startLikeParentDepartment;
	}
	 
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public Integer getSort() {
		return this.sort;
	}
	
	public void setAndLikeSort(Integer andLikeSort) {
		this.andLikeSort = andLikeSort;
	}
	
	public Integer getAndLikeSort() {
		return this.andLikeSort;
	}
	
	public void setStartLikeSort(Integer startLikeSort) {
		this.startLikeSort = startLikeSort;
	}
	
	public Integer getStartLikeSort() {
		return this.startLikeSort;
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
	 

	@Override
	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> params = new HashMap<String, Object>();
		
		if(getId() != null){
			params.put("id", getId());
		}
		
		if(getAndLikeId() != null){
			params.put("andLikeId", getAndLikeId());
		}
		
		if(getStartLikeId() != null){
			params.put("startLikeId", getStartLikeId());
		}
		
		if(getName() != null){
			params.put("name", getName());
		}
		
		if(getAndLikeName() != null){
			params.put("andLikeName", getAndLikeName());
		}
		
		if(getStartLikeName() != null){
			params.put("startLikeName", getStartLikeName());
		}
		
		if(getDepartmentNo() != null){
			params.put("departmentNo", getDepartmentNo());
		}
		
		if(getAndLikeDepartmentNo() != null){
			params.put("andLikeDepartmentNo", getAndLikeDepartmentNo());
		}
		
		if(getStartLikeDepartmentNo() != null){
			params.put("startLikeDepartmentNo", getStartLikeDepartmentNo());
		}
		
		if(getCode() != null){
			params.put("code", getCode());
		}
		
		if(getAndLikeCode() != null){
			params.put("andLikeCode", getAndLikeCode());
		}
		
		if(getStartLikeCode() != null){
			params.put("startLikeCode", getStartLikeCode());
		}
		
		if(getUrl() != null){
			params.put("url", getUrl());
		}
		
		if(getAndLikeUrl() != null){
			params.put("andLikeUrl", getAndLikeUrl());
		}
		
		if(getStartLikeUrl() != null){
			params.put("startLikeUrl", getStartLikeUrl());
		}
		
		if(getParentDepartment() != null){
			params.put("parentDepartment", getParentDepartment());
		}
		
		if(getAndLikeParentDepartment() != null){
			params.put("andLikeParentDepartment", getAndLikeParentDepartment());
		}
		
		if(getStartLikeParentDepartment() != null){
			params.put("startLikeParentDepartment", getStartLikeParentDepartment());
		}
		
		if(getSort() != null){
			params.put("sort", getSort());
		}
		
		if(getAndLikeSort() != null){
			params.put("andLikeSort", getAndLikeSort());
		}
		
		if(getStartLikeSort() != null){
			params.put("startLikeSort", getStartLikeSort());
		}
		
		if(getAttribute1() != null){
			params.put("attribute1", getAttribute1());
		}
		
		if(getAndLikeAttribute1() != null){
			params.put("andLikeAttribute1", getAndLikeAttribute1());
		}
		
		if(getStartLikeAttribute1() != null){
			params.put("startLikeAttribute1", getStartLikeAttribute1());
		}
		
		if(getAttribute2() != null){
			params.put("attribute2", getAttribute2());
		}
		
		if(getAndLikeAttribute2() != null){
			params.put("andLikeAttribute2", getAndLikeAttribute2());
		}
		
		if(getStartLikeAttribute2() != null){
			params.put("startLikeAttribute2", getStartLikeAttribute2());
		}
		
		if(getAttribute3() != null){
			params.put("attribute3", getAttribute3());
		}
		
		if(getAndLikeAttribute3() != null){
			params.put("andLikeAttribute3", getAndLikeAttribute3());
		}
		
		if(getStartLikeAttribute3() != null){
			params.put("startLikeAttribute3", getStartLikeAttribute3());
		}
		
		
		return params;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Department> getChildren() {
		return children;
	}

	public void setChildren(List<Department> children) {
		this.children = children;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	 
}
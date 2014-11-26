package org.jgenerator.model;
import org.jgenerator.core.model.Entity;

public class Province extends Entity{
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
	private Integer sort;
	private Integer andLikeSort;
	private Integer startLikeSort; 
	private String remark;
	private String andLikeRemark;
	private String startLikeRemark; 

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
	 
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getRemark() {
		return this.remark;
	}
	
	public void setAndLikeRemark(String andLikeRemark) {
		this.andLikeRemark = andLikeRemark;
	}
	
	public String getAndLikeRemark() {
		return this.andLikeRemark;
	}
	
	public void setStartLikeRemark(String startLikeRemark) {
		this.startLikeRemark = startLikeRemark;
	}
	
	public String getStartLikeRemark() {
		return this.startLikeRemark;
	}
	 
}
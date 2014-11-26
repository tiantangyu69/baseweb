package org.jgenerator.core.util.page;

/**
 * 详情分页工具类，用于存放当前对象，上一个对象，下一个对象
 * 
 * @author www.javaing.net
 * 
 * @param <T>
 */
public class DetailsPager<T> {

	/**
	 * 存放当前对象
	 */
	private T currentObj;

	/**
	 * 存放上一个对象
	 */
	private T preObj;

	/**
	 * 存放下一个对象
	 */
	private T nextObj;

	/**
	 * 创建一个默认的详情分页对象
	 */
	public DetailsPager() {

	}

	/**
	 * 根据当前对象创建一个分页对象
	 * @param currentObj
	 */
	public DetailsPager(T currentObj) {

		this.currentObj = currentObj;

	}

	/**
	 * 根据当前对象，及上一个对象，下一个对象，创建详情分页对象
	 * @param currentObj
	 * @param preObj
	 * @param nextObj
	 */
	public DetailsPager(T currentObj, T preObj, T nextObj) {

		this.currentObj = currentObj;

		this.preObj = preObj;

		this.nextObj = nextObj;

	}

	public T getCurrentObj() {
		return currentObj;
	}

	public void setCurrentObj(T currentObj) {
		this.currentObj = currentObj;
	}

	public T getPreObj() {
		return preObj;
	}

	public void setPreObj(T preObj) {
		this.preObj = preObj;
	}

	public T getNextObj() {
		return nextObj;
	}

	public void setNextObj(T nextObj) {
		this.nextObj = nextObj;
	}

}

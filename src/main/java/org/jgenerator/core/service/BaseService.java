package org.jgenerator.core.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgenerator.core.dao.BaseDao;
import org.jgenerator.core.model.Entity;
import org.jgenerator.core.util.page.Pager;

public interface BaseService<T extends Entity, DaoImpl extends BaseDao<T, Integer>> {
	public Pager<T> queryPage(Map<String, Object> params,
			Integer currentPage, Integer pageSize);

	public Integer selectMaxId();

	public T save(T entity);

	public T fetch(int id);

	public T saveOrUpdate(T entity);
	
	public Integer deleteByCondition(Map<String,Object> condition);

	public void delete(int id);
	
	public DaoImpl getDaoImpl();
	
	public void setDaoImpl(DaoImpl daoImpl);

	public Integer saveOrUpdateAll(T[] entities);

	public Integer saveOrUpdateAll(List<T> entities);

	public Pager<T> queryPage(T entiry, Integer currentPage, Integer pageSize,
			String orderBy, String sortBy);

	public int count(T entiry);

	public T fetch(T entity);

	public List<T> findAll(T entity);

	public Integer deleteByCondition(T entiry);

	public List<T> findAll(Map<String, Object> params);

	public Pager<T> queryDistinctPage(T entity, Integer currentPage, Integer pageSize,
			String orderBy, String sortBy);

	public List<T> findAll(String sqlId, T entity);

	public Integer removeAndSave(T params, List<T> entities);

	public Integer removeAndSave(Map<String, Object> params, List<T> entities);

	public void setNull(Integer id, String fileld);

	/**
	 * FunName:    	    doAllEntities
	 * Description :   	根据实体，对实体进行删除增加或修改操作
	 * @param entities
	 * @Author:         袁鹏(Jeek)
	 * @Create Date: 	2013年7月27日 上午10:04:23
	 */
	public void doAllEntities(List<T> entities);

	public void doAllEntities(T[] entities);

	public Integer maxInt(String fileld);

	public int count(HashMap<String,Object> params);

	public List<T> findAll();

	/**
	 * FunName:    	    only
	 * Description :   	添加或修改保存之前的唯一性验证
	 * @param entity
	 * @return			返回是否可以添加
	 * @Author:         袁鹏(Jeek)
	 * @Create Date: 	2013年8月15日 上午11:23:04
	 */
	public boolean only(T entity);

	public boolean only(Map<String, Object> params);

	public T fetch(Map<String, Object> params);
}

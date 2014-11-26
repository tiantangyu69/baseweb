package org.jgenerator.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jgenerator.core.dao.BaseDao;
import org.jgenerator.core.model.Entity;
import org.jgenerator.core.service.BaseService;
import org.jgenerator.core.util.page.Pager;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseServiceImpl<T extends Entity, DaoImpl extends BaseDao<T, Integer>>
		implements BaseService<T, DaoImpl> {
	@Override
	public Pager<T> queryPage(Map<String, Object> params, Integer currentPage,
			Integer pageSize) {
		return getDaoImpl().queryPage(params, currentPage, pageSize);
	}

	@Override
	public Pager<T> queryDistinctPage(T entity, Integer currentPage,
			Integer pageSize, String orderBy, String sortBy) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (entity != null) {
			params = entity.toHashMap();
		}
		if (StringUtils.isNotEmpty(orderBy)) {
			params.put("orderBy", orderBy);
		}
		if (StringUtils.isNotEmpty(sortBy)) {
			params.put("sortBy", sortBy);
		}
		return getDaoImpl().queryPageBySqlId("distinct", "countDistinct",
				params, currentPage, pageSize);
	}

	@Override
	public Integer selectMaxId() {
		return getDaoImpl().selectIntBySqlId("selectMaxId", null);
	}
	
	@Override
	public Integer maxInt(String fileld) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("tableField", fileld);
		return getDaoImpl().selectIntBySqlId("maxInt", params);
	}

	@Override
	public T save(T entity) {
		return getDaoImpl().save(entity);
	}

	@Override
	public T fetch(int id) {
		return getDaoImpl().fetch(id);
	}

	@Override
	public T fetch(T entity) {
		HashMap<String, Object> params;
		if (null != entity) {
			params = entity.toHashMap();
		} else {
			params = new HashMap<String, Object>();
		}
		return getDaoImpl().selectOneBySqlId("fetchByCondition", params);
	}
	
	@Override
	public T fetch(Map<String, Object> params) {
		if (null == params) {
			params = new HashMap<String, Object>();
		}
		return getDaoImpl().selectOneBySqlId("fetchByCondition", params);
	}
	
	@Override
	public boolean only(T entity){
		HashMap<String, Object> params = entity.toHashMap();
		params.remove("id");
		Integer count = getDaoImpl().count(params);
		if(null == entity.getId()) {
			if(count != null && count > 0) {
				return false;
			}
		}else{
			if(count != null && count > 0) {
				/*数据存在*/
				params.put("id", entity.getId());
				count = getDaoImpl().count(params);
				if(count != null && count > 0) {
					/*为 本条数据，可以进行修改*/
					return true;
				} else {
					/*不是本条数据， 违反唯一性条件，不能进行修改*/
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public boolean only(Map<String, Object> params){
		HashMap<String, Object> condition = new HashMap<String, Object>();
		condition.putAll(params);
		condition.remove("id");
		Integer count = getDaoImpl().count(condition);
		if(null == params.get("id")) {
			if(count != null && count > 0) {
				return false;
			}
		}else{
			if(count != null && count > 0) {
				/*数据存在*/
				condition.put("id", params.get("id"));
				count = getDaoImpl().count(condition);
				if(count != null && count > 0) {
					/*为 本条数据，可以进行修改*/
					return true;
				} else {
					/*不是本条数据， 违反唯一性条件，不能进行修改*/
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void delete(int id) {
		getDaoImpl().deleteById(id);
	}

	@Override
	public T saveOrUpdate(T entity) {
		return getDaoImpl().updateOrSave(entity, entity.getId());
	}
	
	@Override
	public void setNull(Integer id,String fileld){
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("tableField", fileld);
		getDaoImpl().updateBySqlId("setNull",params);
	}

	@Override
	public Integer saveOrUpdateAll(T[] entities) {
		if (null == entities) {
			return 0;
		}
		for (T e : entities) {
			getDaoImpl().updateOrSave(e, e.getId());
		}
		return entities.length;
	}

	@Override
	public Integer saveOrUpdateAll(List<T> entities) {
		if (null == entities) {
			return 0;
		}
		for (T e : entities) {
			getDaoImpl().updateOrSave(e, e.getId());
			continue;
		}
		return entities.size();
	}
	
	@Override
	public void doAllEntities(List<T> entities){
		if (null == entities) {
			return;
		}
		for (T e : entities) {
			if(null != e.getOperaterStatus() && 1 == e.getOperaterStatus()) {
				getDaoImpl().deleteById(e.getId());
				continue;
			}
			getDaoImpl().updateOrSave(e, e.getId());
		}
	}
	
	@Override
	public void doAllEntities(T[] entities){
		if (null == entities) {
			return;
		}
		for (T e : entities) {
			if(null != e.getOperaterStatus() && 1 == e.getOperaterStatus()) {
				getDaoImpl().deleteById(e.getId());
			}
			getDaoImpl().updateOrSave(e, e.getId());
		}
	}
	
	@Override
	public Integer removeAndSave(Map<String, Object> params,List<T> entities) {
		this.deleteByCondition(params);
		if (null == entities) {
			return 0;
		}
		for (T e : entities) {
			getDaoImpl().save(e);
		}
		return entities.size();
	}
	
	@Override
	public Integer removeAndSave(T params,List<T> entities) {
		this.deleteByCondition(params);
		if (null == entities) {
			return 0;
		}
		for (T e : entities) {
			getDaoImpl().save(e);
		}
		return entities.size();
	}

	@Override
	public Integer deleteByCondition(Map<String, Object> params) {
		return getDaoImpl().deleteByCondition(params);
	}

	@Override
	public Integer deleteByCondition(T entiry) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (entiry != null) {
			params = entiry.toHashMap();
		}
		return deleteByCondition(params);
	}

	@Override
	public Pager<T> queryPage(T entiry, Integer currentPage, Integer pageSize,
			String orderBy, String sortBy) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (entiry != null) {
			params = entiry.toHashMap();
		}
		if (StringUtils.isNotEmpty(orderBy)) {
			params.put("orderBy", orderBy);
		}
		if (StringUtils.isNotEmpty(sortBy)) {
			params.put("sortBy", sortBy);
		}
		return getDaoImpl().queryPage(params, currentPage, pageSize);
	}

	@Override
	public List<T> findAll(T entity) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (entity != null) {
			params = entity.toHashMap();
		}
		return findAll(params);
	}
	
	@Override
	public List<T> findAll() {
		HashMap<String, Object> params = new HashMap<String, Object>();
		return findAll(params);
	}
	
	@Override
	public List<T> findAll(String sqlId, T entity) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (entity != null) {
			params = entity.toHashMap();
		}
		return getDaoImpl().queryBySqlId(sqlId, params);
	}

	@Override
	public List<T> findAll(Map<String, Object> params) {
		return getDaoImpl().findAll(params);
	}

	@Override
	public int count(T entiry) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (entiry != null) {
			params = entiry.toHashMap();
		}
		return getDaoImpl().count(params);
	}
	
	@Override
	public int count(HashMap<String,Object> params) {
		return getDaoImpl().count(params);
	}
}

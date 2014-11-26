package org.jgenerator.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.jgenerator.core.dao.BaseDao;
import org.jgenerator.core.util.page.DetailsPager;
import org.jgenerator.core.util.page.Pager;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("baseDaoImpl")
public class BaseDaoImpl<T, PK extends Serializable> extends
		SqlSessionDaoSupport implements BaseDao<T, PK> {

	public static Logger logger = Logger.getLogger(BaseDaoImpl.class);

	private Class<T> entityClass = null;

	/**
	 * 在子类中取entityClass的值
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * 在子类中取entityClass的值
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	public String getEntityName(){
		return entityClass.getName();
	}

	/**
	 * 创建默认构造方法，以取得真正的泛型类型
	 * 
	 * @author javaing(www.javaing.net)
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Class<?> c = getClass();
		Type type = c.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] parameterizedType = ((ParameterizedType) type)
					.getActualTypeArguments();
			entityClass = (Class<T>) parameterizedType[0];
		}
	}

	@Resource(name = "sqlSessionFactory")
	public void setSuperSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	// 保存实体对象
	public T save(T entity) {
		try {
			getSqlSession().insert(
					
					entity.getClass().getName() + "Mapper.insert", entity);
			return entity;
		} catch (RuntimeException re) {
			logger.error("save " + entity.getClass().getName() + " failed :{}",
					re);
			re.printStackTrace();
		}
		return null;
	}

	// 更新
	public void update(T entity) {
		try {
			this.getSqlSession().update(
					entity.getClass().getName() + "Mapper.update", entity);
		} catch (RuntimeException re) {
			logger.error("update " + entity.getClass() + " failed :{}", re);
			re.printStackTrace();
		}
	}
	
	@Override
	public void updateBySqlId(String sqlId, HashMap<String, Object> params) {
		try {
			this.getSqlSession().update(
					entityClass.getName() + "Mapper."+sqlId, params);
		} catch (RuntimeException re) {
			logger.error("update " + entityClass.getName() + " failed :{}", re);
			re.printStackTrace();
		}
	}

	// 删除
	public void delete(T entity) {
		try {
			this.getSqlSession().delete(
					entity.getClass().getName() + "Mapper.delete", entity);
		} catch (RuntimeException re) {
			logger.error("delete " + entity.getClass().getName()
					+ " failed :{}", re);
			re.printStackTrace();
		}
	}

	// 根据id删除某个对象
	public void deleteById(PK id) {
		try {
			this.getSqlSession().delete(
					entityClass.getName() + "Mapper.deleteById", id);
		} catch (RuntimeException re) {
			logger.error("delete " + entityClass.getName() + "failed :{}", re);
			re.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T fetch(String type,PK id) {
		try {
//			if(null == id){
//				return null;
//			}
			return (T)this.getSqlSession().selectOne(
				entityClass.getName() + "Mapper.fetch", id);
		} catch (RuntimeException re) {
			logger.error("fetch " + entityClass.getName() + " failed :{}", re);
			re.printStackTrace();
		}
		return null;
	}


	// 根据id加载某个对象
	@SuppressWarnings("unchecked")
	@Override
	public T fetch(PK id) {
		try {
//			if(null == id){
//				return null;
//			}
			return (T)this.getSqlSession().selectOne(
				entityClass.getName() + "Mapper.fetch", id);
		} catch (RuntimeException re) {
			logger.error("fetch " + entityClass.getName() + " failed :{}", re);
			re.printStackTrace();
		}
		return null;
	}

	// 查找所有的对象
	public List<T> findAll() {
		try {
			return this.getSqlSession().selectList(
					entityClass.getName() + "Mapper.findAll");
		} catch (RuntimeException re) {
			logger.error("findAll " + entityClass.getName() + "failed :{}", re);
			re.printStackTrace();
		}
		return null;
	}

	// 根据条件查找所有的对象
	@Override
	public List<T> findAll(Map<String, Object> params) {
		try {
			return this.getSqlSession().selectList(
					entityClass.getName() + "Mapper.findAll", params);
		} catch (RuntimeException re) {
			logger.error("findAll " + entityClass.getName() + "failed :{}", re);
			re.printStackTrace();
		}
		return null;
	}

	// 根据查询参数，当前页数，每页显示的数目得到分页列表
	@Override
	public Pager<T> queryPage(Map<String, Object> params, Integer currentPage,
			Integer pageSize) {
		Pager<T> pager = new Pager<T>(pageSize, count(params), currentPage);
		try {
			if (params == null) {
				params = new HashMap<String, Object>();
			}
			params.put("beginRow",
					(pager.getCurrentPage() - 1) * pager.getPageSize());
			params.put("pageSize", pager.getPageSize());
			List<T> dataList = this.getSqlSession().selectList(
					entityClass.getName() + "Mapper.queryByCondition", params);
			pager.setDataList(dataList);
			return pager;
		} catch (RuntimeException re) {
			logger.error("findList " + entityClass.getName() + "failed :{}", re);
			re.printStackTrace();
		}
		return null;
	}
	
	// 根据查询参数，当前页数，每页显示的数目得到分页列表
	@Override
	public Pager<T> queryPageBySqlId(String sqlId,String countSqlId, Map<String, Object> params, Integer currentPage,
			Integer pageSize) {
		Pager<T> pager = new Pager<T>(pageSize, selectIntBySqlId(countSqlId, params), currentPage);
		try {
			if (params == null) {
				params = new HashMap<String, Object>();
			}
			params.put("beginRow",
					(pager.getCurrentPage() - 1) * pager.getPageSize());
			params.put("pageSize", pager.getPageSize());
			List<T> dataList = this.queryBySqlId(sqlId, params);
			pager.setDataList(dataList);
			return pager;
		} catch (RuntimeException re) {
			logger.error("findList " + entityClass.getName() + "failed :{}", re);
			re.printStackTrace();
		}
		return null;
	}

	public int count(Map<String, Object> param) {
		try {
			Integer count = this.getSqlSession().selectOne(
					entityClass.getName() + "Mapper.count", param);
			return count;
		} catch (RuntimeException re) {
			logger.error("findList " + entityClass.getName() + "failed :{}", re);
			re.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<T> queryByCondition(Map<String, Object> params) {
		return this.getSqlSession().selectList(
				entityClass.getName() + "Mapper.queryByCondition", params);
	}
	
	@Override
	public List<T> queryBySqlId(String sqlId,Map<String, Object> params) {
		return this.getSqlSession().selectList(
				entityClass.getName() + "Mapper." + sqlId, params);
	}

	@Override
	public T updateOrSave(T t, PK id) {
		if (null != fetch(id)) {
			update(t);
		} else {
			return save(t);
		}
		return null;
	}

	@Override
	public Integer selectMaxId() {
		return getSqlSession().selectOne(
				entityClass.getName() + "Mapper.selectMaxId");
	}

	@Override
	public Integer selectIntBySqlId(String sqlId, Map<String, Object> params) {
		return getSqlSession().selectOne(
				entityClass.getName() + "Mapper." + sqlId, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T selectOneBySqlId(String sqlId, Map<String, Object> params) {
		return (T) getSqlSession().selectOne(
				entityClass.getName() + "Mapper." + sqlId, params);
	}

	@Override
	public Integer deleteByCondition(Map<String, Object> params) {
		return getSqlSession().selectOne(
				entityClass.getName() + "Mapper.deleteByCondition", params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T find(String property, Object value) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put(property, value);
		return (T) getSqlSession().selectOne(
				entityClass.getName() + "Mapper.find", condition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findStaffName(String property, Object value) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put(property, value);
		return (T) getSqlSession()
				.selectOne(
						"com.luyou.platform.project.model.sqlmapper.StaffInfo.findStaffName",
						condition);
	}

	@Override
	public List<T> like(String property, Object value) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put(property, value);
		return getSqlSession().selectList(
				entityClass.getName() + "Mapper.like", condition);
	}

	@Override
	public DetailsPager<T> queryDetailsPage(Map<String, Object> condition, PK id) {
		T currentObj = fetch(id);
		if (currentObj != null) {
			List<PK> ids = getSqlSession().selectList(
					entityClass.getName() + "Mapper.findIds", condition);
			int currentObjIndex = ids.indexOf(id);
			DetailsPager<T> page = new DetailsPager<T>(currentObj);
			if (currentObjIndex > 0)
				page.setPreObj(fetch(ids.get(currentObjIndex - 1)));
			if (currentObjIndex < ids.size() - 1)
				page.setNextObj(fetch(ids.get(currentObjIndex + 1)));
			return page;
		}
		return null;
	}
}
package org.jgenerator.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgenerator.core.util.page.DetailsPager;
import org.jgenerator.core.util.page.Pager;

/**
 * 底层基本的dao的接口
 * 
 * @author javaing(www.javaing.net)
 * 
 * @param <T>
 * @param <PK>
 */
public interface BaseDao<T, PK> {
	public Class<T> getEntityClass();
	/**
	 * 保存对象
	 * 
	 * @param entity
	 * @return 
	 */
	public T save(T entity);

	/**
	 * 更新对象
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 删除对象
	 * 
	 * @param entity
	 */
	public void delete(T entity);

	/**
	 * 根据id删除对象
	 * 
	 * @param id
	 */
	public void deleteById(PK id);
	
	/**
	 * 根据id删除对象
	 * 
	 * @param id
	 */
	public Integer deleteByCondition(Map<String, Object> params);

	/**
	 * 根据id进行对象查询
	 * 
	 * @param id
	 * @return
	 */
	public T fetch(PK id);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<T> findAll();

	/**
	 * 根据pager对象查询相关数据，并封装成为一个pager对象
	 * 
	 * @param params
	 *            查询条件
	 * @param currentPage
	 *            当前页数
	 * @param pageSize
	 *            页面大小
	 * @return 返回Pager对象
	 */
	public Pager<T> queryPage(Map<String, Object> params, Integer currentPage,
			Integer pageSize);

	/**
	 * 根据条件进行查询
	 * 
	 * @param params
	 * @return
	 */
	public List<T> queryByCondition(Map<String, Object> params);

	/**
	 * 根据条件进行数量的查询
	 * 
	 * @param params
	 * @return
	 */
	public int count(Map<String, Object> params);

	/**
	   *  更新或保存，涉及到Mabatis使用的bean只是一个简单的值对象，不能进行id的注解，所以，必须同时指定t的主键值
	 * @param t 要更新或保存的对象
	 * @param id 要更新或保存的对象的id
	 * @return 返回更新或保存的对象。
	 */
	public T updateOrSave(T t, PK id);
	
	/**
	 * 
	 * @param 
	 * @name selectMaxId
	 * @active 查询实体对应表最大Id
	 * @type Integer
	 * @time 上午10:04:05
	 * @exception/throws
	 * @return
	 */
	public Integer selectMaxId();
	
	/**
	 * 根据任意属性和属性值进行对象查询
	 * 
	 * @param property
	 *            进行对象匹配的属性
	 * @param value
	 *            进行对象匹配的属性值
	 * @return
	 */
	public T find(String property, Object value);
	public T findStaffName(String property, Object value);
	
	/**
	 * 根据任意属性和属性值进行对象模糊查询
	 * 
	 * @param property
	 *            进行对象匹配的属性
	 * @param value
	 *            进行对象匹配的模糊属性值
	 * @return
	 */
	public List<T> like(String property, Object value);

	/**
	 * 根据当前id进行详情分页
	 * @param condition 分页查询的条件
	 * @param id 当前id
	 * @return 返回当前对象，上一个对象，下一对象
	 */
	public DetailsPager<T> queryDetailsPage(Map<String, Object> condition, PK id);

	public Integer selectIntBySqlId(String sqlId, Map<String, Object> params);

	public void setEntityClass(Class<T> entityClass);

	public T selectOneBySqlId(String sqlId, Map<String, Object> params);

	public List<T> findAll(Map<String, Object> params);

	public List<T> queryBySqlId(String sqlId, Map<String, Object> params);

	public Pager<T> queryPageBySqlId(String sqlId, String countSqlId,
			Map<String, Object> params, Integer currentPage, Integer pageSize);

	public void updateBySqlId(String sqlId, HashMap<String, Object> params);
	public T fetch(String type, PK id);
}

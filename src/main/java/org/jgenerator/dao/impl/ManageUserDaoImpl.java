package org.jgenerator.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.core.util.page.Pager;
import org.jgenerator.dao.ManageUserDao;
import org.jgenerator.model.ManageUser;
import org.springframework.stereotype.Repository;

@Repository
public class ManageUserDaoImpl extends BaseDaoImpl<ManageUser, Integer>
		implements ManageUserDao {

	@Override
	public Pager<ManageUser> findByDepartmentId(List<String> departments, Integer pageSize, Integer currentPage, Map<String, Object> params) {
		Pager<ManageUser> pager = new Pager<ManageUser>(pageSize, count2(departments, params), currentPage);
		try {
			if (params == null) {
				params = new HashMap<String, Object>();
			}
			params.put("beginRow",
					(pager.getCurrentPage() - 1) * pager.getPageSize());
			params.put("pageSize", pager.getPageSize());
			params.put("departments", departments);
			List<ManageUser> dataList = this.getSqlSession().selectList("org.jgenerator.model.ManageUserMapper.findByDepartmentId", params);
			pager.setDataList(dataList);
			return pager;
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		return null;
	}

	public int count2(List<String> departments, Map<String, Object> params) {
		try {
			params.put("departments", departments);
			Integer count = this.getSqlSession().selectOne("org.jgenerator.model.ManageUserMapper.count2", params);
			return count;
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		return 0;
	}
}
/*******************************************************
 * @author LIZHITAO
 * @date 2013-8-30 上午09:29:08
 * @name ManageMenuUtil.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jgenerator.core.constant.CoreConstant;
import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.ManageMenu;
import org.jgenerator.model.vo.ManageMenuVO;
import org.jgenerator.service.ManageMenuService;
import org.springframework.stereotype.Component;

/**
 * @author LIZHITAO
 *
 */
@Component
public class ManageMenuUtil {
	@Resource
	private ManageMenuService manageMenuServiceImpl;
	/**
	 * @param 
	 * @name isSuperAdmin
	 * @active 是否为超级管理员
	 * @state
	 * @type boolean
	 * @time 上午09:19:51
	 * @exception/throws
	 * @see
	 * @since
	 * @return
	 */
	public boolean isSuperAdmin(String username, String password) {
		if (username.equals(CoreConstant.SUPERADMIN)
				&& password.equals(CoreConstant.SUPERADMINPASSWORD)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @name getSuperAdminMenu
	 * @active 获得超级管理员菜单
	 * @state
	 * @type List<ManageMenuVO>
	 * @time 上午09:25:58
	 * @exception/throws
	 * @see
	 * @since
	 * @return
	 */
	public List<ManageMenuVO> getSuperAdminMenu() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", -1);
		List<ManageMenuVO> list = new ArrayList<ManageMenuVO>();
		Pager<ManageMenu> pager = manageMenuServiceImpl.queryPage(params, 1,
				Integer.MAX_VALUE);
		if (null != pager.getDataList()) {
			for (ManageMenu m : pager.getDataList()) {
				ManageMenuVO mv = new ManageMenuVO();
				Map<String, Object> params2 = new HashMap<String, Object>();
				params2.put("parentId", m.getId());
				Pager<ManageMenu> pager2 = manageMenuServiceImpl.queryPage(
						params2, 1, Integer.MAX_VALUE);
				mv.setManageMenu(m);
				mv.setManageMenuList(pager2.getDataList());
				list.add(mv);
			}
		}
		return list;
	}
}

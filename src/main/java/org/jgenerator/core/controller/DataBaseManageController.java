/*******************************************************
 * @author LIZHITAO
 * @date 2013-8-27 上午10:47:50
 * @name DataBaseController.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.core.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.jgenerator.core.model.SQLAdapter;
import org.jgenerator.core.util.file.PropertyGridUitl;
import org.jgenerator.core.util.file.PropertyUtil;
import org.jgenerator.service.SQLAdapterService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LIZHITAO
 * 
 */
@Controller
@Scope("request")
public class DataBaseManageController {
	public static final String MODULE_PATH = "core/dataBaseManage/";
	@Resource
	private SQLAdapterService sqlAdapterServiceImpl;

	/**
	 * @name manager
	 * @active 数据库维护主页面
	 * @state
	 * @type String
	 * @time 上午11:21:54
	 * @exception/throws
	 * @see
	 * @since
	 * @return
	 */
	@RequestMapping(value = "/manage/dataBaseManage/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	/**
	 * @name dataSourceSettings
	 * @active 数据源配置页面
	 * @state
	 * @type String
	 * @time 上午11:22:11
	 * @exception/throws
	 * @see
	 * @since
	 * @return
	 */
	@RequestMapping(value = "/manage/dataBaseManage/dataSourceSettings")
	public String dataSourceSettings() {
		return MODULE_PATH + "dataSourceSettings";
	}

	@RequestMapping(value = "/manage/dataBaseManage/queryDataSource")
	@ResponseBody
	public Map<String, Object> queryDataSource() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", PropertyGridUitl.getJDBCPropertyGrid().size());
		result.put("rows", PropertyGridUitl.getJDBCPropertyGrid());
		return result;
	}

	@RequestMapping(value = "/manage/dataBaseManage/updateDataSource")
	@ResponseBody
	public String updateDataSource(String settings) {
		PropertyUtil pu = new PropertyUtil();
		pu.setJDBCProperty(settings);
		return "1";
	}
	
	@RequestMapping(value = "/manage/dataBaseManage/toExecuteSQL")
	public String toExecuteSQL(){
		return MODULE_PATH + "executeSQL";
	}
	
	@ResponseBody
	@RequestMapping(value = "/manage/dataBaseManage/executeSQL", method = RequestMethod.POST)
	public String executeSQL(SQLAdapter sqlAdapter){
		sqlAdapterServiceImpl.executeSQL(sqlAdapter);
		return "1";
	}
}

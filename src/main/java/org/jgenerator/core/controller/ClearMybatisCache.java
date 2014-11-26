/*******************************************************
 * @author LIZHITAO
 * @date 2013-9-6 下午02:38:02
 * @name ClearMybatisCache.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.core.controller;

import java.util.Collection;
import java.util.concurrent.locks.Lock;

import javax.annotation.Resource;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LIZHITAO
 * 清空mybatis缓存的控制器
 */
@Controller
@Scope("request")
public class ClearMybatisCache {
	public static final String MODULE_PATH = "core/clearMybatisCache/";
	
	@Resource
	SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 清除缓存页面
	 * @return
	 */
	@RequestMapping(value = "/manage/cache/toClearCache")
	public String toClearCache() {
        return MODULE_PATH + "clearCache";
	}
	
	/**
	 * 清除缓存
	 * @return
	 */
	@RequestMapping(value = "/manage/cache/clearCache", method = RequestMethod.POST)
	@ResponseBody
	public void clearCache() {
		Configuration configuration = sqlSessionFactory.getConfiguration(); 

        Collection<Cache> caches = configuration.getCaches(); 
        for (Cache cache : caches) { 
            Lock w = cache.getReadWriteLock().writeLock();
            w.lock(); 
            try { 
                cache.clear(); 
            } finally { 
                w.unlock(); 
            } 
        }
	}
}

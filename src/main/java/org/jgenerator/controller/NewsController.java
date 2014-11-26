package org.jgenerator.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.DictionaryValue;
import org.jgenerator.model.ManageUser;
import org.jgenerator.model.News;
import org.jgenerator.model.entityArray.NewsArray;
import org.jgenerator.model.vo.Result;
import org.jgenerator.service.DictionaryValueService;
import org.jgenerator.service.NewsService;
import org.sagacity.util.datetime.DateTimeUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class NewsController {
	public static final String MODULE_PATH = "manage/news/";
	public static final String PORTAL_MODULE_PATH = "portal/news/";
	@Resource
	private NewsService newsServiceImpl;
	@Resource
	private DictionaryValueService dictionaryValueServiceImpl;

	@RequestMapping(value = "/manage/news/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/news/query")
	@ResponseBody
	public Map<String, Object> query(News news, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("andLikeTitle", StringUtils.trimToNull(news.getTitle()));
		params.put("itemId", news.getItemId());
		params.put("newsTypeId", news.getNewsTypeId());
		params.put("deployDate", StringUtils.trimToNull(news.getDeployDate()));
		
		Pager<News> pager = newsServiceImpl.queryPage(params, page, rows);
		List<News> list = new ArrayList<News>();
		for(News n : pager.getDataList()){
			Integer typeId = n.getNewsTypeId();
			Integer itemId = n.getItemId();
			if(null != typeId){
				n.setNewsType(dictionaryValueServiceImpl.fetch(typeId));
			}
			if(null != itemId){
				n.setNewsItem(dictionaryValueServiceImpl.fetch(itemId));
			}
			list.add(n);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", list);
		return result;
	}
	
	@RequestMapping(value = "/manage/news/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/news/add")
	@ResponseBody
	public Result add(News news, HttpSession session){
		news.setStatus(0);
		if (StringUtils.isBlank(news.getDeployDate())) {
			news.setDeployDate(DateTimeUtil.getCurrentDate());
		}
		ManageUser user = (ManageUser)session.getAttribute("user");
		news.setDeployUsername(user.getUsername());
		try{
			newsServiceImpl.save(news);
		}catch(Exception e){
			return new Result(Result.ERROR, "数据添加失败！");
		}
		return new Result(Result.SUCCESS, "数据添加成功！");
	}
	
	@RequestMapping(value = "/manage/news/toEdit")
	public String toEdit(Model model, Integer id){
		News news = newsServiceImpl.fetch(id);
		model.addAttribute("news", news);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/news/edit")
	@ResponseBody
	public Result edit(News news){
		if (StringUtils.isBlank(news.getDeployDate())) {
			news.setDeployDate(DateTimeUtil.getCurrentDate());
		}
		try{
			newsServiceImpl.saveOrUpdate(news);
		}catch(Exception e){
			return new Result(Result.ERROR, "数据修改失败！");
		}
		return new Result(Result.SUCCESS, "数据修改成功！");
	}
	
	@RequestMapping(value = "/manage/news/deployNews")
	@ResponseBody
	public String deployNews(Integer id){
		News n = new News();
		n.setId(id);
		n.setStatus(1);
		newsServiceImpl.saveOrUpdate(n);
		return "1";
	}
	
	@RequestMapping(value = "/manage/news/deleteByIds")
	@ResponseBody
	public Result deleteByIds(NewsArray array){
		if(null != array && null != array.getNewsArray()){
			try{
				for(News entity : array.getNewsArray()){
					newsServiceImpl.delete(entity.getId());
				}
			}catch(Exception e){
				return new Result(Result.ERROR, "数据删除失败！");
			}
		}
		return new Result(Result.SUCCESS, "数据删除成功！");
	}
	
	/**
	 * 新闻前台列表页面
	 * @param 
	 * @name list
	 * @active
	 * @state
	 * @type String
	 * @time 下午04:01:31
	 * @exception/throws
	 * @see
	 * @since
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/portal/news/list")
	public String list(Model model, Integer itemId, Integer currentPage){
		// 查询所有新闻类型
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dictionaryTypeId", 1);
		Pager<DictionaryValue> pager = dictionaryValueServiceImpl.queryPage(params, 1, Integer.MAX_VALUE);
		model.addAttribute("newsTypeList", pager.getDataList());
		// 查询所有的新闻
		Map<String, Object> params2 = new HashMap<String, Object>();
		params2.put("itemId", itemId);
		params2.put("status", 1);
		Pager<News> p = newsServiceImpl.queryPage(params2, currentPage, 10);
		model.addAttribute("pager", p);
		return PORTAL_MODULE_PATH + "list";
	}
	
	/**
	 * 新闻前台内容页面
	 * @param 
	 * @name content
	 * @active
	 * @state
	 * @type String
	 * @time 下午04:44:01
	 * @exception/throws
	 * @see
	 * @since
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/portal/news/content")
	public String content(Model model, Integer id){
		News news = newsServiceImpl.fetch(id);
		model.addAttribute("news", news);
		return PORTAL_MODULE_PATH + "content";
	}

	@RequestMapping(value = "/portal/news/newsChannel")
	public String newsChannel(Model model){
		// 查询所有新闻类型
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dictionaryTypeId", 1);
		Pager<DictionaryValue> pager = dictionaryValueServiceImpl.queryPage(params, 1, Integer.MAX_VALUE);
		List<DictionaryValue> list = new ArrayList<DictionaryValue>();
		
		// 查询所有的新闻
		for(DictionaryValue v : pager.getDataList()){
			Map<String, Object> params2 = new HashMap<String, Object>();
			params2.put("itemId", v.getId());
			params2.put("status", 1);
			Pager<News> p = newsServiceImpl.queryPage(params2, 1, 10);
			v.setNewsList(p.getDataList());
			list.add(v);
		}
		Map<String, Object> params222 = new HashMap<String, Object>();
		params222.put("newsTypeId", 4);
		Pager<News> ppp = newsServiceImpl.queryPage(params222, null, 8);
		model.addAttribute("fnewList", ppp.getDataList());
		
		model.addAttribute("newsList", list);
		return PORTAL_MODULE_PATH + "newsChannel";
	}
}
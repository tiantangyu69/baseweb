package org.jgenerator.controller;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import org.jgenerator.model.SystemLogConfig;
import org.jgenerator.model.entityArray.SystemLogConfigArray;
import org.jgenerator.service.SystemLogConfigService;
import org.jgenerator.core.util.page.Pager;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.jgenerator.model.vo.Result;

@Controller
@Scope("request")
public class SystemLogConfigController {
	public static final String MODULE_PATH = "manage/systemLogConfig/";
	@Resource
	private SystemLogConfigService systemLogConfigServiceImpl;

	@RequestMapping(value = "/manage/systemLogConfig/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/systemLogConfig/query")
	@ResponseBody
	public Map<String, Object> query(SystemLogConfig systemLogConfig, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<SystemLogConfig> pager = systemLogConfigServiceImpl.queryPage(systemLogConfig,
				page, rows, orderBy, sortBy);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", pager.getDataList());
		return result;
	}
	
	@RequestMapping(value = "/manage/systemLogConfig/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/systemLogConfig/add")
	@ResponseBody
	public Result add(SystemLogConfig systemLogConfig){
		try{
			systemLogConfigServiceImpl.save(systemLogConfig);
		} catch(Exception e){
			return new Result(Result.ERROR, "数据添加失败！");
		}
		return new Result(Result.SUCCESS, "数据添加成功！");
	}
	
	@RequestMapping(value = "/manage/systemLogConfig/toEdit")
	public String toEdit(Model model, Integer id){
		SystemLogConfig systemLogConfig = systemLogConfigServiceImpl.fetch(id);
		model.addAttribute("systemLogConfig", systemLogConfig);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/systemLogConfig/edit")
	@ResponseBody
	public Result edit(SystemLogConfig systemLogConfig){
		try{
			systemLogConfigServiceImpl.saveOrUpdate(systemLogConfig);
		} catch(Exception e){
			return new Result(Result.ERROR, "数据修改失败！");
		}
		return new Result(Result.SUCCESS, "数据修改成功！");
	}
	
	@RequestMapping(value = "/manage/systemLogConfig/deleteByIds")
	@ResponseBody
	public Result deleteByIds(SystemLogConfigArray array){
		if(null != array && null != array.getSystemLogConfigArray()){
			try{
				for(SystemLogConfig entity : array.getSystemLogConfigArray()){
					systemLogConfigServiceImpl.delete(entity.getId());
				}
			} catch(Exception e){
				return new Result(Result.ERROR, "数据删除失败！");
			}
		}
		return new Result(Result.SUCCESS, "数据删除成功！");
	}
	
	@RequestMapping(value = "/manage/systemLogConfig/queryCombox")
	@ResponseBody
	public List<SystemLogConfig> queryCombox(SystemLogConfig systemLogConfig, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<SystemLogConfig> pager = systemLogConfigServiceImpl.queryPage(systemLogConfig,
				page, Integer.MAX_VALUE, orderBy, sortBy);
		return pager.getDataList();
	}
}
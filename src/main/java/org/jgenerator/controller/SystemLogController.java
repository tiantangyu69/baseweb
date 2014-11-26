package org.jgenerator.controller;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import org.jgenerator.model.SystemLog;
import org.jgenerator.model.entityArray.SystemLogArray;
import org.jgenerator.service.SystemLogService;
import org.jgenerator.core.util.page.Pager;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.jgenerator.model.vo.Result;

@Controller
@Scope("request")
public class SystemLogController {
	public static final String MODULE_PATH = "manage/systemLog/";
	@Resource
	private SystemLogService systemLogServiceImpl;

	@RequestMapping(value = "/manage/systemLog/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/systemLog/query")
	@ResponseBody
	public Map<String, Object> query(SystemLog systemLog, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<SystemLog> pager = systemLogServiceImpl.queryPage(systemLog,
				page, rows, orderBy, sortBy);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", pager.getDataList());
		return result;
	}
	
	@RequestMapping(value = "/manage/systemLog/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/systemLog/add")
	@ResponseBody
	public Result add(SystemLog systemLog){
		try{
			systemLogServiceImpl.save(systemLog);
		} catch(Exception e){
			return new Result(Result.ERROR, "数据添加失败！");
		}
		return new Result(Result.SUCCESS, "数据添加成功！");
	}
	
	@RequestMapping(value = "/manage/systemLog/toEdit")
	public String toEdit(Model model, Integer id){
		SystemLog systemLog = systemLogServiceImpl.fetch(id);
		model.addAttribute("systemLog", systemLog);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/systemLog/edit")
	@ResponseBody
	public Result edit(SystemLog systemLog){
		try{
			systemLogServiceImpl.saveOrUpdate(systemLog);
		} catch(Exception e){
			return new Result(Result.ERROR, "数据修改失败！");
		}
		return new Result(Result.SUCCESS, "数据修改成功！");
	}
	
	@RequestMapping(value = "/manage/systemLog/deleteByIds")
	@ResponseBody
	public Result deleteByIds(SystemLogArray array){
		if(null != array && null != array.getSystemLogArray()){
			try{
				for(SystemLog entity : array.getSystemLogArray()){
					systemLogServiceImpl.delete(entity.getId());
				}
			} catch(Exception e){
				return new Result(Result.ERROR, "数据删除失败！");
			}
		}
		return new Result(Result.SUCCESS, "数据删除成功！");
	}
	
	@RequestMapping(value = "/manage/systemLog/queryCombox")
	@ResponseBody
	public List<SystemLog> queryCombox(SystemLog systemLog, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<SystemLog> pager = systemLogServiceImpl.queryPage(systemLog,
				page, Integer.MAX_VALUE, orderBy, sortBy);
		return pager.getDataList();
	}
}
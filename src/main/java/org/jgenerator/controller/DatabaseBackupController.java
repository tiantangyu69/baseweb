package org.jgenerator.controller;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jgenerator.core.util.database.BackupData;
import org.jgenerator.core.util.page.Pager;
import org.jgenerator.model.DatabaseBackup;
import org.jgenerator.model.entityArray.DatabaseBackupArray;
import org.jgenerator.service.DatabaseBackupService;
import org.sagacity.util.datetime.DateTimeUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class DatabaseBackupController {
	public static final String MODULE_PATH = "manage/databaseBackup/";
	@Resource
	private DatabaseBackupService databaseBackupServiceImpl;
	@Resource
	private BackupData backupData;

	@RequestMapping(value = "/manage/databaseBackup/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/databaseBackup/query")
	@ResponseBody
	public Map<String, Object> query(DatabaseBackup databaseBackup, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<DatabaseBackup> pager = databaseBackupServiceImpl.queryPage(databaseBackup,
				page, rows, orderBy, sortBy);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", pager.getDataList());
		return result;
	}
	
	@RequestMapping(value = "/manage/databaseBackup/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/databaseBackup/add")
	@ResponseBody
	public String add(DatabaseBackup databaseBackup, HttpServletRequest request){
		String filePath = "";// 保存备份文件的路径
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM");
		/** 构建图片保存的目录 **/
		String accessPath = "/dbbackup/" + dateformat.format(new Date())
				+ "/";
		/** 得到图片保存目录的真实路径 **/
		String localPathDir = request.getSession().getServletContext()
				.getRealPath(accessPath);
		/** 根据真实路径创建目录 **/
		File logoSaveFile = new File(localPathDir);
		if (!logoSaveFile.exists()) {
			logoSaveFile.mkdirs();
		}

		/** 使用UUID生成文件名称 **/
		String localFileName = UUID.randomUUID().toString() + ".sql";
		/** 拼成完整的文件保存路径加文件 **/
		filePath = accessPath + localFileName;
		/** 拼成完整的文件保存路径加文件 **/
		String absolutePath = localPathDir + File.separator + localFileName;
		// 备份数据库
		backupData.backupData(absolutePath, request.getSession().getServletContext().getRealPath("/dbbackup/"));
		
		databaseBackup.setAttribute1(filePath);// 设置文件路径
		databaseBackup.setBackupDate(DateTimeUtil.getCurrentDateTime());

		databaseBackupServiceImpl.save(databaseBackup);
		return "1";
	}
	
	@RequestMapping(value = "/manage/databaseBackup/toEdit")
	public String toEdit(Model model, Integer id){
		DatabaseBackup databaseBackup = databaseBackupServiceImpl.fetch(id);
		model.addAttribute("databaseBackup", databaseBackup);
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/databaseBackup/edit")
	@ResponseBody
	public String edit(DatabaseBackup databaseBackup){
		databaseBackupServiceImpl.saveOrUpdate(databaseBackup);
		return "1";
	}
	
	@RequestMapping(value = "/manage/databaseBackup/deleteByIds")
	@ResponseBody
	public String deleteByIds(DatabaseBackupArray array){
		if(null != array && null != array.getDatabaseBackupArray()){
			for(DatabaseBackup entity : array.getDatabaseBackupArray()){
				databaseBackupServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
	
	/**
	 * 还原数据库
	 * @param 
	 * @name restore
	 * @active
	 * @state
	 * @type String
	 * @time 下午02:39:14
	 * @exception/throws
	 * @see
	 * @since
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/manage/databaseBackup/restore")
	@ResponseBody
	public String restore(Integer id, HttpServletRequest request){
		DatabaseBackup databaseBackup = databaseBackupServiceImpl.fetch(id);
		/** 得到备份文件的真实路径 **/
		String absolutePath = request.getSession().getServletContext()
				.getRealPath(databaseBackup.getAttribute1());

		backupData.restoreData(absolutePath);
		return "1";
	}
	
	/**
	 * 导出备份文件
	 * @param 
	 * @name downloadDoc
	 * @active
	 * @state
	 * @type String
	 * @time 下午03:57:50
	 * @exception/throws
	 * @see
	 * @since
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/manage/databaseBackup/exportData", method=RequestMethod.GET)
	@ResponseBody
	public String downloadDoc(HttpServletRequest request,HttpServletResponse response, Integer id){
		DatabaseBackup databaseBackup = databaseBackupServiceImpl.fetch(id);
		try {
			if(databaseBackup.getAttribute1() != null){
				// 获取上传路径
				String absolutePath = request.getSession().getServletContext()
				.getRealPath(databaseBackup.getAttribute1());
				request.setCharacterEncoding("UTF-8");
				response.setContentType("application/x-msdownload;");
				response.setHeader("Content-disposition", "attachment; filename=" + new String(URLEncoder.encode(databaseBackup.getName() + ".sql","UTF-8")));
				response.setHeader("Content-Length", String.valueOf(new File(absolutePath).length()));  
				downloadAttachment(absolutePath, response);
			}else{
				return "work/error";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 读取附件
	 * @param 
	 * @name downloadAttachment
	 * @active
	 * @state
	 * @type void
	 * @time 下午03:57:30
	 * @exception/throws
	 * @see
	 * @since
	 * @param path
	 * @param response
	 */
	private void downloadAttachment(String path,HttpServletResponse response) {
		BufferedInputStream bis = null;   
		BufferedOutputStream bos = null;    
		try {    
			bis = new BufferedInputStream(new FileInputStream(path));   
			bos = new BufferedOutputStream(response.getOutputStream());    
			byte[] buff = new byte[2048];    
			int bytesRead;    
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {     
				bos.write(buff, 0, bytesRead);    
			}   
		} catch (Exception e) { 
			e.printStackTrace();   
		} finally { 
			if (bis != null)
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}    
			if (bos != null)
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}   
		}   
	}
}
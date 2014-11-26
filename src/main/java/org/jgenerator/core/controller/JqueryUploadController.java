/*******************************************************
 * @author LIZHITAO
 * @date 2013-10-28 上午10:50:04
 * @name JqueryUploadController.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.core.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @author LIZHITAO jquery uploadify上传控制器
 * 
 */
@Controller
@Scope("request")
public class JqueryUploadController {
	@RequestMapping(value = "/manage/file/uploadify", method = RequestMethod.POST)
	@ResponseBody
	public String upload(HttpServletRequest request) {
		String filePath = "";// 保存上传文件的路径
		try {
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
			/** 构建图片保存的目录 **/
			String accessPath = "/upload/" + dateformat.format(new Date())
					+ "/";
			/** 得到图片保存目录的真实路径 **/
			String localPathDir = request.getSession().getServletContext()
					.getRealPath(accessPath);
			/** 根据真实路径创建目录 **/
			File logoSaveFile = new File(localPathDir);
			if (!logoSaveFile.exists()) {
				logoSaveFile.mkdirs();
			}

			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();

			Set<String> key = fileMap.keySet();
			Iterator<String> it = key.iterator();
			List<MultipartFile> multipartFiles = new ArrayList<MultipartFile>();
			while (it.hasNext()) {
				multipartFiles.add(fileMap.get(it.next()));
			}

			for (MultipartFile multipartFile : multipartFiles) {
				String suffix = "";
				if (-1 != multipartFile.getOriginalFilename().lastIndexOf(".")) {
					suffix = multipartFile.getOriginalFilename().substring(
							multipartFile.getOriginalFilename()
									.lastIndexOf("."));
				}
				/** 使用UUID生成文件名称 **/
				String localFileName = UUID.randomUUID().toString() + suffix;
				/** 拼成完整的文件保存路径加文件 **/
				String fileName = localPathDir + File.separator + localFileName;
				File file = new File(fileName);
				filePath = accessPath + localFileName;

				try {
					multipartFile.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return filePath;
	}

	@RequestMapping(value = "/portal/file/uploadify", method = RequestMethod.POST)
	@ResponseBody
	public String uploadPic(HttpServletRequest request) {
		String filePath = "";// 保存上传文件的路径
		try {
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
			/** 构建图片保存的目录 **/
			String accessPath = "/upload/" + dateformat.format(new Date())
					+ "/";
			/** 得到图片保存目录的真实路径 **/
			String localPathDir = request.getSession().getServletContext()
					.getRealPath(accessPath);
			/** 根据真实路径创建目录 **/
			File logoSaveFile = new File(localPathDir);
			if (!logoSaveFile.exists()) {
				logoSaveFile.mkdirs();
			}

			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();

			Set<String> key = fileMap.keySet();
			Iterator<String> it = key.iterator();
			List<MultipartFile> multipartFiles = new ArrayList<MultipartFile>();
			while (it.hasNext()) {
				multipartFiles.add(fileMap.get(it.next()));
			}

			for (MultipartFile multipartFile : multipartFiles) {
				String suffix = "";
				if (-1 != multipartFile.getOriginalFilename().lastIndexOf(".")) {
					suffix = multipartFile.getOriginalFilename().substring(
							multipartFile.getOriginalFilename()
									.lastIndexOf("."));
				}
				/** 使用UUID生成文件名称 **/
				String localFileName = UUID.randomUUID().toString() + suffix;
				/** 拼成完整的文件保存路径加文件 **/
				String fileName = localPathDir + File.separator + localFileName;
				File file = new File(fileName);
				filePath = accessPath + localFileName;

				try {
					multipartFile.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return filePath;
	}
}

/**
 * 
 */
package org.jgenerator.core.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.jgenerator.core.model.EasyuiTree;
import org.jgenerator.core.model.EasyuiTreeAttributes;
import org.jgenerator.core.model.FileVO;
import org.jgenerator.core.model.JspContent;
import org.jgenerator.model.vo.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LIZHITAO JSP维护控制器
 */
@Controller
@Scope("request")
public class PageManageController {
	public static final String MODULE_PATH = "core/pageManage/";

	/**
	 * 页面维护管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/jspManage/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	/**
	 * jsp页面维护管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/jspManage/jspManager")
	public String jspManager() {
		return MODULE_PATH + "jspManager";
	}

	/**
	 * 资源文件维护管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/jspManage/resourcesManager")
	public String resourcesManager() {
		return MODULE_PATH + "resourcesManager";
	}

	/**
	 * jsp目录展示页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/jspManage/getFileTree")
	public String getFileTree() {
		return MODULE_PATH + "getFileTree";
	}

	/**
	 * 资源文件目录展示页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/jspManage/getResourcesFileTree")
	public String getResourcesFileTree() {
		return MODULE_PATH + "getResourcesFileTree";
	}

	/**
	 * 显示jsp文件目录树
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/manage/jspManage/files")
	@ResponseBody
	public List<EasyuiTree> getFiles(HttpServletRequest request) {
		// 获得WEB-INF目录的路径
		String path = request.getSession().getServletContext().getRealPath(
				"/WEB-INF")
				+ File.separator + "jsp/";

		List<EasyuiTree> list = new ArrayList<EasyuiTree>();
		File file = new File(path);
		EasyuiTree tree = new EasyuiTree();
		tree.setId(1);
		tree.setText(file.getName());
		tree.setAttributes(new EasyuiTreeAttributes(file.getAbsolutePath()
				+ File.separator + file.getName(), true, "0kb"));
		tree.setChildren(recursiveFile(list, file.getAbsolutePath()));
		list.add(tree);
		return list;
	}

	/**
	 * 显示资源文件文件目录树
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/manage/jspManage/resourcesFiles")
	@ResponseBody
	public List<EasyuiTree> getResourcesFilesFiles(HttpServletRequest request) {
		// 获得WEB-INF目录的路径
		String path = request.getSession().getServletContext().getRealPath(
				"/static/manage");
		String path2 = request.getSession().getServletContext().getRealPath(
				"/static/portal");

		List<EasyuiTree> list = new ArrayList<EasyuiTree>();
		File file = new File(path);
		EasyuiTree tree = new EasyuiTree();
		tree.setId(1);
		tree.setText(file.getName());
		tree.setAttributes(new EasyuiTreeAttributes(file.getAbsolutePath()
				+ File.separator + file.getName(), true, "0kb"));
		tree.setChildren(recursiveFile(list, file.getAbsolutePath()));

		File file2 = new File(path2);
		EasyuiTree tree2 = new EasyuiTree();
		tree2.setId(1);
		tree2.setText(file2.getName());
		tree2.setAttributes(new EasyuiTreeAttributes(file2.getAbsolutePath()
				+ File.separator + file.getName(), true, "0kb"));
		tree2.setChildren(recursiveFile(list, file2.getAbsolutePath()));

		list.add(tree);
		list.add(tree2);
		return list;
	}

	/**
	 * 获取文件列表
	 * 
	 * @param filePath
	 * @return
	 */
	@RequestMapping(value = "/manage/jspManage/fileList")
	public String getFileList(String filePath, Model model) {
		List<FileVO> list = new ArrayList<FileVO>();

		File f = new File(filePath);
		File[] files = f.listFiles();
		if (null != files && files.length > 0) {
			for (File ff : files) {
				FileVO vo = new FileVO();
				vo.setFileName(ff.getName());
				if (StringUtils.contains(ff.getAbsolutePath(), "static")) {
					vo.setFilePath(getRelativePath("static", f
							.getAbsolutePath()));
					model.addAttribute("pageType", "static");
				} else if (StringUtils.contains(ff.getAbsolutePath(), "jsp")) {
					vo.setFilePath(getRelativePath("jsp", f.getAbsolutePath()));
					model.addAttribute("pageType", "jsp");
				}
				vo.setAbsoludePath(f.getAbsolutePath().replaceAll("\\\\", "/"));
				vo.setFileSize((float) ff.length() / 1000 + " kb");
				vo.setFolder(ff.isDirectory());
				list.add(vo);
			}
		}
		if (StringUtils.contains(filePath, "static")) {
			model.addAttribute("dictionaryPath", filePath.substring(filePath
					.lastIndexOf(File.separator + "static" + File.separator),
					filePath.length()));
		} else if (StringUtils.contains(filePath, "jsp")) {
			model.addAttribute("dictionaryPath", filePath.substring(filePath
					.lastIndexOf(File.separator + "jsp" + File.separator),
					filePath.length()));
		}
		model.addAttribute("fileList", list);
		return MODULE_PATH + "fileList";
	}

	/**
	 * 获取指定路径的文件内容
	 * 
	 * @param model
	 * @param filePath
	 * @return
	 */
	@RequestMapping(value = "/manage/jspManage/fileContent")
	public String getFileContent(Model model, JspContent content) {
		File f = new File(content.getFilePath());
		if (f.exists()) {
			try {
				FileInputStream fis = new FileInputStream(f);
				byte[] b = new byte[(int) f.length()];
				fis.read(b);
				fis.close();
				String con = new String(b, "utf-8");
				model.addAttribute("content", con);
				model.addAttribute("fileName", content.getFileName());
				model.addAttribute("filePath", content.getFilePath());
				if (StringUtils.contains(content.getFilePath(), "static")) {
					model.addAttribute("relativeFilePath", content
							.getFilePath().substring(
									content.getFilePath().lastIndexOf(
											File.separator + "static"
													+ File.separator),
									content.getFilePath().length()));
				} else if (StringUtils.contains(content.getFilePath(), "jsp")) {
					model.addAttribute("relativeFilePath", content
							.getFilePath().substring(
									content.getFilePath().lastIndexOf(
											File.separator + "jsp"
													+ File.separator),
									content.getFilePath().length()));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return MODULE_PATH + "fileContent";
	}

	/**
	 * 保存jsp页面
	 * 
	 * @param filePath
	 * @param content
	 * @return
	 */
	@RequestMapping(value = "/manage/jspManage/saveContent", method = RequestMethod.POST)
	@ResponseBody
	public Result saveContent(JspContent con) {

		File f1 = new File(con.getFilePath());
		if (f1.exists()) {
			try {
				FileOutputStream fos = new FileOutputStream(f1);
				byte[] b = con.getContent().getBytes("utf-8");
				fos.write(b);
				fos.close();
			} catch (FileNotFoundException e) {
				return new Result(Result.ERROR, "页面保存失败，未找到该文件！");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new Result(Result.SUCCESS, "页面保存成功！");
	}

	/**
	 * 递归查询文件
	 * 
	 * @param list
	 * @param file
	 * @return
	 */
	private List<EasyuiTree> recursiveFile(List<EasyuiTree> list,
			String filePath) {
		list = new ArrayList<EasyuiTree>();
		File file = new File(filePath);
		if (file.isDirectory() && file.listFiles().length > 0) {
			for (File f : file.listFiles()) {
				EasyuiTree t = new EasyuiTree();
				t.setId(1);
				t.setText(f.getName());
				t.setAttributes(new EasyuiTreeAttributes(file.getAbsolutePath()
						+ File.separator + f.getName(), f.isDirectory(), String
						.valueOf(f.length())));
				t.setChildren(recursiveFile(list, f.getAbsolutePath()
						+ File.separator));
				list.add(t);
			}
		} else {
		}
		return list;
	}

	private String getRelativePath(String containText, String absolutePath) {
		if (StringUtils.contains(absolutePath, containText)) {
			return absolutePath.substring(
					absolutePath.lastIndexOf(File.separator + containText
							+ File.separator), absolutePath.length());
		}
		return "";
	}
}

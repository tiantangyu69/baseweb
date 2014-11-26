/**
 * 
 */
package org.jgenerator.core.model;

/**
 * @author LIZHITAO 文件对象
 */
public class FileVO {
	private String fileName;
	private String filePath;
	private String fileType;
	private String fileSize;
	private boolean folder;
	private String absoludePath;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public boolean isFolder() {
		return folder;
	}

	public void setFolder(boolean folder) {
		this.folder = folder;
	}

	public String getAbsoludePath() {
		return absoludePath;
	}

	public void setAbsoludePath(String absoludePath) {
		this.absoludePath = absoludePath;
	}

}

/**
 * 
 */
package org.jgenerator.core.model;

/**
 * @author LIZHITAO
 * 
 */
public class EasyuiTreeAttributes {
	private String filePath;
	private boolean folder;
	private String fileSize;

	public EasyuiTreeAttributes(String filePath, boolean folder, String fileSize) {
		super();
		this.filePath = filePath;
		this.folder = folder;
		this.fileSize = fileSize;
	}

	public EasyuiTreeAttributes(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public boolean isFolder() {
		return folder;
	}

	public void setFolder(boolean folder) {
		this.folder = folder;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

}

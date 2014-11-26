/**
 * 
 */
package org.jgenerator.model.vo;

/**
 * @author LIZHITAO 控制器中各方法执行后的返回结果
 */
public class Result {
	public static final int ERROR = 0; // 执行失败
	public static final int SUCCESS = 1;// 操作执行成功
	private Integer status; // 执行方法后的状态
	private String msg;// 执行结果描述
	private boolean showDialog = true;// 执行方法后时候弹出窗口

	public Result(Integer status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public Result(Integer status, String msg, boolean showDialog) {
		this.status = status;
		this.msg = msg;
		this.showDialog = showDialog;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Result() {
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

}

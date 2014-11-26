/**
 * 
 */
package org.jgenerator.core.weixin.plugins;

/**
 * @author LIZHITAO 插件接口，规范插件的调用
 */
public interface Plugin {
	/**
	 * 是否调用该插件
	 * 
	 * @param content
	 * @return
	 */
	public boolean isExecute(String content);

	/**
	 * 获取点击插件时的提示信息
	 * 
	 * @return
	 */
	public String getClickTip();

	/**
	 * 获取插件执行结果
	 * 
	 * @param messageContent
	 *            传入接收的消息内容
	 * @return
	 */
	public String getExecuteResult(String messageContent);
}

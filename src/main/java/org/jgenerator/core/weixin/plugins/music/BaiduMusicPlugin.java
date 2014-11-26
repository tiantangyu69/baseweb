/**
 * 
 */
package org.jgenerator.core.weixin.plugins.music;

import net.sf.json.JSONObject;

import org.jgenerator.core.weixin.model.response.Music;
import org.jgenerator.core.weixin.plugins.Plugin;

/**
 * @author LIZHITAO 百度音乐搜索插件
 */
public class BaiduMusicPlugin implements Plugin {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jgenerator.core.weixin.plugins.Plugin#getClickTip()
	 */
	public String getClickTip() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("歌曲点播操作指南").append("\n\n");
		buffer.append("回复：歌曲+歌名").append("\n");
		buffer.append("例如：歌曲存在").append("\n");
		buffer.append("或者：歌曲存在@汪峰").append("\n\n");
		buffer.append("回复“?”显示主菜单");
		return buffer.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jgenerator.core.weixin.plugins.Plugin#getExecuteResult(java.lang.
	 * String)
	 */
	public String getExecuteResult(String messageContent) {
		String keyWord = messageContent.replaceAll("^歌曲[\\+ ~!@#%^-_=]?", "");
		// 如果歌曲名称为空
		if ("".equals(keyWord)) {
			return getUsage();
		} else {
			String[] kwArr = keyWord.split("@");
			// 歌曲名称
			String musicTitle = kwArr[0];
			// 演唱者默认为空
			String musicAuthor = "";
			if (2 == kwArr.length)
				musicAuthor = kwArr[1];

			// 搜索音乐
			Music music = BaiduMusicService
					.searchMusic(musicTitle, musicAuthor);
			// 未搜索到音乐
			if (null == music) {
				return "对不起，没有找到你想听的歌曲<" + musicTitle + ">。";
			} else {
				return JSONObject.fromObject(music).toString();
			}
		}
	}

	/**
	 * 歌曲点播使用指南
	 * 
	 * @return
	 */
	public static String getUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("歌曲点播操作指南").append("\n\n");
		buffer.append("回复：歌曲+歌名").append("\n");
		buffer.append("例如：歌曲存在").append("\n");
		buffer.append("或者：歌曲存在@汪峰").append("\n\n");
		buffer.append("回复“?”显示主菜单");
		return buffer.toString();
	}

	public boolean isExecute(String content) {
		if (content.startsWith("歌曲")) {
			return true;
		}
		return false;
	}
}

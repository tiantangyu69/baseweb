/**
 * 
 */
package org.jgenerator.core.weixin.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jgenerator.core.weixin.model.request.TextAcceptMessage;
import org.jgenerator.core.weixin.model.response.Article;
import org.jgenerator.core.weixin.model.response.NewsReplayMessage;
import org.jgenerator.core.weixin.util.WeiXinMessageUtil;

/**
 * @author LIZHITAO 单图文消息范例
 */
public class ReplaySingleNews {
	public static String getMessage(TextAcceptMessage message) {

		NewsReplayMessage newsMessage = new NewsReplayMessage();
		newsMessage.setToUserName(message.getFromUserName());
		newsMessage.setFromUserName(message.getToUserName());
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(WeiXinMessageUtil.RESP_MESSAGE_TYPE_NEWS);
		List<Article> articleList = new ArrayList<Article>();

		Article article = new Article();
		article.setTitle("java");
		article.setDescription("hello world！");
		article
				.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg");
		article.setUrl("http://blog.csdn.net/lyq8479");
		articleList.add(article);
		// 设置图文消息个数
		newsMessage.setArticleCount(articleList.size());
		// 设置图文消息包含的图文集合
		newsMessage.setArticles(articleList);
		// 将图文消息对象转换成xml字符串
		return WeiXinMessageUtil.newsMessageToXml(newsMessage);
	}
}

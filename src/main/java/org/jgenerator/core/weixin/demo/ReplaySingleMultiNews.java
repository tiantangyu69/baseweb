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
public class ReplaySingleMultiNews {
	public static String getMessage(TextAcceptMessage message) {

		NewsReplayMessage newsMessage = new NewsReplayMessage();
		newsMessage.setToUserName(message.getFromUserName());
		newsMessage.setFromUserName(message.getToUserName());
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(WeiXinMessageUtil.RESP_MESSAGE_TYPE_NEWS);
		List<Article> articleList = new ArrayList<Article>();

		Article article1 = new Article();
		article1.setTitle("微信公众帐号开发教程\n引言");
		article1.setDescription("");
		article1
				.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg");
		article1.setUrl("http://blog.csdn.net/lyq8479/article/details/8937622");

		Article article2 = new Article();
		article2.setTitle("第2篇\n微信公众帐号的类型");
		article2.setDescription("");
		article2.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");
		article2.setUrl("http://blog.csdn.net/lyq8479/article/details/8941577");

		Article article3 = new Article();
		article3.setTitle("第3篇\n开发模式启用及接口配置");
		article3.setDescription("");
		article3.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");
		article3.setUrl("http://blog.csdn.net/lyq8479/article/details/8944988");

		articleList.add(article1);
		articleList.add(article2);
		articleList.add(article3);
		newsMessage.setArticleCount(articleList.size());
		newsMessage.setArticles(articleList);
		return WeiXinMessageUtil.newsMessageToXml(newsMessage);
	}
}

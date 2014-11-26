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
public class ReplaySingleNoPicNews {
	public static String getMessage(TextAcceptMessage message) {

		NewsReplayMessage newsMessage = new NewsReplayMessage();
		newsMessage.setToUserName(message.getFromUserName());
		newsMessage.setFromUserName(message.getToUserName());
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(WeiXinMessageUtil.RESP_MESSAGE_TYPE_NEWS);
		List<Article> articleList = new ArrayList<Article>();

		Article article = new Article();
		article.setTitle("微信公众帐号开发教程Java版");
		// 图文消息中可以使用QQ表情、符号表情
		article
				.setDescription("柳峰，80后，"
						+ WeiXinMessageUtil.emoji(0x1F6B9)
						+ "，微信公众帐号开发经验4个月。为帮助初学者入门，特推出此系列连载教程，也希望借此机会认识更多同行！\n\n目前已推出教程共12篇，包括接口配置、消息封装、框架搭建、QQ表情发送、符号表情发送等。\n\n后期还计划推出一些实用功能的开发讲解，例如：天气预报、周边搜索、聊天功能等。");
		// 将图片置为空
		article.setPicUrl("");
		article.setUrl("http://blog.csdn.net/lyq8479");
		articleList.add(article);
		newsMessage.setArticleCount(articleList.size());
		newsMessage.setArticles(articleList);
		return WeiXinMessageUtil.newsMessageToXml(newsMessage);
	}
}

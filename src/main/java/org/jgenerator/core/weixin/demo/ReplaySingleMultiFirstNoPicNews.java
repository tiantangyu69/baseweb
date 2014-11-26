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
public class ReplaySingleMultiFirstNoPicNews {
	public static String getMessage(TextAcceptMessage message) {

		NewsReplayMessage newsMessage = new NewsReplayMessage();
		newsMessage.setToUserName(message.getFromUserName());
		newsMessage.setFromUserName(message.getToUserName());
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(WeiXinMessageUtil.RESP_MESSAGE_TYPE_NEWS);
		List<Article> articleList = new ArrayList<Article>();

		Article article1 = new Article();
		article1.setTitle("微信公众帐号开发教程Java版");
		article1.setDescription("");
		// 将图片置为空
		article1.setPicUrl("");
		article1.setUrl("http://blog.csdn.net/lyq8479");

		Article article2 = new Article();
		article2.setTitle("第4篇\n消息及消息处理工具的封装");
		article2.setDescription("");
		article2.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");
		article2.setUrl("http://blog.csdn.net/lyq8479/article/details/8949088");

		Article article3 = new Article();
		article3.setTitle("第5篇\n各种消息的接收与响应");
		article3.setDescription("");
		article3.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");
		article3.setUrl("http://blog.csdn.net/lyq8479/article/details/8952173");

		Article article4 = new Article();
		article4.setTitle("第6篇\n文本消息的内容长度限制揭秘");
		article4.setDescription("");
		article4.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");
		article4.setUrl("http://blog.csdn.net/lyq8479/article/details/8967824");

		articleList.add(article1);
		articleList.add(article2);
		articleList.add(article3);
		articleList.add(article4);
		newsMessage.setArticleCount(articleList.size());
		newsMessage.setArticles(articleList);
		return WeiXinMessageUtil.newsMessageToXml(newsMessage);
	}
}

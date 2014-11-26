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
public class ReplaySingleMultiLastNoPicNews {
	public static String getMessage(TextAcceptMessage message) {

		NewsReplayMessage newsMessage = new NewsReplayMessage();
		newsMessage.setToUserName(message.getFromUserName());
		newsMessage.setFromUserName(message.getToUserName());
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(WeiXinMessageUtil.RESP_MESSAGE_TYPE_NEWS);
		List<Article> articleList = new ArrayList<Article>();

		Article article1 = new Article();
		article1.setTitle("第7篇\n文本消息中换行符的使用");
		article1.setDescription("");
		article1
				.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg");
		article1.setUrl("http://blog.csdn.net/lyq8479/article/details/9141467");

		Article article2 = new Article();
		article2.setTitle("第8篇\n文本消息中使用网页超链接");
		article2.setDescription("");
		article2.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");
		article2.setUrl("http://blog.csdn.net/lyq8479/article/details/9157455");

		Article article3 = new Article();
		article3.setTitle("如果觉得文章对你有所帮助，请通过博客留言或关注微信公众帐号xiaoqrobot来支持柳峰！");
		article3.setDescription("");
		// 将图片置为空
		article3.setPicUrl("");
		article3.setUrl("http://blog.csdn.net/lyq8479");

		articleList.add(article1);
		articleList.add(article2);
		articleList.add(article3);
		newsMessage.setArticleCount(articleList.size());
		newsMessage.setArticles(articleList);
		return WeiXinMessageUtil.newsMessageToXml(newsMessage);
	}
}

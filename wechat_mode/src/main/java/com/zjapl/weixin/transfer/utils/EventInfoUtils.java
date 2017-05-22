package com.zjapl.weixin.transfer.utils;

import java.util.Date;
import java.util.List;

import com.zjapl.weixin.transfer.bean.EventInfo;
import com.zjapl.weixin.transfer.bean.NewsEventInfo;

/**
 * 消息回复的工具类
 * @author yangb
 *
 */
public class EventInfoUtils {

	/**
	 * 获取文本消息的消息内容
	 * @param req
	 * @return
	 */
	public static String getTextContent(EventInfo req){
		return req.getContent();
	}
	
	/**
	 * 回复文本消息
	 * @param req
	 * @param content 消息内容.
	 * @return
	 */
	public static EventInfo replayText(EventInfo req, String content) {
		String server = req.getToUserName();
		String openid = req.getFromUserName();
		
		EventInfo resp = new EventInfo();
		resp.setToUserName(openid);
		resp.setFromUserName(server);
		resp.setMsgType("text");
		resp.setCreateTime(new Date().getTime()+"");
		resp.setContent(content);
		return resp;
	}
	

	/**
	 * 回复图文消息
	 * @param req
	 * @param item 图文消息的条目
	 * @return
	 */
	public static EventInfo replayNews(EventInfo req, List<NewsEventInfo.Item> articles) {
		String server = req.getToUserName();
		String openid = req.getFromUserName();
		
		NewsEventInfo resp = new NewsEventInfo();
		resp.setToUserName(openid);
		resp.setFromUserName(server);
		resp.setMsgType("news");
		resp.setCreateTime(new Date().getTime()+"");
		
		resp.setArticleCount(articles.size());
		resp.setArticles(articles);
		
		return resp;
	}
}

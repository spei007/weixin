package com.css.swordfish.weixin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.css.swordfish.weixin.message.res.Article;
import com.css.swordfish.weixin.message.res.NewsMessage;
import com.css.swordfish.weixin.message.res.TextMessage;
import com.css.swordfish.weixin.util.MessageUtil;

/**
 * Description：
 * <p>
 * Copyright: Copyright (c) 2014中国软件与技术服务股份有限公司
 * </p>
 * <p>
 * Company: 中国软件与技术服务股份有限公司
 * </p>
 * <p>
 * 模块: 门户权限
 * </p>
 * @author 石佩
 * @version 1.0
 * 2014-2-17-下午4:23:23
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class CoreService {
	
	/** 
     * 处理微信发来的请求 
     *  
     * @param request 
     * @return 
     */  
    public static String processRequest(HttpServletRequest request) {  
    	 String respMessage = null;  
         try {  
             // xml请求解析  
             Map<String, String> requestMap = MessageUtil.parseXml(request);  
   
             // 发送方帐号（open_id）  
             String fromUserName = requestMap.get("FromUserName");  
             // 公众帐号  
             String toUserName = requestMap.get("ToUserName");  
             // 消息类型  
             String msgType = requestMap.get("MsgType");  
   
             // 默认回复此文本消息  
             TextMessage textMessage = new TextMessage();  
             textMessage.setToUserName(fromUserName);  
             textMessage.setFromUserName(toUserName);  
             textMessage.setCreateTime(new Date().getTime());  
             textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
             textMessage.setFuncFlag(0);  
             // 由于href属性值必须用双引号引起，这与字符串本身的双引号冲突，所以要转义  
             textMessage.setContent(getMainMenu());  
             // 将文本消息对象转换成xml字符串  
             respMessage = MessageUtil.textMessageToXml(textMessage);  
   
             // 文本消息  
             if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
                 // 接收用户发送的文本消息内容  
                 String content = requestMap.get("Content");  
   
                 // 创建图文消息  
                 NewsMessage newsMessage = new NewsMessage();  
                 newsMessage.setToUserName(fromUserName);  
                 newsMessage.setFromUserName(toUserName);  
                 newsMessage.setCreateTime(new Date().getTime());  
                 newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
                 newsMessage.setFuncFlag(0);  
   
                 List<Article> articleList = new ArrayList<Article>();  
                 // 单图文消息  
                 if ("1".equals(content)) {  
                     Article article = new Article();  
                     article.setTitle("微信测试");  
                     article.setDescription("微信接口测试");  
                     article.setPicUrl("http://www.baidu.com/img/bdlogo.gif");  
                     article.setUrl("http://www.baidu.com");  
                     articleList.add(article);  
                     // 设置图文消息个数  
                     newsMessage.setArticleCount(articleList.size());  
                     // 设置图文消息包含的图文集合  
                     newsMessage.setArticles(articleList);  
                     // 将图文消息对象转换成xml字符串  
                     respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                 }  
                 // 单图文消息---不含图片  
                 else if ("2".equals(content)) {  
                     Article article = new Article();  
                     article.setTitle("微信测试");  
                     // 图文消息中可以使用QQ表情、符号表情  
                     article.setDescription("表情测试" + emoji(0x1F6B9)  
                             + "。。。。。。。。");  
                     // 将图片置为空  
                     article.setPicUrl("");  
                     article.setUrl("http://www.baidu.com");  
                     articleList.add(article);  
                     newsMessage.setArticleCount(articleList.size());  
                     newsMessage.setArticles(articleList);  
                     respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                 }  
                 // 多图文消息  
                 else if ("3".equals(content)) {  
                     Article article1 = new Article();  
                     article1.setTitle("微信换行测试\n第二行");  
                     article1.setDescription("");  
                     article1.setPicUrl("http://www.baidu.com/img/bdlogo.gif");  
                     article1.setUrl("http://www.baidu.com");  
   
                     Article article2 = new Article();  
                     article2.setTitle("第2篇\n微信公众帐号的类型");  
                     article2.setDescription("");  
                     article2.setPicUrl("http://www.baidu.com/img/bdlogo.gif");  
                     article2.setUrl("http://www.baidu.com");  
   
                     Article article3 = new Article();  
                     article3.setTitle("第3篇\n开发模式启用及接口配置");  
                     article3.setDescription("");  
                     article3.setPicUrl("http://www.baidu.com/img/bdlogo.gif");  
                     article3.setUrl("http://www.baidu.com");  
   
                     articleList.add(article1);  
                     articleList.add(article2);  
                     articleList.add(article3);  
                     newsMessage.setArticleCount(articleList.size());  
                     newsMessage.setArticles(articleList);  
                     respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                 }  
                 // 多图文消息---首条消息不含图片  
                 else if ("4".equals(content)) {  
                     Article article1 = new Article();  
                     article1.setTitle("微信公众帐号开发教程Java版");  
                     article1.setDescription("");  
                     // 将图片置为空  
                     article1.setPicUrl("");  
                     article1.setUrl("http://www.baidu.com");  
   
                     Article article2 = new Article();  
                     article2.setTitle("第4篇\n消息及消息处理工具的封装");  
                     article2.setDescription("");  
                     article2.setPicUrl("http://www.baidu.com/img/bdlogo.gif");  
                     article2.setUrl("http://www.baidu.com");  
   
                     Article article3 = new Article();  
                     article3.setTitle("第5篇\n各种消息的接收与响应");  
                     article3.setDescription("");  
                     article3.setPicUrl("http://www.baidu.com/img/bdlogo.gif");  
                     article3.setUrl("http://www.baidu.com");  
   
                     Article article4 = new Article();  
                     article4.setTitle("第6篇\n文本消息的内容长度限制揭秘");  
                     article4.setDescription("");  
                     article4.setPicUrl("http://www.baidu.com/img/bdlogo.gif");  
                     article4.setUrl("http://www.baidu.com");  
   
                     articleList.add(article1);  
                     articleList.add(article2);  
                     articleList.add(article3);  
                     articleList.add(article4);  
                     newsMessage.setArticleCount(articleList.size());  
                     newsMessage.setArticles(articleList);  
                     respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                 }  
                 // 多图文消息---最后一条消息不含图片  
                 else if ("5".equals(content)) {  
                     Article article1 = new Article();  
                     article1.setTitle("第7篇\n文本消息中换行符的使用");  
                     article1.setDescription("");  
                     article1.setPicUrl("http://www.baidu.com/img/bdlogo.gif");  
                     article1.setUrl("http://www.baidu.com/");  
   
                     Article article2 = new Article();  
                     article2.setTitle("第8篇\n文本消息中使用网页超链接");  
                     article2.setDescription("");  
                     article2.setPicUrl("http://www.baidu.com/img/bdlogo.gif");  
                     article2.setUrl("http://www.baidu.com/");  
   
                     Article article3 = new Article();  
                     article3.setTitle("如果觉得文章对你有所帮助，请通过博客留言或关注微信公众帐号xiaoqrobot来支持柳峰！");  
                     article3.setDescription("");  
                     // 将图片置为空  
                     article3.setPicUrl("");  
                     article3.setUrl("http://www.baidu.com");  
   
                     articleList.add(article1);  
                     articleList.add(article2);  
                     articleList.add(article3);  
                     newsMessage.setArticleCount(articleList.size());  
                     newsMessage.setArticles(articleList);  
                     respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                 }
             }  
         } catch (Exception e) {  
             e.printStackTrace();  
         }  
         return respMessage;  
     }  
   
     /** 
      * emoji表情转换(hex -> utf-16) 
      *  
      * @param hexEmoji 
      * @return 
      */  
     public static String emoji(int hexEmoji) {  
         return String.valueOf(Character.toChars(hexEmoji));  
     } 
     
     public static String getMainMenu() {  
    	    StringBuffer buffer = new StringBuffer();
    	    buffer.append("欢迎访问<a href=\"http://www.baidu.com\">百度搜索</a>!").append("\n");    	    
    	    buffer.append("我是微信机器人，请回复数字选择服务：").append("\n\n");  
    	    buffer.append("1  单图文").append("\n");  
    	    buffer.append("2  多图文1").append("\n");  
    	    buffer.append("3  多图文2").append("\n");  
    	    buffer.append("4  多图文3").append("\n");  
    	    buffer.append("5  多图文4").append("\n");    	    
    	    return buffer.toString();  
    	}  


}

package com.css.swordfish.weixin.message.res;

import java.util.List;

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
 * 2014-2-17-下午4:07:28
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class NewsMessage extends BaseMessage {
	// 图文消息个数，限制为10条以内  
    private int ArticleCount;  
    // 多条图文消息信息，默认第一个item为大图  
    private List<Article> Articles;  
  
    public int getArticleCount() {  
        return ArticleCount;  
    }  
  
    public void setArticleCount(int articleCount) {  
        ArticleCount = articleCount;  
    }  
  
    public List<Article> getArticles() {  
        return Articles;  
    }  
  
    public void setArticles(List<Article> articles) {  
        Articles = articles;  
    }  
}

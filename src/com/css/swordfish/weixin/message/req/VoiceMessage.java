package com.css.swordfish.weixin.message.req;

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
 * 2014-2-17-下午4:00:20
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class VoiceMessage extends BaseMessage {  
    // 媒体ID  
    private String MediaId;  
    // 语音格式  
    private String Format;  
  
    public String getMediaId() {  
        return MediaId;  
    }  
  
    public void setMediaId(String mediaId) {  
        MediaId = mediaId;  
    }  
  
    public String getFormat() {  
        return Format;  
    }  
  
    public void setFormat(String format) {  
        Format = format;  
    }  
}  
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
 * 2014-2-17-下午4:00:38
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class LocationMessage extends BaseMessage{
	// 地理位置维度  
    private String Location_X;  
    // 地理位置经度  
    private String Location_Y;  
    // 地图缩放大小  
    private String Scale;  
    // 地理位置信息  
    private String Label;  
  
    public String getLocation_X() {  
        return Location_X;  
    }  
  
    public void setLocation_X(String location_X) {  
        Location_X = location_X;  
    }  
  
    public String getLocation_Y() {  
        return Location_Y;  
    }  
  
    public void setLocation_Y(String location_Y) {  
        Location_Y = location_Y;  
    }  
  
    public String getScale() {  
        return Scale;  
    }  
  
    public void setScale(String scale) {  
        Scale = scale;  
    }  
  
    public String getLabel() {  
        return Label;  
    }  
  
    public void setLabel(String label) {  
        Label = label;  
    }  
}


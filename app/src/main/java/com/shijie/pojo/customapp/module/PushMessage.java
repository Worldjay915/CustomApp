package com.shijie.pojo.customapp.module;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.customapp.module
 * 创建者:  zsj
 * 创建事件: 2017/5/21 9:35
 * 描述:  极光推送消息实体，包含所有的数据字段
 */

public class PushMessage extends BaseModel{

    // 消息类型
    public String messageType = null;
    // 连接
    public String messageUrl = null;
    // 详情内容
    public String messageContent = null;

}

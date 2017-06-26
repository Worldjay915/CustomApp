package com.shijie.pojo.customapp.module.chat;

import com.shijie.pojo.customapp.module.BaseModel;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.customapp.module.chat
 * 创建者:  zsj
 * 创建事件: 2017/6/17 10:17
 * 描述: 聊天实体
 */

public class ChatData extends BaseModel{

    private  String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

package com.shijie.pojo.customapp.module.recommand;

import com.shijie.pojo.androidsdk.module.moniter.Monitor;
import com.shijie.pojo.androidsdk.module.moniter.emevent.EMEvent;

import java.util.ArrayList;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.customapp.module.recommand
 * 创建者:  zsj
 * 创建事件: 2017/5/11 17:02
 * 描述:  搜索实体
 */

public class RecommandBodyValue {

    public int type;
    public String logo;
    public String title;
    public String info;
    public String price;
    public String text;
    public String site;
    public String from;
    public String zan;
    public ArrayList<String> url;

    //视频专用
    public String thumb;
    public String resource;
    public String resourceID;
    public String adid;
    public ArrayList<Monitor> startMonitor;
    public ArrayList<Monitor> middleMonitor;
    public ArrayList<Monitor> endMonitor;
    public String clickUrl;
    public ArrayList<Monitor> clickMonitor;
    public EMEvent event;

}

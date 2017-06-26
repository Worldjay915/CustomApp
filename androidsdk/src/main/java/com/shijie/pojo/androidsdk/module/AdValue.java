package com.shijie.pojo.androidsdk.module;

import com.shijie.pojo.androidsdk.module.moniter.Monitor;
import com.shijie.pojo.androidsdk.module.moniter.emevent.EMEvent;

import java.util.ArrayList;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.androidsdk.module
 * 创建者:  zsj
 * 创建事件: 2017/5/15 9:09
 * 描述: 广告json value节点， 节点名字记得修改一下
 */

public class AdValue  {

    public String resourceID;
    public String adid;
    public String resource;
    public String thumb;
    public ArrayList<Monitor> startMonitor;
    public ArrayList<Monitor> middleMonitor;
    public ArrayList<Monitor> endMonitor;
    public String clickUrl;
    public ArrayList<Monitor> clickMonitor;
    public EMEvent event;
    public String type;

}

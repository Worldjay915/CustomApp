package com.shijie.pojo.customapp.module.course;


import com.shijie.pojo.customapp.module.BaseModel;

/**
 * @author: vision
 * @function:
 * @date: 16/9/2
 */
public class CourseCommentValue extends BaseModel {

    public String text;
    public String name;
    public String logo;
    public int type;
    public String userId; //评论所属用户ID
}
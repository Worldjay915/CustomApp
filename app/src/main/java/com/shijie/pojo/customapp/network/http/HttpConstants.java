package com.shijie.pojo.customapp.network.http;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.customapp.network.http
 * 创建者:  zsj
 * 创建事件: 2017/5/11 16:41
 * 描述:   所有请求相关地址
 */

public class HttpConstants {


   //http://47.93.237.249:8080/customApp_server/index.jsp
   private static final String ROOT_URL = "http://47.93.237.249:8080";
   public static String MINA_IP = "47.93.237.249";
    /**
     * 请求本地产品列表
     */
    public static String PRODUCT_LIST = ROOT_URL + "/fund/search.php";

    /**
     * 本地产品列表更新时间请求
     */
    public static String PRODUCT_LATESAT_UPDATE = ROOT_URL + "/fund/upsearch.php";

    /**
     * 登陆接口
     */
    //public static String LOGIN = ROOT_URL + "/user/login_phone.php";
    public static String LOGIN = ROOT_URL + "/customApp_server/UserServlet";
    /**
     * 检查更新接口
     */
    //public static String CHECK_UPDATE = ROOT_URL + "/config/check_update.php";
    public static String CHECK_UPDATE = ROOT_URL + "/customApp_server/UpdateServlet";
    /**
     * 首页产品请求接口
     */
   // public static String HOME_RECOMMAND = ROOT_URL + "/product/home_recommand.php";
    public static String HOME_RECOMMAND = ROOT_URL + "/customApp_server/HomeServlet";
    /**
     * 课程详情接口
     */
   // public static String COURSE_DETAIL = ROOT_URL + "/product/course_detail.php";
    public static String COURSE_DETAIL = ROOT_URL + "/customApp_server/CourseDetailServlet";

}

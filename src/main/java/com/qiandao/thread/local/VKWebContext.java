package com.qiandao.thread.local;

import com.qiandao.model.Student;

/**
 * @author fengxin2
 */
public class VKWebContext {

    private static ThreadLocal<Student> userContext = new ThreadLocal();

    private static ThreadLocal<String> wxUserContext = new ThreadLocal();


    public static void setUserContext(Student vkUser) {
        userContext.set(vkUser);
    }

    public static Student getUserContext() {
        return userContext.get();
    }

    public static void clearUserContext() {
        userContext.remove();
    }

    public static void setWxUserContext(String openId) {
        wxUserContext.set(openId);
    }

    public static String getOpenId() {
        return wxUserContext.get();
    }

    public static void clearWxUserContext() {
        wxUserContext.remove();
    }

    public static Boolean isNoAuth(){
        if (userContext.get() == null && wxUserContext.get() == null) {
            return true;
        }
        return false;
    }


}


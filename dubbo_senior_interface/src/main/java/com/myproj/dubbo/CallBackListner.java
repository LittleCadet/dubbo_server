package com.myproj.dubbo;

/**
 * @author shenxie
 * @date 2020/7/8
 */
public interface CallBackListner {

    /**
     * 消费方被回调的方法
     * @param msg
     */
    void changed(String msg);
}

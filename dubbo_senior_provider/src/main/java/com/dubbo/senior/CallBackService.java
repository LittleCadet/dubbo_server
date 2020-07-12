package com.dubbo.senior;

/**
 * @author shenxie
 * @date 2020/7/8
 */
public interface CallBackService  {

    /**
     * 服务提供方暴露的接口
     * @param key
     * @param callBackListner
     */
    void addListener(String key , CallBackListner callBackListner);
}

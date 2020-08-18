package com.myproj.dubbo;

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

    /**
     * 用于测试隐式参数
     */
    void hideParam();

    /**
     * 用于测试泛化调用
     * @param key
     * @return
     */
    String showInfo(String key);
}

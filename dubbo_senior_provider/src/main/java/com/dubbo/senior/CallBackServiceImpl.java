package com.dubbo.senior;

import com.alibaba.dubbo.rpc.RpcContext;
import com.myproj.dubbo.CallBackListner;
import com.myproj.dubbo.CallBackService;
import sun.nio.cs.ext.MacThai;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author shenxie
 * @date 2020/7/8
 */
public class CallBackServiceImpl implements CallBackService {

    private final Map<String , CallBackListner> listners = new ConcurrentHashMap<>();

    /**
     * 服务端每隔5s 回调一次客户端
     */
    public CallBackServiceImpl(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("==========回调运行中==========");
                    listners.forEach((s, callBackListner) -> callBackListner.changed(getChanged(s)));
                    //listners.forEach((s , callBackListner) -> getInfo(callBackListner));
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
    }

    @Override
    public void addListener(String key, CallBackListner callBackListner) {
        listners.put(key , callBackListner);
    }

    @Override
    public void hideParam() {
        System.out.println(String.format("====================获得隐式参数：paramV3 : %s" , RpcContext.getContext().getAttachment("paramV3")));
        System.out.println(String.format("====================获得隐式参数：paramV4 : %s" ,RpcContext.getContext().getAttachment("paramV4")));


        //用于泛化调用
        System.out.println(String.format("====================获得隐式参数：paramV5 : %s" ,RpcContext.getContext().getAttachment("paramV5")));

        //用于TpsLimitFilter
        System.out.println(String.format("====================获得隐式参数：filter : %s" ,RpcContext.getContext().getAttachment("filter")));
    }

    @Override
    public String showInfo(String key) {
        System.out.println("接受到来自消费者的泛化调用， key:" + key);
        return String.format("这是来自生产者的响应 ， key:%s" , key);
    }

    @Override
    public CompletableFuture<String> getInfo() {
        return CompletableFuture.supplyAsync(() -> {
            return String.format("============当前线程：%s , 调用成功 : %s==============" , Thread.currentThread().getName() , (int) (Math.random() * 1000));
        });
    }

    private String getChanged(String key){
        return String.format("%s changed : " , key) + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    private void getInfo(CallBackListner callBackListner){

        if(null != RpcContext.getContext().getAttachment("paramV1")){
            callBackListner.changed(getChanged(RpcContext.getContext().getAttachment("paramV1")));
        }else if(null != RpcContext.getContext().getAttachment("paramV2")){
            callBackListner.changed(getChanged(RpcContext.getContext().getAttachment("paramV2")));
        }
    }
}

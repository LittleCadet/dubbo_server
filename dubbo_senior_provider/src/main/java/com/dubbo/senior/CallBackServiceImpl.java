package com.dubbo.senior;

import com.myproj.dubbo.CallBackListner;
import com.myproj.dubbo.CallBackService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
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

    private String getChanged(String key){
        return String.format("%s changed : " , key) + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}

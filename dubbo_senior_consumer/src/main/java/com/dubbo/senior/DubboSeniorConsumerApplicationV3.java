package com.dubbo.senior;

import com.myproj.dubbo.CallBackService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shenxie
 * @date 2020/7/12
 */
public class DubboSeniorConsumerApplicationV3 {

    /**
     * 用于测试 TpsLimitFilter
     * @param args
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();

        System.out.println("=============DubboSeniorConsumerApplicationV3 start============");
        CallBackService callBackService = context.getBean("callbackService" , CallBackService.class);

        RpcContext.getContext().setAttachment("filter" , "TpsLimitFilter");

        callBackService.hideParam();
        callBackService.hideParam();
        callBackService.hideParam();
        callBackService.hideParam();
        callBackService.hideParam();
        callBackService.hideParam();

    }
}

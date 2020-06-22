package com.dubbo.app.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ProviderApplication {
    /**
     * In order to make sure multicast registry works, need to specify '-Djava.net.preferIPv4Stack=true' before
     * launch the application
     */
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-provider.xml");
        context.start();
        System.out.println("dubbo 启动成功!");
        System.in.read();

    }

}

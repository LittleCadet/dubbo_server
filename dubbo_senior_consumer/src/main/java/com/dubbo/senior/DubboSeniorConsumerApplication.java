package com.dubbo.senior;

import com.myproj.dubbo.CallBackListner;
import com.myproj.dubbo.CallBackService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class DubboSeniorConsumerApplication {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
		context.start();
		System.out.println("=============dubbo senior consumer 启动成功！=========");
		CallBackService callBackService = context.getBean("callbackService" , CallBackService.class);

		callBackService.addListener("test", new CallBackListner() {
			@Override
			public void changed(String msg) {
				System.out.println("===================callbcak : " + msg);
			}
		});

		System.in.read();

	}

}

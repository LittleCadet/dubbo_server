package com.dubbo.senior;

import com.myproj.dubbo.CallBackListner;
import com.myproj.dubbo.CallBackService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class DubboSeniorConsumerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
		context.start();
		System.out.println("=============dubbo senior consumer 启动成功！=========");
		CallBackService callBackService = context.getBean("callbackService" , CallBackService.class);

		//用于dubbo的参数回调
		//RpcContext.getContext().setAttachment("paramV1" , "1");
		callBackService.addListener("testV1", new CallBackListner() {
			@Override
			public void changed(String msg) {
				System.out.println("===================callbcakV1 : " + msg);
			}
		});

		Thread.sleep(10000);

		System.out.println("======================开始设置第二个参数================");
		//RpcContext.getContext().setAttachment("paramV2" , "2");
		callBackService.addListener("testV2", new CallBackListner() {
			@Override
			public void changed(String msg) {
				System.out.println("===================callbcakV2 : " + msg);
			}
		});



		/*setParam(callBackService);*/

		System.in.read();

	}

	/**
	 * 设置隐式参数
	 * @param callBackService
	 * @throws InterruptedException
	 */
	public static void setParam(CallBackService callBackService) throws InterruptedException {
		Thread.sleep(10000);
		System.out.println("===================开始设置第三个隐式参数======================");
		//用于dubbo的隐式传参
		RpcContext.getContext().setAttachment("paramV3" , "3");
		callBackService.hideParam();

		Thread.sleep(10000);
		System.out.println("===================开始设置第四个隐式参数======================");
		RpcContext.getContext().setAttachment("paramV4" , "4");
		callBackService.hideParam();
	}

}

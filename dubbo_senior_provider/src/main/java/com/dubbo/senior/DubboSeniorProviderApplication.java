package com.dubbo.senior;

import com.myproj.dubbo.CallBackService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class DubboSeniorProviderApplication {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-provider.xml");
		context.start();
		System.out.printf("===================dubbo senior provider 启动成功！==============");

		System.in.read();
	}

}

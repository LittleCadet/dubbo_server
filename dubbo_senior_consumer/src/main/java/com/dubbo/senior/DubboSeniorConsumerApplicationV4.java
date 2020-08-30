package com.dubbo.senior;

import com.google.common.collect.Lists;
import com.myproj.dubbo.CallBackService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author shenxie
 * @date 2020/7/12
 */
public class DubboSeniorConsumerApplicationV4 {

    /**
     * 用于测试 CompletableFuture
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();

        System.out.println("=============DubboSeniorConsumerApplicationV4 start============");
        CallBackService callBackService = context.getBean("callbackService" , CallBackService.class);
        List<Future<String>> futureList = Lists.newArrayList();

        for(int i = 0 ; i < 3 ; i++){
            CompletableFuture<String> info = callBackService.getInfo();
            info.whenComplete((v , e)-> {
                if(Optional.ofNullable(e).isPresent()){
                    System.out.println(String.format("===============当前线程： %s , 调用异常 : e = %s==============" , Thread.currentThread().getName() , e));
                }else{
                    System.out.println(v);
                }
            });
            System.out.println("==========完成调用==========");
        }

        FutureCollector futureCollector = new FutureCollector();
        futureCollector.collect(RpcContext.getContext().getFuture());

        futureList.add(RpcContext.getContext().getCompletableFuture());


        System.out.println(String.format("==============主线程：%s 开始=============" , Thread.currentThread().getName()));
        while(true){
            futureList.forEach(future -> {
                try {
                    System.out.println(String.format("==============future中的元素是： %s , future.isCancelled() ： %s . future.isDone() : %s" ,future.get() , future.isCancelled() , future.isDone() ));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });


            futureCollector.get().forEach(futureInfo -> {
                System.out.println(String.format("==============futureCollector中的元素是： %s" ,futureInfo));
            });
            Thread.sleep(1000);
        }




        // Thread.sleep(600 * 1000);

    }
}

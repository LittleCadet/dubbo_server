package com.dubbo.spi.javaspi.service;

import com.dubbo.spi.javaspi.facade.PrintService;
import com.dubbo.spi.javaspi.impl.PrintServiceV1Impl;
import com.dubbo.spi.javaspi.impl.PrintServiceV2Impl;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.ServiceLoader;

/**
 * @author shenxie
 * @date 2020/6/7
 */
public class ServiceLoaderService
{

    public static void main(String[] args) {
        ServiceLoader<PrintService> serviceServiceLoader = ServiceLoader.load(PrintService.class);

        for(PrintService printService : serviceServiceLoader){
            System.out.println(String.format("RESULT: %s" ,printService.showInfo()));;
        }

        //通过list 来决定当前需要执行的实现类
//        List<AdaptivePrintService> serviceList = Lists.newArrayList(new AdpativePrintServiceV1Impl() , new AdpativePrintServiceV2Impl());
//        for(AdaptivePrintService printService : serviceList){
//            System.out.println(String.format("RESULT: %s" ,printService.showInfo()));;
//        }

    }
}

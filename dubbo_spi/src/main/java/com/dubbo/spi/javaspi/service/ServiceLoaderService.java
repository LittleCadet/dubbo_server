package com.dubbo.spi.javaspi.service;

import com.dubbo.spi.javaspi.facade.PrintService;

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

    }
}

package com.dubbo.spi.javaspi.impl;

import com.dubbo.spi.javaspi.facade.PrintService;

/**
 * @author shenxie
 * @date 2020/6/7
 */
public class PrintServiceV1Impl implements PrintService {
    @Override
    public String showInfo() {
        return String.format("SUCCESS! : %s" , "V1");
    }

}

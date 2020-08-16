package com.dubbo.spi.dubbospi.original.impl;


import com.dubbo.spi.dubbospi.original.facade.PrintService;

/**
 * @author shenxie
 * @date 2020/6/7
 */
public class PrintServiceV2Impl implements PrintService {
    @Override
    public String showInfo() {
        return String.format("DUBBO SUCCEED ! %s","V2");
    }
}

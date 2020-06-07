package com.dubbo.spi.dubbospi.impl;

import com.dubbo.spi.dubbospi.facade.PrintService;

/**
 * @author shenxie
 * @date 2020/6/7
 */
public class PrintServiceV1Impl implements PrintService {
    @Override
    public String showInfo() {
        return String.format("DUBBO SUCCEED ! %s","V1");
    }
}

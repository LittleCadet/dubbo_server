package com.dubbo.spi.javaspi.impl;

import com.dubbo.spi.javaspi.facade.PrintService;
import com.sun.javafx.geom.Vec2d;

/**
 * @author shenxie
 * @date 2020/6/7
 */
public class PrintServiceV2Impl implements PrintService
{
    @Override
    public String showInfo() {
        return String.format("SUCCESS! : %s" , "V2");
    }
}

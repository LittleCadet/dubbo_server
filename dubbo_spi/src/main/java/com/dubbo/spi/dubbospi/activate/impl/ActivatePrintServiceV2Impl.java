package com.dubbo.spi.dubbospi.activate.impl;


import com.dubbo.spi.dubbospi.activate.facade.ActivatePrintService;
import org.apache.dubbo.common.extension.Activate;

/**
 * @author shenxie
 * @date 2020/6/7
 */
@Activate(group = {"custom"} ,  order = -100 )
public class ActivatePrintServiceV2Impl implements ActivatePrintService {
    @Override
    public String showInfo() {
        return String.format("DUBBO SUCCEED ! %s","V2");
    }
}

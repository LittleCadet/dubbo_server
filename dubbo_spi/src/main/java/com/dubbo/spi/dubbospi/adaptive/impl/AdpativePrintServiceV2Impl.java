package com.dubbo.spi.dubbospi.adaptive.impl;


import com.dubbo.spi.dubbospi.adaptive.facade.AdaptivePrintService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;

/**
 * @author shenxie
 * @date 2020/6/7
 */
//优先级： 在类上标注@Adaptive的优先级最高， 默认使用它作为默认实现
//@Adaptive
public class AdpativePrintServiceV2Impl implements AdaptivePrintService {
    @Override
    public String showInfo(URL url) {
        return String.format("DUBBO SUCCEED ! %s","V2");
    }
}

package com.dubbo.spi.dubbospi.adaptive.impl;

import com.dubbo.spi.dubbospi.adaptive.facade.AdaptivePrintService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.extension.Adaptive;

/**
 * @author shenxie
 * @date 2020/6/7
 */
public class AdpativePrintServiceV1Impl implements AdaptivePrintService {
    @Override
    public String showInfo(URL url) {
        return String.format("DUBBO SUCCEED ! %s","V1");
    }

    @Override
    public String showInfoV2() {
        return String.format("DUBBO SUCCEED ! %s","V2");
    }
}

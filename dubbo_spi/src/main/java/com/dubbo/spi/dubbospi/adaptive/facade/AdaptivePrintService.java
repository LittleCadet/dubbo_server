package com.dubbo.spi.dubbospi.adaptive.facade;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 *
 * @author shenxie
 */
@SPI
public interface AdaptivePrintService {
    @Adaptive
    String showInfo(URL url);
}

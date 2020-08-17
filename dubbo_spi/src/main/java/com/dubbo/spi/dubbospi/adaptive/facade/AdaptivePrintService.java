package com.dubbo.spi.dubbospi.adaptive.facade;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.extension.SPI;

/**
 *
 * @author shenxie
 */
@SPI
public interface AdaptivePrintService {
    @Adaptive
    String showInfo(URL url);

    /**
     * 用于查看 $Adaptive类的生成
     * @return
     */
    String showInfoV2();

}

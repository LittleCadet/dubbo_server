package com.dubbo.spi.dubbospi.facade;

import org.apache.dubbo.common.extension.SPI;

/**
 *
 * @author shenxie
 */
@SPI(value = "printServiceV2Impl")
public interface PrintService {
    String showInfo();
}

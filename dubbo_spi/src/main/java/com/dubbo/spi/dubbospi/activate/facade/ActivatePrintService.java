package com.dubbo.spi.dubbospi.activate.facade;

import org.apache.dubbo.common.extension.SPI;

/**
 *
 * @author shenxie
 */
@SPI
public interface ActivatePrintService {
    String showInfo();
}

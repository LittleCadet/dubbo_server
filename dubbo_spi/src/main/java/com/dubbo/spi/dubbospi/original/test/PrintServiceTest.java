package com.dubbo.spi.dubbospi.original.test;

import com.dubbo.spi.dubbospi.original.facade.PrintService;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @author shenxie
 * @date 2020/6/7
 */
public class PrintServiceTest {
    public static void main(String[] args) {
        PrintService printService = ExtensionLoader.getExtensionLoader(PrintService.class).getDefaultExtension();
        System.out.println(printService.showInfo());
    }
}

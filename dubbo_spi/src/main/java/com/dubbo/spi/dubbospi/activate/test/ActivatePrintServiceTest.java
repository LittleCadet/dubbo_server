package com.dubbo.spi.dubbospi.activate.test;

import com.dubbo.spi.dubbospi.activate.facade.ActivatePrintService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.List;

/**
 * @author shenxie
 * @date 2020/6/7
 */
public class ActivatePrintServiceTest {
    public static void main(String[] args) {
        ExtensionLoader<ActivatePrintService> extensionLoader = ExtensionLoader.getExtensionLoader(ActivatePrintService.class);
        URL url = URL.valueOf("test://localhost//test");
        List<ActivatePrintService> extension = extensionLoader.getActivateExtension(url , new String[]{} , "custom");
        System.out.println(String.format("匹配到的spi的个数： %s" , extension.size()));
        for(ActivatePrintService activatePrintService : extension){
            System.out.println(activatePrintService.showInfo());
        }
    }
}

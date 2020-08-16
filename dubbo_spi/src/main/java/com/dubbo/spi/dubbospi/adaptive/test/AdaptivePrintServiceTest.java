package com.dubbo.spi.dubbospi.adaptive.test;

import com.dubbo.spi.dubbospi.adaptive.facade.AdaptivePrintService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @author shenxie
 * @date 2020/6/7
 */
public class AdaptivePrintServiceTest {
    public static void main(String[] args) {
        ExtensionLoader<AdaptivePrintService> extensionLoader = ExtensionLoader.getExtensionLoader(AdaptivePrintService.class);
        AdaptivePrintService extension = extensionLoader.getAdaptiveExtension();

        //关于key的定义 ：
        // 默认使用接口：将驼峰规则大写变为 单个单词 + .   例如： AdaptivePrintService : 那么key 为 adaptive.print.service
        //也可以自定义key ： 在方法名的@Adaptive上标注value即可
        URL url = URL.valueOf("http://localohost/aaa?adaptive.print.service=adpativePrintServiceV1Impl");
        //URL url = URL.valueOf("test://localhost/testiii?myAdaptiveName=adpativePrintServiceV1Impl");
        System.out.println(extension.showInfo(url));
    }
}

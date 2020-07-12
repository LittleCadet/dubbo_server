package com.dubbo.senior;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * @author shenxie
 * @date 2020/7/12
 */
public class DubboSeniorConsumerApplicationV2 {

    /**
     *  泛化调用专属
     * @author shenxie
     */
    public static void main(String[] args) {
        genericUse();
    }


    /**
     * 泛化调用
     */
    public static void genericUse(){

        //设置应用名
        ApplicationConfig appConfig = new ApplicationConfig("duboo-senior-consumer");

        //设置注册中心
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("47.99.112.38:2181");

        ReferenceConfig<GenericService> ref = new ReferenceConfig<>();
        ref.setProtocol("dubbo");
        ref.setApplication(appConfig);
        ref.setRegistry(registryConfig);
        ref.setInterface("com.myproj.dubbo.CallBackService");

        //泛化调用的标识
        ref.setGeneric(true);

        //创建远程代理
        GenericService genericService = ref.get();

        //泛化调用 + 隐式参数
        RpcContext.getContext().setAttachment("paramV5" , "5");
        Object result = genericService.$invoke("hideParam" , new String []{} , new Object[]{});
        System.out.println("泛化调用完成 ， result:"  +  result);

        //泛化调用 + 普通传参
        System.out.println("泛化调用完成 ， result:" + genericService.$invoke("showInfo" , new String[]{"java.lang.String"} , new Object[]{"succeed"}));


    }
}

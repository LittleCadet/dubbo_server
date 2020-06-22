package com.dubbo.spi.ioc;

import com.dubbo.spi.dubbospi.facade.PrintService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import org.apache.dubbo.common.extension.ExtensionFactory;
import org.apache.dubbo.config.spring.ServiceBean;
import org.apache.dubbo.config.spring.extension.SpringExtensionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.reflect.misc.MethodUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author shenxie
 * @date 2020/6/14
 */
public class PrintServiceTest {

    public static void main(String[] args) throws NotFoundException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        Class<?> aClass = Class.forName("com.dubbo.spi.ioc.PrintServiceImpl");
        PrintServiceImpl printService = (PrintServiceImpl)aClass.newInstance();

        for (Method method : MethodUtil.getMethods(PrintServiceImpl.class)){
            if(method.getName().startsWith("set")
                && method.getParameterTypes().length == 1
                && Modifier.isPublic(method.getModifiers())){

                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
                dubboIoc(applicationContext , method ,printService);
                springIoc(applicationContext , method , printService);
            }
        }
    }

    /**
     * 用SpringExtensionFactory获取bean ， 配合java反射实现IOC
     * @param applicationContext
     * @param method
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void dubboIoc(ApplicationContext applicationContext , Method method , PrintServiceImpl printServiceFacade) throws InvocationTargetException, IllegalAccessException {
        //设置dubbo的springExtensionFactory的上下文
        SpringExtensionFactory springExtensionFactory = new SpringExtensionFactory();
        SpringExtensionFactory.addApplicationContext(applicationContext);

        Class<?> parameterType = method.getParameterTypes()[0];
        Object object = springExtensionFactory.getExtension(parameterType , "printServiceBean");
        if(object instanceof PrintServiceBean){
            //第一个参数代表： 被注入类【必须要实例化】 ， 注入的对象
            Object invoke = method.invoke(printServiceFacade, object);
            System.out.println("invoke result :" + invoke);
            System.out.println("通过dubbo的SpringExtensionFactory + spring反射实现IOC：" + printServiceFacade.showInfo());
        }
    }

    /**
     * spring上下文获取bean  + spring反射实现IOC
     * @param applicationContext
     * @param method
     * @param printServiceFacade
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void springIoc(ApplicationContext applicationContext , Method method , PrintServiceFacade printServiceFacade) throws InvocationTargetException, IllegalAccessException {
        PrintServiceBean printServiceBean = (PrintServiceBean) applicationContext.getBean("printServiceBean");
        Object invoke = method.invoke(printServiceFacade, printServiceBean);

        System.out.println("invoke result :" + invoke);
        System.out.println("通过spring上下文 + spring反射实现IOC：" + printServiceFacade.showInfo());
    }
}

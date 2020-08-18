package com.dubbo.spi.compiler;

import javassist.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author shenxie
 * @date 2020/6/14
 */
public class Javassit {

    /**
     * 使用javassit编译 java代码
     *
     *
     * 用编译器将 字符串 编译为 一个可运行的.class文件，并执行
     * @param args
     * @throws CannotCompileException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static void main(String[] args) throws CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //初始化类池  [千万不能用 new ClassPool()的方式去初始化， 不能加载系统路径 ：会初始化java.object.class类 ]
        /*ClassPool classPool = new ClassPool();

        classPool.importPackage("java.lang");*/

        //初始化类池  [能加载系统路径 ：会初始化java.object.class类 ]
        ClassPool classPool = ClassPool.getDefault();
//        classPool.importPackage("java.lang");

        //创建一个类
        CtClass ctClass = classPool.makeClass("HelloWorld");

        //创建一个方法
        CtMethod ctMethod = CtNewMethod.make("public static String testV2(){\n" +
                "        return \"hello , javassitCompiler\";\n" +
                "    }", ctClass);

        //将方法添加到类中
        ctClass.addMethod(ctMethod);

        //生成class文件
        Class aClass = ctClass.toClass();

        //通过反射调用类实例
        Object object = aClass.newInstance();

        Method method = aClass.getDeclaredMethod("testV2",  null);

        //通过反射调用该类方法
        Object invoke = method.invoke(object, null);

        System.out.println("result:" + invoke);

    }

    public static void testV1(){
        System.out.println("hello , javassitCompiler");
    }

    public static String testV2(){
        return "hello , javassitCompiler";
    }


}

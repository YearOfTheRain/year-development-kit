package org.year.modules.demo_one;

import java.net.URL;

/**
 * 这个是打印类加载器的例子
 * @author YearOfTheRain
 * @create 2024-11-05  14:46
 */
public class TestDemo2 {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
//        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(TestDemo2.class.getClassLoader().getClass().getName());

        System.out.println();
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassloader = appClassLoader.getParent();
        ClassLoader bootstrapLoader = extClassloader.getParent();
        System.out.println("the bootstrapLoader : " + bootstrapLoader);
        System.out.println("the extClassloader : " + extClassloader);
        System.out.println("the appClassLoader : " + appClassLoader);

        System.out.println();
        System.out.println("bootstrapLoader加载以下文件：");
//        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
//        for (int i = 0; i < urls.length; i++) {
//            System.out.println(urls[i]);
//        }

        System.out.println();
        System.out.println("extClassloader加载以下文件：");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println();
        System.out.println("appClassLoader加载以下文件：");
        System.out.println(System.getProperty("java.class.path"));

    }
}

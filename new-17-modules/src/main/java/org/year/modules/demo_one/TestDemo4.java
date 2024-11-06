package org.year.modules.demo_one;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * 这个是打破双亲委派的例子
 * 第二个main方法是自动热更新的例子
 * @author YearOfTheRain
 * @create 2024-11-06  16:15
 */
public class TestDemo4 {

    static class MyClassLoader extends ClassLoader {
        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws Exception {
            name = name.replaceAll("\\.", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name
                    + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                //defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节数组。
                return defineClass(name, data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

        protected Class<?> loadClass(String name, boolean resolve)
                throws ClassNotFoundException {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    if (!name.startsWith("org.year.modules")) {
                        c = this.getParent().loadClass(name);
                    } else {
                        c = findClass(name);
                    }
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }

    }

//    public static void main(String args[]) throws Exception {
//        //初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类加载器的父加载器设置为应用程序类加载器AppClassLoader
//        TestDemo1.MyClassLoader classLoader = new TestDemo1.MyClassLoader("D:/test");
//        //D盘创建 test/com/tuling/jvm 几级目录，将User类的复制类User1.class丢入该目录
//        Class clazz = classLoader.loadClass("org.year.modules.demo_one.User");
//        System.out.println(clazz);
//        Object obj = clazz.newInstance();
//        Method method = clazz.getDeclaredMethod("showName", null);
//        method.invoke(obj, null);
//        System.out.println(clazz.getClassLoader().getClass().getName());
//        System.out.println(clazz.getClassLoader().getParent().getClass().getName());
//        System.out.println(clazz.getClassLoader().getParent().getParent().getClass().getName());
//        System.out.println(clazz.getClassLoader().getParent().getParent().getParent());
//        System.out.println(String.class.getClassLoader());
//
//        TestDemo1.MyClassLoader classLoader1 = new TestDemo1.MyClassLoader("D:/test");
//        //D盘创建 test/com/tuling/jvm 几级目录，将User类的复制类User1.class丢入该目录
//        Class clazz1 = classLoader1.loadClass("org.year.modules.demo_one.User");
//        System.out.println(clazz1);
//        System.out.println(clazz == clazz1);
////        System.out.println(clazz.getClassLoader().getClass().getName());
//    }

    public static void main(String[] args) throws Exception {
        //初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类加载器的父加载器设置为应用程序类加载器AppClassLoader
        MyClassLoader classLoader = new MyClassLoader("D:/test");
        int i = 0;
        while (true) {
            if(i++ > 10) {
                classLoader = new MyClassLoader("D:/test");
                i = 0;
            }
            //D盘创建 test/com/tuling/jvm 几级目录，将User类的复制类User1.class丢入该目录
            Class clazz = classLoader.loadClass("org.year.modules.demo_one.User");
            System.out.println(clazz.getClassLoader());
            System.out.println(clazz);
            Object obj = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("showName", null);
            method.invoke(obj, null);
            Thread.sleep(1000);
        }
    }
}

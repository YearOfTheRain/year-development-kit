package org.year.modules.demo_one;

/**
 * 这个是查看字节码的例子
 * @author YearOfTheRain
 * @create 2024-11-06  10:08
 */
public class TestDemo3 {

    public static int num = 666;

    public static void main(String[] args) {
        TestDemo3 demo = new TestDemo3();
        ClassLoader classLoader = demo.getClass().getClassLoader();
        System.out.println(classLoader);

        String name = "demo.getName()";
        ClassLoader classLoader1 = name.getClass().getClassLoader();
        System.out.println(classLoader1);
        int compute = demo.compute();
        System.out.println(compute);
    }

    public int compute() {
        int a = 1;
        int b = 3;
        int c = (a + b) * 10;
        return c;
    }
}

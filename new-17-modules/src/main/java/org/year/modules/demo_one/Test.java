package org.year.modules.demo_one;

/**
 * @author YearOfTheRain
 * @create 2024-11-25  10:37
 */
public class Test {

    /*static int count = 0;
    int i = 0;
    public void changeCount() {
        while (i < 5) {
            i++;
            count++;
        }
    }
    public static void main(String[] args) {
        Test check1 = new Test();
        Test check2 = new Test();
        // 静态变量属于类变量，和类的示例没关系
        check1.changeCount();
        check2.changeCount();
        System.out.println(check1.count + " : " + check2.count);
    }*/

    public static void main(String[] args) {
        String product = "Pen";
        product.toLowerCase();
        product.concat(" BOX".toLowerCase());
        // java 的 String 是不可变的，所以任何的操作都是返回新值
        System.out.println(product.length());
        System.out.print(product.substring(4,6));
    }


}

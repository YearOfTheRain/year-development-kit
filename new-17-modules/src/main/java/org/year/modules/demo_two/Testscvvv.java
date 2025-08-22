package org.year.modules.demo_two;

/**
 * @author YearOfTheRain
 * @create 2025-07-25  17:25
 */
public class Testscvvv {

    {
        System.out.println("Testscvvv--普通代码块");
    }

    static {
        System.out.println("Testscvvv--静态代码块");
    }

    Testscvvv() {
        System.out.println("Testscvvv--构造方法");
    }

    public static void main(String[] args) {
//        Testscvvv testscvvv = new Testscvvv();
//        Testscvvv testscvvv2 = new Testscvvv();
        B b = new B();
        b.test2();

    }
}
class A{
    int i=100;
    int j = 200;

    public void test(){
        System.out.println("i---->"+this.i);
        System.out.println("j---->"+this.j);
        System.out.println("------------test1-------------");
    }

    public void fun(){
        System.out.println("父类的fun()方法。。。");
    }

}

class B extends A{

    int i = 300;

    public void test2(){
        System.out.println("i------>"+this.i);//子类有的，就访问子类
        System.out.println("j------>"+this.j);//如果子类没有相应的属性，那么会默认去找父类的属性
        System.out.println("------------test2-----------------");

        this.fun();
    }

//    public void fun(){
//        System.out.println("子类重写了父类的fun()方法。。。");
//
//    }

}

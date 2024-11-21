package org.year.modules.demo_one;

/**
 * record 关键字
 * @author YearOfTheRain
 * @create 2024-11-19  11:46
 */
public class TestDemo6 {

    public static void main(String[] args) {
        OrderRequest orderRequest = new OrderRequest("", 5);

        OrderHodeRequest orderHodeRequest = new OrderHodeRequest("", "5", orderRequest);

        Circle circle = new Circle(-5);
        Circle circle1 = new Circle(5);
        System.out.println(circle);
        System.out.println(circle.equals(circle1));
    }

    interface Shape{
        double area();
    }
    record Circle(double radius) implements Shape{
        @Override
        public double area() {
            return Math.PI * radius * radius;
        }

        public Circle{
            if (radius < 0){
                throw new IllegalArgumentException("Radius cannot be negative");
            }
        }
    }
}

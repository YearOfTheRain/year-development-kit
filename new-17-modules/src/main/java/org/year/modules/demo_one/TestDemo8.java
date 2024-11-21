package org.year.modules.demo_one;

/**
 *  sealed class
 * @author YearOfTheRain
 * @create 2024-11-21  17:26
 */
public class TestDemo8 {

    public static void main(String[] args) {
        Shape shape = new Shape.Circle("circle", 5);
        System.out.println(shape.area());
    }


    abstract static sealed class Shape permits Shape.Circle, Shape.Square {
        public final String id;

        protected Shape(String id) {
            this.id = id;
        }

        public abstract double area();

        public static final class Circle extends Shape {
            public final double radius;

            public Circle(String id, double radius) {
                super(id);
                this.radius = radius;
            }
            @Override
            public double area() {
                return Math.PI * radius * radius;
            }
        }

        public static final class Square extends Shape {
            public final double radius;

            public Square(String id, double radius) {
                super(id);
                this.radius = radius;
            }
            @Override
            public double area() {
                return radius * radius;
            }
        }

    }
}

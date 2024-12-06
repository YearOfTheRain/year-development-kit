package org.year.modules.demo_one;

/**
 * @author YearOfTheRain
 * @create 2024-11-25  18:29
 */
public class TestDemo9 {

    sealed interface Shape
            permits Shape.Circle, Shape.Rectangle, Shape.Square {
           // field variable

        record Circle(double radius) implements Shape {
            // blank
        }

        record Square(double side) implements Shape {
            // blank
        }

        record Rectangle(double length, double width) implements Shape {
            // blank
        }

    }

    static Shape.Rectangle rect = null;

    public static void main(String[] args) {
        Shape shape = new Shape.Rectangle(10, 10);
        System.out.println("It should be ture that " + shape +
                " is a square: " + isSquare(shape));

        System.out.println();

        shape = new Shape.Circle(10);
        System.out.println("It cannot be ture that " + shape +
                " is a square: " + (!isSquare(shape)));
    }

    static boolean isSquare(Shape shape) {
        if (shape instanceof Shape.Rectangle rect) {
            // Field rect is shadowed, local rect is in scope
            System.out.println(
                    "This should be the local rect: " +
                            rect.equals(shape));
            return (rect.length == rect.width);
        }

        // Field rect is in scope, local rect is not in scope here
        System.out.println(
                "This should be the field rect: " + (rect == null));
        return (shape instanceof Shape.Square);
    }
}

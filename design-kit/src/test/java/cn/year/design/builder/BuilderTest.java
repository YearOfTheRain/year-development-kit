package cn.year.design.builder;

/**
 * @author YearOfTheRain
 * @create 2025-01-21  15:47
 */
public class BuilderTest {

    public static void main(String[] args) {
        CarBuilder carBulider = new CarBuilder();
        Director director = new Director();
        director.makeSuv(carBulider);
        Car car = carBulider.getResult();
        System.out.println(car);
    }
}

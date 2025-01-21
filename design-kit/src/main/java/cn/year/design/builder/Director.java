package cn.year.design.builder;

/**
 * @author YearOfTheRain
 * @create 2025-01-21  15:47
 */
public class Director {


    public void makeSuv(Builder builder) {
        builder.reSet();
        builder.setEngine("SUV 发动机");
        builder.setSeats(5);
        builder.setTripComputer();
        builder.setGPS();
    }


    public void makeSport(Builder builder) {
        builder.reSet();
        builder.setEngine("运动型 发动机");
        builder.setSeats(5);
//        builder.setTripComputer();
        builder.setGPS();
    }

}

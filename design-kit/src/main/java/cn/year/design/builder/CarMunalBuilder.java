package cn.year.design.builder;

/**
 * @author YearOfTheRain
 * @create 2025-01-21  15:45
 */
public class CarMunalBuilder implements Builder{
    @Override
    public void reSet() {
        System.out.println("CarMunalBuilder reSet");
    }

    @Override
    public void setSeats(int seats) {
        System.out.println("CarMunalBuilder setSeats" + seats);
    }

    @Override
    public void setEngine(String engine) {
        System.out.println("CarMunalBuilder setEngine" + engine);
    }

    @Override
    public void setTripComputer() {
        System.out.println("CarMunalBuilder setTripComputer");
    }

    @Override
    public void setGPS() {
        System.out.println("CarMunalBuilder setGPS");
    }
}

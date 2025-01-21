package cn.year.design.builder;

/**
 * @author YearOfTheRain
 * @create 2025-01-21  15:42
 */
public class CarBuilder  implements Builder {

    private Car car;

    @Override
    public void reSet() {
        System.out.println("CarBuilder reset");
        car = new Car();
    }

    @Override
    public void setSeats(int seats) {
        System.out.println("CarBuilder seats" + seats);
        car.setSeat(seats);
    }

    @Override
    public void setEngine(String engine) {
        System.out.println("CarBuilder setEngine" + engine);
        car.setEngine(engine);
    }

    @Override
    public void setTripComputer() {
        System.out.println("CarBuilder setTripComputer");
    }

    @Override
    public void setGPS() {
        System.out.println("CarBuilder setGPS");
    }


    public Car getResult(){
        return car;
    }
}

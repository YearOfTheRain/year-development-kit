package cn.year.design.builder;

/**
 * @author YearOfTheRain
 * @create 2025-01-21  15:40
 */
public interface Builder {

    void reSet();

    void setSeats(int seats);

    void setEngine(String engine);

    void setTripComputer();

    void setGPS();
}

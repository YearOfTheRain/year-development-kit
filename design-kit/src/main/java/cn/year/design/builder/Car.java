package cn.year.design.builder;

/**
 * @author YearOfTheRain
 * @create 2025-01-21  15:58
 */
public class Car {

    private int seat;
    private String engine;
    private String gps;

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seat=" + seat +
                ", engine='" + engine + '\'' +
                ", gps='" + gps + '\'' +
                '}';
    }
}

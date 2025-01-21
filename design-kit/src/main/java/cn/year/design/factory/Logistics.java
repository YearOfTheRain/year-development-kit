package cn.year.design.factory;

/**
 * @author YearOfTheRain
 * @create 2024-12-20  15:37
 */
public abstract class Logistics {


    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }


    public abstract Transport createTransport();

}

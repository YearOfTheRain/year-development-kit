package cn.year.design.factory.impl;

import cn.year.design.factory.Logistics;
import cn.year.design.factory.Transport;

/**
 * @author YearOfTheRain
 * @create 2024-12-20  15:43
 */
public class RoadLogistics extends Logistics {

    public RoadLogistics() {
    }

    public RoadLogistics(String njaje) {
        System.out.println(njaje);
    }

    @Override
    public Transport createTransport() {
        return new Truck();
    }

    class Truck implements Transport {
        @Override
        public void deliver() {
            System.out.println("road transport");
        }
    }
}

package cn.year.design.factory.impl;

import cn.year.design.factory.Logistics;
import cn.year.design.factory.Transport;

/**
 * @author YearOfTheRain
 * @create 2024-12-20  15:44
 */
public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }

    class Ship implements Transport {
        @Override
        public void deliver() {
            System.out.println("sea transport");
        }
    }
}

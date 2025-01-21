package cn.year.design.abstractFactory.factory;

import cn.year.design.abstractFactory.Chair;
import cn.year.design.abstractFactory.CoffeeTable;
import cn.year.design.abstractFactory.Sofa;

/**
 * @author YearOfTheRain
 * @create 2025-01-16  15:28
 */
public class ModelFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new Chair() {
            @Override
            public void hasLegs() {
                System.out.println("高级椅子有四条腿");
            }

            @Override
            public void sitOn() {
                System.out.println("坐上高级椅子");
            }
        };
    }

    @Override
    public Sofa createSofa() {
        return null;
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return null;
    }
}

package cn.year.design.abstractFactory.factory;

import cn.year.design.abstractFactory.Chair;
import cn.year.design.abstractFactory.CoffeeTable;
import cn.year.design.abstractFactory.Sofa;

/**
 * @author YearOfTheRain
 * @create 2025-01-16  15:26
 */
public interface FurnitureFactory {

    Chair createChair();

    Sofa createSofa();

    CoffeeTable createCoffeeTable();
}

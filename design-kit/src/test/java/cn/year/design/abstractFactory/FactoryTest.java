package cn.year.design.abstractFactory;

import cn.year.design.abstractFactory.factory.FurnitureFactory;
import cn.year.design.abstractFactory.factory.ModelFurnitureFactory;

/**
 * @author YearOfTheRain
 * @create 2025-01-16  15:54
 */
public class FactoryTest {

    public static void main(String[] args) {
        FurnitureFactory factory = new ModelFurnitureFactory();
        Chair chair = factory.createChair();
        chair.sitOn();
    }
}

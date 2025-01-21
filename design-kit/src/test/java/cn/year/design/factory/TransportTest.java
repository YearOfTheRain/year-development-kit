package cn.year.design.factory;

import cn.year.design.factory.impl.RoadLogistics;
import cn.year.design.factory.impl.SeaLogistics;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @author YearOfTheRain
 * @create 2024-12-20  15:46
 */
public class TransportTest {

    static class newRoadLogistics extends RoadLogistics {
        @Override
        public Transport createTransport() {
            return new Transport() {
                @Override
                public void deliver() {
                    System.out.println("new RoadLogistics");
                }
            };
        }
    }

    public static void main(String[] args) {
        Arrays.stream(args).toList().forEach(System.out::println);
        Logistics logistics = new Logistics() {
            @Override
            public Transport createTransport() {
                return ()->{
                    System.out.println("new RoadLogistics1111");
                };
            }
        };
        logistics.planDelivery();
    }

    /**
     * 拿到对应类的模板Class，可以通过模板类创建对应的实例对象，
     * 也可以拿模板类来做某些判断处理
     *
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Test
    void test1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<RoadLogistics> roadLogisticsClass = RoadLogistics.class;
        RoadLogistics transport = roadLogisticsClass.getConstructor().newInstance();
        transport.planDelivery();
    }
}

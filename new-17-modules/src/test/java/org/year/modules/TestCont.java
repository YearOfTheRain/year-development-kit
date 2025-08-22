package org.year.modules;

import org.junit.jupiter.api.Test;

/**
 * @author YearOfTheRain
 * @create 2025-07-25  15:34
 */
public class TestCont {

    @Test
    void test() {

//        System.out.println(Boolean.TRUE.booleanValue());
        int x = 3;
        int y = 10;
        int result1 = ++x + y++;
        System.out.println("x:"+x);
        System.out.println("y:"+y);
        System.out.println("result1:"+result1);
    }

}

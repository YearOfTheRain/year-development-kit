package org.year.modules.demo_one;

import java.util.Date;

/**
 * 字符块
 * @author YearOfTheRain
 * @create 2024-11-21  15:56
 */
public class TestDemo7 {

    public static void main(String[] args) {
        String textBlock = """
                Here is the text block:
                <!DOCTYPE html>
                <html>
                    <body>
                        <h1>"Hello %s %d %f %c  %b \
                        \s
                         World!"</h1>
                    </body>
                </html>
                """.formatted("year", 1, 2.3, 'a',true, true, new Date(), 111);
        System.out.println(String.format(textBlock, "闪大大大大大"));

        String ddd = """
                         No man is an island.
                          Entire of itself,
                Every man is a piece\s\
                \s           of the continent,
                          A part of the main.
                """;
        System.out.println(ddd);
    }
}

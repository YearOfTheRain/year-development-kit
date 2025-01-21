package springboot.controller;

/**
 * @author YearOfTheRain
 * @create 2025-01-03  14:41
 */
public class JeetyWebServer implements WebServer {

    @Override
    public void start() {
        System.out.println("JeetyWebServer start");
    }
}

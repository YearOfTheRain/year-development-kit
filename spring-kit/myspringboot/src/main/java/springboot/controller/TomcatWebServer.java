package springboot.controller;

/**
 * @author YearOfTheRain
 * @create 2025-01-03  14:40
 */
public class TomcatWebServer implements WebServer{

    @Override
    public void start() {
        System.out.println("Tomcat启动");
    }
}

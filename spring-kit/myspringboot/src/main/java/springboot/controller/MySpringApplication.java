package springboot.controller;

//import org.apache.catalina.*;
//import org.apache.catalina.connector.Connector;
//import org.apache.catalina.core.StandardContext;
//import org.apache.catalina.core.StandardEngine;
//import org.apache.catalina.core.StandardHost;
//import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Map;

/**
 * @author YearOfTheRain
 * @create 2025-01-03  11:38
 */
public class MySpringApplication {

    public static void run(Class clazz){
        // 注册spring 容器
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(clazz);
        webApplicationContext.refresh();
        // 启动tomcat服务，提供网络访问
//        startTomCatServer(webApplicationContext);
        WebServer webServer = getWebServer(webApplicationContext);
        webServer.start();
    }

    private static WebServer getWebServer(WebApplicationContext applicationContext) {
        Map<String, WebServer> beansOfType = applicationContext.getBeansOfType(WebServer.class);
        if (beansOfType.isEmpty()) {
            throw new RuntimeException("没有找到WebServer");
        }

        if (beansOfType.size() > 1) {
            throw new RuntimeException("找到多个WebServer");
        }
        return beansOfType.values().stream().findFirst().get();
    }

//    private static void startTomCatServer(WebApplicationContext applicationContext) {
//        // 启动tomcat服务，提供网络访问
//        Tomcat tomcat = new Tomcat();
//        Server server = tomcat.getServer();
//
//        Service service = server.findService("Tomcat");
//
//        Connector connector = new Connector();
//        connector.setPort(8888);
//
//        Engine engine = new StandardEngine();
//        engine.setDefaultHost("localhost");
//
//        Host host = new StandardHost();
//        host.setName("localhost");
//
//        String contextPath = "";
//        Context context = new StandardContext();
//        context.setPath(contextPath);
//        context.addLifecycleListener(new Tomcat.FixContextListener());
//
//        host.addChild(context);
//        engine.addChild(host);
//
//        service.setContainer(engine);
//        service.addConnector(connector);
//        tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet(applicationContext));
//        context.addServletMappingDecoded("/*", "dispatcher");
//
//        try {
//            tomcat.start();
//        } catch (LifecycleException e) {
//            throw new RuntimeException(e);
//        }
//    }
}

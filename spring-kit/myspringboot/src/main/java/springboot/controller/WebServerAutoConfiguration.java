package springboot.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YearOfTheRain
 * @create 2025-01-03  14:48
 */
@Configuration
public class WebServerAutoConfiguration {


    @Bean
//    @Conditional(TomcatCondition.class)
    @MyConditionOnClass("org.apache.catalina.startup.Tomcat")
    public WebServer tomCatWebServer(){
        return new TomcatWebServer();
    }

    @Bean
//    @Conditional(JettyCondition.class)
    @MyConditionOnClass("org.eclipse.jetty.server.Server")
    public WebServer jettyWebServer(){
        return new JeetyWebServer();
    }
}

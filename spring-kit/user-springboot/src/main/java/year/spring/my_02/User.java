package year.spring.my_02;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author YearOfTheRain
 * @create 2024-11-05  10:56
 */

public class User implements InitializingBean, DisposableBean, BeanNameAware {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("name="+name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
        this.name = "afterSetting";
        show();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
        this.name = "destroySetting";
        show();
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanName  " +  s);
    }
}

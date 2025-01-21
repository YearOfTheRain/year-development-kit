package org.year.todo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YearOfTheRain
 * @create 2025-01-17  10:02
 */
public abstract class SimpleContextHandler<K,V> implements ApplicationContextAware {


    /**
     * 缓存类
     */
    protected final Map<K, V> HANDLER_MAP = new HashMap<>();


    public abstract V getInstance(K key);



}



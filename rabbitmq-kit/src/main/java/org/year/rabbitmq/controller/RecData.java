package org.year.rabbitmq.controller;

import lombok.Data;

/**
 * @author YearOfTheRain
 * @create 2024-10-18  14:44
 */
@Data
public class RecData {

    private String type;
    private String content;
    private String source;
    private String isMentioned;
    private String isMsgFromSelf;
    private String isSystemEvent;
}

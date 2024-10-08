package org.year.message.store;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

/**
 * @author YearOfTheRain
 * @create 2024-10-07  18:25
 */
@Entity
@Table(name = "message_info")
@Getter
@Setter
public class MessageInfo {

    /** 主键：消息ID */
    @Id
    @GeneratedValue(generator = "message_info_seq",strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "message_info_seq", strategy = "org.year.message.util.MyIdGeneratorConfig")
    private Long id;
    /** 类型：1-单处理；2-多处理 */
    private Integer type;
    /** 消息通道 */
    private String channel;
    /** 发送内容 */
    private String content;
    /** 状态：0-就绪；1-已消费；2-消费失败 */
    private Integer state;
    /** 失败原因 */
    private String errorMessage;
    /** 备注 */
    private String remark;
    /** 重试次数 */
    private Integer retryNum;
    /** 创建时间 */
    private LocalDateTime createTime;
    /** 更新时间 */
    private LocalDateTime updateTime;


    public static MessageInfo create(String channel, String content) {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.type = 1;
        messageInfo.channel = channel;
        messageInfo.content = content;
        messageInfo.state = 0;
        messageInfo.createTime = LocalDateTime.now();
        return messageInfo;
    }
}

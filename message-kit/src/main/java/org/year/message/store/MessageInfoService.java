package org.year.message.store;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author YearOfTheRain
 * @create 2024-10-08  09:33
 */
@Service
public class MessageInfoService {

    @Resource
    private MessageInfoRepository messageRepository;

    public MessageInfo save(MessageInfo messageInfo) {
        return messageRepository.save(messageInfo);
    }

}

package cn.year.common;

import cn.year.common.config.AliReadConfig;
import cn.year.common.config.ReadConfig;
import org.dromara.sms4j.api.SmsBlend;
import org.dromara.sms4j.api.entity.SmsResponse;
import org.dromara.sms4j.core.factory.SmsFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author YearOfTheRain
 * @create 2025-03-13  09:41
 */
@SpringBootTest
public class SendTest {

    private ReadConfig readConfig = new ReadConfig();
    private AliReadConfig aliReadConfig = new AliReadConfig();

    @Test
    void testSendSingle() {
        SmsFactory.createSmsBlend(readConfig, "tencent");
        SmsBlend smsBlend = SmsFactory.getSmsBlend("tencent");
        LinkedHashMap<String, String> params = new LinkedHashMap<>();
        params.put("code", "999888");
        params.put("time", "12");
        SmsResponse smsResponse = smsBlend.sendMessage("18907131755", "735128", params);
        smsResponse.isSuccess();
    }

    @Test
    void testAliSendSingle() {
        SmsFactory.createSmsBlend(aliReadConfig, "ali");
        SmsBlend smsBlend = SmsFactory.getSmsBlend("ali");
        LinkedHashMap<String, String> params = new LinkedHashMap<>();
        params.put("code", "999888");
        params.put("time", "12");
        SmsResponse smsResponse = smsBlend.sendMessage("13997633453", "SMS_483440222", params);
        smsResponse.isSuccess();
    }
}

package cn.year.common.config;

import org.dromara.sms4j.aliyun.config.AlibabaConfig;
import org.dromara.sms4j.core.datainterface.SmsReadConfig;
import org.dromara.sms4j.provider.config.BaseConfig;
import org.dromara.sms4j.tencent.config.TencentConfig;

import java.util.List;

/**
 * @author YearOfTheRain
 * @create 2025-03-13  09:26
 */
public class AliReadConfig implements SmsReadConfig {
    @Override
    public BaseConfig getSupplierConfig(String configId) {
        AlibabaConfig alibabaConfig = new AlibabaConfig();
        alibabaConfig.setAccessKeyId("1112222");
        alibabaConfig.setAccessKeySecret("22221111");
        alibabaConfig.setConfigId("121212");
        alibabaConfig.setSignature("12122");
        return alibabaConfig;
    }

    @Override
    public List<BaseConfig> getSupplierConfigList() {
        return List.of();
    }
}

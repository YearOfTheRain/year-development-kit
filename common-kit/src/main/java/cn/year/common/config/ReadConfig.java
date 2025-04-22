package cn.year.common.config;

import org.dromara.sms4j.core.datainterface.SmsReadConfig;
import org.dromara.sms4j.provider.config.BaseConfig;
import org.dromara.sms4j.tencent.config.TencentConfig;

import java.util.List;

/**
 * @author YearOfTheRain
 * @create 2025-03-13  09:26
 */
public class ReadConfig implements SmsReadConfig {
    @Override
    public BaseConfig getSupplierConfig(String configId) {
        TencentConfig config = new TencentConfig();
//        config.setConfigId(configId);
        config.setAccessKeyId("1111");
        config.setAccessKeySecret("2222");
        config.setSignature("1221");
        config.setSdkAppId("1212212");
        return config;
    }

    @Override
    public List<BaseConfig> getSupplierConfigList() {
        return List.of();
    }
}

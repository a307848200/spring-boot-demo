package com.ated.o2o.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 各类域名Bean-组件类
 * @author zengwx
 * @version 1.0.0
 * @date 2019/09/25
 */
@Component
@ConfigurationProperties( prefix = "o2o.url" )
@Data
public class OmsProperties {

    /**o2o域名*/
    private String coreUrl;

    /**七牛资源域名*/
    private String qiNiuResourcesUrl;

}
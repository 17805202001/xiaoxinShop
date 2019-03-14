package com.czxy.xxs.config;


import com.czxy.xxs.util.RsaUtils;
import com.czxy.xxs.util.RsaUtils;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.security.PublicKey;

/**
 * @create: 2018-05-26 21:53
 **/


@Data
@ConfigurationProperties(prefix = "sc.jwt")

public class JwtProperties {


    private String pubKeyPath;// 公钥路径

    private PublicKey publicKey; // 公钥对象


    private static final Logger logger = LoggerFactory.getLogger(JwtProperties.class);

    @PostConstruct
    public void init(){
        try {
            // 获取公钥和私钥
            this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        } catch (Exception e) {
            logger.error("初始化公钥失败！", e);
            throw new RuntimeException();
        }
    }

}

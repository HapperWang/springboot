package com.xing.springboot_02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.HttpEncodingProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.filter.OrderedCharacterEncodingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Created by 汪东兴 on 2016-12-3.
 */
@Configuration
@EnableConfigurationProperties(HttpEncodingProperties.class) //开启属性注入
@ConditionalOnClass(CharacterEncodingFilter.class) //当CharacterEncodingFilter在类路径的条件下
@ConditionalOnProperty(prefix = "spring.http.encoding", value = "enabled", matchIfMissing = true) //当spring.http.encoding=enabled时，默认为true
public class HttpEncodingConfiguration {

    @Autowired
    private HttpEncodingProperties httpEncodingProperties; //

    @Bean
    @ConditionalOnMissingBean(CharacterEncodingFilter.class) //当容器中没有这个bean时创建此Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
        filter.setEncoding(this.httpEncodingProperties.getCharset().name());
        filter.setForceEncoding(this.httpEncodingProperties.isForce());
        return filter;
    }
}

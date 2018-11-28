package com.wxq.modelspringboot.common.configBean;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configurable
@PropertySource("classpath:extraConfigs/configTest1.properties")
@ConfigurationProperties(prefix = "com.test1")
public class ConfigTest1Properties {

    private String name;
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

package com.xing.springboot_01.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 汪东兴 on 2016-12-01.
 */
@Component
@ConfigurationProperties(prefix = "book")
public class BookYamlBean {

    private String author;

    private String name;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

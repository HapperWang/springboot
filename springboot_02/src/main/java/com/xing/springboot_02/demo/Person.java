package com.xing.springboot_02.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 汪东兴 on 2016-12-01.
 */
//@Component
//@ConfigurationProperties(prefix = "person", locations = {"classpath:config/application.properties"}) //加载配置文件
public class Person {
    private String name;

    private int age;

    private String six;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSix() {
        return six;
    }

    public void setSix(String six) {
        this.six = six;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String six) {
        this.name = name;
        this.age = age;
        this.six = six;
    }
}

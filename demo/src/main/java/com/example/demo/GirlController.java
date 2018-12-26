package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({ ConfigBean.class })
public class GirlController {

    // 自定义属性
    @Value("${girl.name}")
    private String name;
    @Value("${girl.age}")
    private Integer age;
    @GetMapping("/girlName")
    public String getName() {
        return name + ":" + age + ":" ;
    }

    // 配置文件的属性赋给实体类
    @Autowired
    ConfigBean configBean;
    @GetMapping("/my")
    public String getMy() {
        return configBean.toString();
    }

    // 自定义配置文件属性给实体类
    @Autowired
    UserBean userBean;
    @GetMapping("/user")
    public String getUser() {
        return userBean.toString();
    }

}

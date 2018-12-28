package com.wxq.modelspringboot;

import com.wxq.modelspringboot.common.base.BaseRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ServletComponentScan   //启动器启动时，扫描本目录以及子目录带有的webservlet注解的
@EnableJpaRepositories(basePackages = {}, repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class ModelSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelSpringbootApplication.class, args);
    }
}

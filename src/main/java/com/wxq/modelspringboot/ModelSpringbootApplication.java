package com.wxq.modelspringboot;

import com.wxq.modelspringboot.common.base.BaseRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {}, repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class ModelSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelSpringbootApplication.class, args);
    }
}

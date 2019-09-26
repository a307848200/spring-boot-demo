package com.ated.o2o;

import com.ated.o2o.filter.InitFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.Filter;


/** 开启EntityListeners 注解 */
@EnableJpaAuditing
/** 开启swagger */
@EnableSwagger2
/** 开启实体类扫描 */
@EntityScan(basePackages={"com.ated.o2o.entity"})
/**
 * @author zengwx
 */
@SpringBootApplication
public class O2oApplication {

    @Bean(name = "initFilter")
    public Filter initFilter() {
        return new InitFilter();
    }

    @Bean
    public FilterRegistrationBean initFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(initFilter());
        registration.setName("initFilter");
        // 过滤器从小到大依次执行
        registration.setOrder(1);
        return registration;
    }

    /**解决懒加载无法触发的问题*/
    @Bean
    public OpenEntityManagerInViewFilter openEntityManagerInViewFilter() {
        return new OpenEntityManagerInViewFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(O2oApplication.class, args);
    }

}

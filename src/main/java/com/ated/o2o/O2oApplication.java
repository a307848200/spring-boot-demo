package com.ated.o2o;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zengwx
 */

@EnableSwagger2
@EntityScan(basePackages={"com.ated.o2o.entity"})
@SpringBootApplication
public class O2oApplication {

    public static void main(String[] args) {
        SpringApplication.run(O2oApplication.class, args);
    }

}

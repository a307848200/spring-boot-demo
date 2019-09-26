package com.ated.o2o;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Web程序启动类(创建这个类的作用是为了打war包而使用的)
 * @author zengwx
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(O2oApplication.class);
	}

}

package com.ated.o2o.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * SpringMVC 配置类
 * @author zengwx
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

//    /**
//     * 快速解决页面转向问题
//     * @param registry
//     */
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index.html");
////    	registry.addViewController("/error").setViewName("/index.html");
//    }

    /**
     * 静态资源访问地址修改
     * @param registry ResourceHandlerRegistry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/web/");
//        registry.addResourceHandler("/static/**")
//            .addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("swagger-ui.html")
//            .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

//    @Bean
//    public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(
//            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        objectMapper.getSerializerProvider().setNullValueSerializer(
//            new JsonSerializer<Object>() {
//                @Override
//                public void serialize(Object value, JsonGenerator jgen,
//                                      SerializerProvider provider) throws IOException,
//                    JsonProcessingException {
//                    jgen.writeString("");
//                }
//            });
//        // 进行HTML解码
//        objectMapper.registerModule(new SimpleModule().addSerializer(
//            String.class, new JsonSerializer<String>() {
//                @Override
//                public void serialize(String value, JsonGenerator jgen,
//                                      SerializerProvider provider) throws IOException,
//                    JsonProcessingException {
//                    jgen.writeString(StringEscapeUtils.unescapeHtml(value));
//                }
//            }));
//        jsonConverter.setObjectMapper(objectMapper);
//        return jsonConverter;
//    }
//
//    @Override
//    public void configureMessageConverters(
//        List<HttpMessageConverter<?>> converters) {
//        converters.add(customJackson2HttpMessageConverter());
//        super.addDefaultHttpMessageConverters(converters);
//    }
//
//    /**
//     * 配置servlet处理
//     */
//    @Override
//    public void configureDefaultServletHandling(
//        DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }


//    /**
//     * 跨域配置
//     * 默认设置全局跨域配置
//     * TODO: 部署服务器需要注释掉。因为，nginx已配置跨域。否则会起冲突
//     *
//     * @param registry Corsregistry
//     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedHeaders("*").allowedMethods("*").allowedOrigins("*");
//        super.addCorsMappings(registry);
//    }
}

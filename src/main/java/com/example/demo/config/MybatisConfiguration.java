//package com.example.demo.config;
//
//import com.github.pagehelper.PageInterceptor;
//import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MybatisConfiguration {
//    @Bean
//    public PageInterceptor providerPageInterceptor() {
//        return new PageInterceptor();
//    }
//
//    @Bean
//    public ConfigurationCustomizer providerConfigurationCustomizer() {
//        return configuration -> {
//            configuration.setMapUnderscoreToCamelCase(true);//驼峰命名规则
//            configuration.addInterceptor(providerPageInterceptor());//添加分页插件
//        };
//    }
//}

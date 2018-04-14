package ru.itis.affection.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan({"ru.itis.ru.itis.affection.controllers", "ru.itis.ru.itis.affection.services",
        "ru.itis.ru.itis.affection.repositories", "ru.itis.ru.itis.affection.services.implementations"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setRedirectContextRelative(false);
        return resolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/profile").setViewName("profile");
        registry.addViewController("/home").setViewName("welcome");
        registry.addViewController("/tests").setViewName("tests");
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setCacheSeconds(0);
        messageSource.setUseCodeAsDefaultMessage(false);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
//
//    @Bean
//    public LocaleResolver localeResolver() {
//        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//        localeResolver.setDefaultLocale(new Locale("ru"));
//        return localeResolver;
//    }
//
//    @Bean
//    public LocaleChangeInterceptor localeInterceptor() {
//        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
//        interceptor.setParamName("lang");
//        return interceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeInterceptor());
//    }


}


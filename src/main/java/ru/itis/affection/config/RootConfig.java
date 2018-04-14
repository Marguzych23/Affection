package ru.itis.affection.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"ru.itis.affection.services", "ru.itis.affection.services.implementations"})
public class RootConfig {

}

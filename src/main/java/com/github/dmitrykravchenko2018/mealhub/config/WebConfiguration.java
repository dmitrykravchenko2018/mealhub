package com.github.dmitrykravchenko2018.mealhub.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.github.dmitrykravchenko2018.mealhub")
public class WebConfiguration {
}
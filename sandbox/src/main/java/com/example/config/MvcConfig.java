package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// Spring のいろいろな設定をコード上で行うためのアノテーション
@Configuration
// Spring Boot で WebMvcConfigurerAdapter の子クラスを作成する場合は、
// @EnableWebMvc は不要。AutoConfigure の一部が無効になる。
public class MvcConfig extends WebMvcConfigurerAdapter
{
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        // registry.addViewController("/login").setViewName("login");
    }
}

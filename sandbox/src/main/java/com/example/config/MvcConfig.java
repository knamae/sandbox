package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// Spring �̂��낢��Ȑݒ���R�[�h��ōs�����߂̃A�m�e�[�V����
@Configuration
// Spring Boot �� WebMvcConfigurerAdapter �̎q�N���X���쐬����ꍇ�́A
// @EnableWebMvc �͕s�v�BAutoConfigure �̈ꕔ�������ɂȂ�B
public class MvcConfig extends WebMvcConfigurerAdapter
{
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/login").setViewName("login");
    }
}

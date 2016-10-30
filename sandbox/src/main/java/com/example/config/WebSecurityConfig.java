package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.service.UserInfoService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                // �A�N�Z�X�����̐ݒ�
                // static�f�B���N�g���ɂ���A'/css/','fonts','/js/'�͐����Ȃ�
                .antMatchers("/css/**", "/fonts/**", "/js/**").permitAll()
                // '/admin/'�Ŏn�܂�URL�ɂ́A'ADMIN'���[���̂݃A�N�Z�X��
                .antMatchers("/admin/**").hasRole("ADMIN")
                // ���͐����Ȃ�
                .anyRequest().authenticated().and()
                // ���O�C�������̐ݒ�
                .formLogin()
                // ���O�C��������URL
                .loginPage("/login")
                // username�̃p�����^��
                .usernameParameter("user")
                // password�̃p�����^��
                .passwordParameter("pass").permitAll().and()
                // ���O�A�E�g�����̐ݒ�
                .logout()
                // ���O�A�E�g������URL
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                // ���O�A�E�g�������̑J�ڐ�URL
                .logoutSuccessUrl("/login")
                // ���O�A�E�g���ɍ폜����N�b�L�[��
                .deleteCookies("JSESSIONID")
                // ���O�A�E�g���̃Z�b�V�����j����L����
                .invalidateHttpSession(true).permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userInfoService);
    }
}

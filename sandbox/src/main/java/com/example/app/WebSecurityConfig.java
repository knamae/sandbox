package com.example.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                // �A�N�Z�X�����̐ݒ�
                .antMatchers("/css/**").permitAll().anyRequest().authenticated()
                // ���O�C������
                .and()
                // ���O�C�������̐ݒ�
                .formLogin()
                // ���O�C��������URL
                .loginPage("/login")
                // �p�����[�^��
                .usernameParameter("user").passwordParameter("pass").permitAll()
                // ���O�A�E�g����
                .and()
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
        // �C���������Ń��[�U�[�F�؂�����
        auth.inMemoryAuthentication()
                // ���[�U�[
                .withUser("user").password("pass").roles("USER");
    }
}

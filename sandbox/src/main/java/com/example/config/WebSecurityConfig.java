package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.service.UserInfoService;
import com.example.web.LoginController;
import com.example.web.LogoutController;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.authorizeRequests()
                // アクセス権限の設定
                // staticディレクトリにある、'/css/','fonts','/js/'は制限なし
                .antMatchers("/css/**", "/fonts/**", "/js/**").permitAll()
                // '/admin/'で始まるURLには、'ADMIN'ロールのみアクセス可
                // .antMatchers("/admin/**").hasRole("ADMIN")
                // 他は制限なし
                .anyRequest().authenticated().and()
                // ログイン処理の設定
                .formLogin()
                // ログイン処理のURL
                .loginPage(LoginController.PAGE)
                // usernameのパラメタ名
                .usernameParameter("user")
                // passwordのパラメタ名
                .passwordParameter("pass").permitAll().and()
                // ログアウト処理の設定
                .logout()
                // ログアウト処理のURL
                .logoutRequestMatcher(new AntPathRequestMatcher(LogoutController.PAGE))
                // ログアウト成功時の遷移先URL
                .logoutSuccessUrl(LoginController.PAGE)
                // ログアウト時に削除するクッキー名
                .deleteCookies("JSESSIONID")
                // ログアウト時のセッション破棄を有効化
                .invalidateHttpSession(true).permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception
    {
        authenticationManagerBuilder.userDetailsService(userInfoService);
    }
}

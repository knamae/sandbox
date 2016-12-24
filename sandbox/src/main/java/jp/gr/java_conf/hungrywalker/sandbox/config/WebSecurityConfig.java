package jp.gr.java_conf.hungrywalker.sandbox.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import jp.gr.java_conf.hungrywalker.sandbox.web.LoginController;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.authorizeRequests()
                // アクセス権限の設定
                // staticディレクトリにある、'/css/','fonts','/js/'は制限なし
                .antMatchers("/css/**", "/fonts/**", "/js/**").permitAll()
                // 他は制限なし
                .anyRequest().authenticated();

        // ログイン処理の設定
        httpSecurity.formLogin()
                // ログイン処理のURL
                .loginPage(LoginController.PAGE)
                // usernameのパラメタ名
                .usernameParameter("user")
                // passwordのパラメタ名
                .passwordParameter("pass").permitAll().and();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception
    {
        authenticationManagerBuilder.userDetailsService(this.userDetailsService);
    }

    @Autowired
    public void setUserInfoService(UserDetailsService userDetailsService)
    {
        this.userDetailsService = userDetailsService;
    }
}

package com.example.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

// JPA Java Persistent API

// Entity クラス
// http://qiita.com/ughirose/items/5d691adc677aa08636b8
@Entity
// Lombok(ロンボック)
// アノテーションをつけるだけで、getter, setter, toString, equals などの
// 何度も書くコードをコンパイル時に自動生成してくれる
@Data
// テーブル名
@Table(name = "user_info")
public class UserInfoEntity implements UserDetails
{
    private static final long serialVersionUID = 5983010622161900398L;

    public enum Authority
    {
        ROLE_USER, ROLE_ADMIN
    };

    @Id // 主キー
    @GeneratedValue(strategy = GenerationType.AUTO) // 自動採番（DBのidentityを利用）
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(authority.toString()));

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}

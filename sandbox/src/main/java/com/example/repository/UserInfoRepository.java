package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.UserInfoEntity;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long>
{
    public UserInfoEntity findByUsername(String username);
}

package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// http://libro.tuyano.com/index2?id=4466003
// http://libro.tuyano.com/index3?id=12186003
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long>
{
    public UserInfoEntity findByUsername(String username);
}

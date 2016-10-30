package com.example.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.UserInfoEntity;
import com.example.repository.UserInfoRepository;

@Service
public class UserInfoService implements UserDetailsService
{
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        if (StringUtils.isEmpty(username))
        {
            throw new UsernameNotFoundException("Username is empty");
        }

        UserInfoEntity userInfo = userInfoRepository.findByUsername(username);
        if (userInfo == null)
        {
            throw new UsernameNotFoundException("User not found for name : " + username);
        }

        return userInfo;
    }
}

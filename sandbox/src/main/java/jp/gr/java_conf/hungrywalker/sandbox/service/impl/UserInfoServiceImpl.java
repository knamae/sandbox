package jp.gr.java_conf.hungrywalker.sandbox.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.gr.java_conf.hungrywalker.sandbox.entity.MemberEntity;
import jp.gr.java_conf.hungrywalker.sandbox.repository.MemberRepository;

@Service
public class UserInfoServiceImpl implements UserDetailsService
{
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        if (StringUtils.isEmpty(username))
        {
            throw new UsernameNotFoundException("");
        }

        MemberEntity memberEntity = this.memberRepository.findByUsername(username);
        if (memberEntity == null)
        {
            throw new UsernameNotFoundException("");
        }

        return memberEntity;
    }

    @Autowired
    public void setUserInfoRepository(MemberRepository userInfoRepository)
    {
        this.memberRepository = userInfoRepository;
    }
}

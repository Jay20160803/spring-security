package com.jk51.springsecurity.service;

import com.jk51.springsecurity.DAO.User;
import com.jk51.springsecurity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userMapper.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException(String.format("user not found by username %s",username));
        }
        return null;
    }
}

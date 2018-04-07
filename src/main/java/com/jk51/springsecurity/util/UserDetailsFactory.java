package com.jk51.springsecurity.util;

import com.jk51.springsecurity.DAO.Role;
import com.jk51.springsecurity.DAO.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsFactory {

    private UserDetailsFactory(){}

    public static UserDetail creater(User user){

        return new UserDetail(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                listToGrantedAuthorities(user.getRoleList()),
                user.getEnabled()==1?true:false,
                user.getUpdateTime()
        );
    }

    private static List<GrantedAuthority> listToGrantedAuthorities(List<Role> roleList){

        return roleList.stream()
                .map(role->new SimpleGrantedAuthority(role.getRole_name()))
                .collect(Collectors.toList());
    }

}

package com.datingapp.auth.security;

import com.datingapp.auth.data.entity.AppUser;
import com.datingapp.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userService.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username:  " + username + " not found"));
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_" + user.getUserRole());
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
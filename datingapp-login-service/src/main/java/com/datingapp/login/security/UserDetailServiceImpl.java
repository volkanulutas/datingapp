package com.datingapp.login.security;

import com.datingapp.login.data.dto.UserDto;
import com.datingapp.login.feign.UserServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserServiceInterface userServiceInterface;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = null;
        try {
            ResponseEntity<UserDto> responseEntity = userServiceInterface.findUserByUsername(username);
            if (HttpStatus.OK.equals(responseEntity.getStatusCodeValue())) {
                userDto = responseEntity.getBody();
                List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList("ROLE_" + userDto.getUserRole());
                return new User(userDto.getUsername(), userDto.getPassword(), grantedAuthorities);
            } else {
                log.info("User is not authenticated because of connection error of datingapp-user-service");
            }
        } catch (Exception ex) {
            log.error("Error is occurred while finding user by username through datingapp-user-service. Detail: ", ex);
        }
        return null;
    }
}

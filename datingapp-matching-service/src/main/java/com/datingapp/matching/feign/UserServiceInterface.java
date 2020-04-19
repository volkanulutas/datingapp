package com.datingapp.matching.feign;

import com.datingapp.matching.constant.WebResourceConstants;
import com.datingapp.matching.data.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created on 12.04.2020
 *
 * @author volkanulutas
 */
@FeignClient(name = WebResourceConstants.USER_SERVICE)
@Service
public interface UserServiceInterface {

    @RequestMapping(value = WebResourceConstants.FIND_USER_BY_USERNAME, method = RequestMethod.GET)
    ResponseEntity<UserDto> findUserByUsername(@RequestParam String username);
}

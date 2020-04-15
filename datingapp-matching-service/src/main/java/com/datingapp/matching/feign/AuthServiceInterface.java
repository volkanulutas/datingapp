package com.datingapp.matching.feign;

import com.datingapp.matching.constant.WebResourceConstants;
import com.datingapp.matching.data.dto.AvailableUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created on 12.04.2020
 *
 * @author volkanulutas
 */
@FeignClient(name = WebResourceConstants.AUTH_SERVICE)
@Service
@RequestMapping("/")
public interface AuthServiceInterface {

    @RequestMapping(value = WebResourceConstants.FETCH_AVAILABLE_USER_FROM_AUTH_SERVICE)
    Optional<AvailableUserDto> fetchAvailableUsers();
}

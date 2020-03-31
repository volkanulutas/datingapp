package com.datingapp.matching.feign;

import com.datingapp.matching.constant.WebResourceConstants;
import com.datingapp.matching.data.dto.authservice.AvailableMatchingUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@FeignClient(name = WebResourceConstants.AUTH_SERVICE)
@Service
@RequestMapping("/")
public interface AuthServiceInterface {

    @RequestMapping(value = WebResourceConstants.FETCH_MATCHING_USER_FROM_AUTH_SERVICE)
    Optional<AvailableMatchingUserDto> fetchAvailableMatchingUsers();
}

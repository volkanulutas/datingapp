package com.eureka.demo1.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created on 12.04.2020
 *
 * @author volkanulutas
 */
/*@FeignClient(name = )
@Service
@RequestMapping("/")
*/
public interface DemoServiceInterface {

   /* @RequestMapping(value = WebResourceConstants.FETCH_AVAILABLE_USER_FROM_AUTH_SERVICE)
    Optional<AvailableUserDto> fetchAvailableUsers();

    */
}

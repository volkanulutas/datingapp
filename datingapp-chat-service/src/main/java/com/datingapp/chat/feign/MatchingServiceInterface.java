package com.datingapp.chat.feign;


import com.datingapp.chat.constant.WebResourceConstants;
import com.datingapp.chat.data.dto.MatchUserDto;
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
@FeignClient(name = WebResourceConstants.MATCHING_SERVICE)
@Service
public interface MatchingServiceInterface {

    @RequestMapping(value = WebResourceConstants.MATCH_LIST, method = RequestMethod.GET)
    ResponseEntity<MatchUserDto> getMatchUsersByUsername(@RequestParam String username);
}

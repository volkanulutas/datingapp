package com.datingapp.game.service.feignInterface;


import com.datingapp.game.data.dto.QuestionAnsweredDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Datingapp on 19.03.2020
 *
 * @author onurcanyozgat
 */
//@FeignClient(name = "APIGATEWAY_SERVICE")
//@Service
//@RequestMapping(value = "/api")
public interface ApiGatewayInterface {

    @RequestMapping(value = "sendAnswerToOtherParticipant")
    void sendAnswerToOtherParticipant(@RequestBody QuestionAnsweredDto questionAnsweredDto);
}

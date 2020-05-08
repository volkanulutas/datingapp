package com.datingapp.matching.startup;

import com.datingapp.matching.service.MatchingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Slf4j
@Component
public class MatchingApplicationStartup {

    @Autowired
    private MatchingService matchingService;

    @EventListener
    public void applicationInitialized(ApplicationReadyEvent event) {
        matchingService.matchUsers("volkan", "onurcan");
    }
}

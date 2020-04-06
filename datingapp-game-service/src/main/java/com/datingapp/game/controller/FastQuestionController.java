package com.datingapp.game.controller;

import com.datingapp.game.data.dto.FastQuestionDto;
import com.datingapp.game.service.FastQuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 06.04.2020
 *
 * @author onurcanyozgat
 */

@RestController
@RequestMapping(value = "/fastQuestion")
public class FastQuestionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FastQuestionController.class);

    @Autowired
    private FastQuestionService questionService;

    @PostMapping(value = "/save")
    public FastQuestionDto save(@RequestBody FastQuestionDto questionDto) {
        return questionService.save(questionDto);
    }

    @PostMapping(value = "/saveAll")
    public List<FastQuestionDto> save(@RequestBody List<FastQuestionDto> questionList) {
        return questionService.saveAll(questionList);
    }

}

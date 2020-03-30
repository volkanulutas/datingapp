package com.datingapp.game.service;

import com.datingapp.game.data.dto.FastQuestionDto;

import java.util.List;

/**
 * Created on 27.03.2020
 *
 * @author onurcanyozgat
 */

public interface FastQuestionService {

    FastQuestionDto save(FastQuestionDto dto);

    List<FastQuestionDto> saveAll(List<FastQuestionDto> dtoList);

    FastQuestionDto findById(Long id);

    List<FastQuestionDto> getRandomQuestions(int number);

}

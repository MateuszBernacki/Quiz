package com.quiztest.Quiz.service;


import com.quiztest.Quiz.dto.CategoryiesDto;
import com.quiztest.Quiz.dto.QuestionsDto;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Log
public class QuizDataService {

    public void getQuizDataService() {
        RestTemplate restTemplate = new RestTemplate();
        CategoryiesDto result = restTemplate.getForObject("https://opentdb.com/api_category.php", CategoryiesDto.class);
        log.info("Quize categories: " + result.getCategories());
    }

    public void getQuizQuestions() {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromHttpUrl("https://opentdb.com/api.php")
                .queryParam("amount", 2)
                .queryParam("category", 25)
                .queryParam("difficulty", "medium")
                .build().toUri();

        QuestionsDto result = restTemplate.getForObject(uri, QuestionsDto.class);
        log.info("Quiz questions: " + result.getResults());

    }
}

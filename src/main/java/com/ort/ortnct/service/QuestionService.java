package com.ort.ortnct.service;

import com.ort.ortnct.entity.Question;
import com.ort.ortnct.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService
{
    @Autowired
    QuestionRepository questionRepository;

    public Question createQuestionInDB(Question question)
    {
        return questionRepository.save(question);
    }
}

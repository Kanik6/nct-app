package com.ort.ortnct.service;

import com.ort.ortnct.entity.Answer;
import com.ort.ortnct.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService
{
    @Autowired
    AnswerRepository answerRepository;

    public Answer createOneAnswer(Answer answer)
    {
        return answerRepository.save(answer);
    }

    public List<Answer> createAnswerInDB(List<Answer> answers)
    {
        return answerRepository.saveAll(answers);
    }
}

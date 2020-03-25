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

    public Question updateQuestionInDB(Question question)
    {
        Question question1 = questionRepository.findById(question.getId()).
                map(e ->
                {
                    e.setAnswer(question.getAnswer());
                    e.setExplanation(question.getExplanation());
                    e.setTest(question.getTest());
                    e.setQuestion(question.getQuestion());
                    return questionRepository.save(e);
                })
                .
                orElseGet(() -> {return questionRepository.save(question);});
        return question1;
    }
}

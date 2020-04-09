package com.ort.ortnct.service;

import com.ort.ortnct.entity.Question;
import com.ort.ortnct.repository.QuestionRepository;
import com.ort.ortnct.util.ConvertoBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class QuestionService
{
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    ConvertoBase convertoBase;

    public Question createQuestionInDB(Question question)
    {
        return questionRepository.save(question);
    }

    public Question createQuestionInDBtest(Question question, MultipartFile image)
    {
        question.setImage(convertoBase.convertToBase64(image));
        return questionRepository.save(question);
    }

    public Question updateQuestionInDB(Question question)
    {
        Question question1 = questionRepository.findById(question.getId()).
                map(e ->
                {
                    e.setAnswer(question.getAnswer());
                    e.setExplanation(question.getExplanation());
                    e.setSubject(question.getSubject());
                    e.setQuestion(question.getQuestion());
                    e.setImage(question.getImage());
                    return questionRepository.save(e);
                })
                .
                orElseGet(() -> {return questionRepository.save(question);});
        return question1;
    }
}

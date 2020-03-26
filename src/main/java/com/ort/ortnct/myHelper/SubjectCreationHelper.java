package com.ort.ortnct.myHelper;

import com.ort.ortnct.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;

public class SubjectCreationHelper
{
    private Subject subject;
    private Question question;
    private List<Answer> answers;
    private SubCategory subCategory;

    public SubjectCreationHelper()
    {
    }

    public SubjectCreationHelper(Subject subject, Question question, List<Answer> answers, SubCategory subCategory)
    {
        this.subject = subject;
        this.question = question;
        this.answers = answers;
        this.subCategory = subCategory;
    }

    public Subject getSubject()
    {
        return subject;
    }

    public void setSubject(Subject subject)
    {
        this.subject = subject;
    }

    public Question getQuestion()
    {
        return question;
    }

    public void setQuestion(Question question)
    {
        this.question = question;
    }

    public List<Answer> getAnswers()
    {
        return answers;
    }

    public void setAnswers(List<Answer> answers)
    {
        this.answers = answers;
    }

    public SubCategory getSubCategory()
    {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory)
    {
        this.subCategory = subCategory;
    }
}

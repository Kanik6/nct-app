package com.ort.ortnct.controller;

import com.ort.ortnct.entity.Subject;
import com.ort.ortnct.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController
{
    @Autowired
    SubjectService subjectService;


}

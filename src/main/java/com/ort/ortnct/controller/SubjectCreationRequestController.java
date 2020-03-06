package com.ort.ortnct.controller;

import com.ort.ortnct.entity.Subject;
import com.ort.ortnct.myHelper.SubjectCreationHelper;
import com.ort.ortnct.service.SubjectCreationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SubjectCreationRequestController
{
    @Autowired
    SubjectCreationRequestService subjectCreationRequestService;


    //ADD FINAL TEST ORT
    @PostMapping("/subjectCreationRequestOF")
    public Subject subjectCreationRequestORTFinal(@RequestBody SubjectCreationHelper subjectCreationHelper)
    {
       return subjectCreationRequestService.addFinalTestORT(subjectCreationHelper);
    }

    //ADD SUBJECT TEST ORT
    @PostMapping("/subjectCreationRequestOS")
    public Subject subjectCreationRequestORTSubject(@RequestBody SubjectCreationHelper subjectCreationHelper)
    {
        return subjectCreationRequestService.addSubjectTestORT(subjectCreationHelper);
    }
}

package com.ort.ortnct.controller;

import com.ort.ortnct.entity.Subject;
import com.ort.ortnct.myHelper.SubjectCreationHelper;
import com.ort.ortnct.service.SubjectCreationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectCreationRequestController
{
    @Autowired
    SubjectCreationRequestService subjectCreationRequestService;


    @PostMapping("/subjectCreationRequest")
    public Subject subjectCreationRequest(@RequestBody SubjectCreationHelper subjectCreationHelper)
    {
       return subjectCreationRequestService.fillSubject(subjectCreationHelper);
    }
}

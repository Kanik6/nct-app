package com.ort.ortnct.controller;

import com.ort.ortnct.entity.Subject;
import com.ort.ortnct.myHelper.SubjectCreationHelper;
import com.ort.ortnct.service.SubjectCreationRequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(value = "Subject,test,question,answers", description = "REST API for Subject", tags = { "Subject" })
public class SubjectCreationRequestController
{
    @Autowired
    SubjectCreationRequestService subjectCreationRequestService;


    //ADD FINAL TEST ORT
    @ApiOperation(value="Create ORT final test", tags = { "Subject" })
    @PostMapping("/subjectCreationRequestOF")
    public Subject subjectCreationRequestORTFinal(@RequestBody SubjectCreationHelper subjectCreationHelper)
    {
       return subjectCreationRequestService.addFinalTestORT(subjectCreationHelper);
    }

    //ADD SUBJECT TEST ORT
    @ApiOperation(value="Create ORT subject test", tags = { "Subject" })
    @PostMapping("/subjectCreationRequestOS")
    public Subject subjectCreationRequestORTSubject(@RequestBody SubjectCreationHelper subjectCreationHelper)
    {
        return subjectCreationRequestService.addSubjectTestORT(subjectCreationHelper);
    }
}

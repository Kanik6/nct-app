package com.ort.ortnct.controller;

import com.ort.ortnct.dto.SubjectDto;
import com.ort.ortnct.entity.Subject;
import com.ort.ortnct.myHelper.SubjectCreationHelper;
import com.ort.ortnct.service.SubjectCreationRequestService;
//import com.ort.ortnct.util.ConverterService;
//import com.ort.ortnct.util.ConverterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@Api(value = "Subject,test,question,answers", description = "REST API for Subject", tags = { "Subject" })
public class SubjectCreationRequestController
{
    @Autowired
    SubjectCreationRequestService subjectCreationRequestService;

//    @Autowired
//    ConverterService converterService;

    //ADD FINAL TEST ORT
    @ApiOperation(value="Create ORT final test", tags = { "Subject" })
    @PostMapping("/subject/ort/final")
    public Subject subjectCreationRequestORTFinal(@RequestBody SubjectCreationHelper subjectCreationHelper)
    {
       return subjectCreationRequestService.addFinalTestORT(subjectCreationHelper);
    }

    //ADD SUBJECT TEST ORT
    @ApiOperation(value="Create ORT subject test", tags = { "Subject" })
    @PostMapping("/subject/ort/subject")
    public Subject subjectCreationRequestORTSubject(@RequestBody SubjectCreationHelper subjectCreationHelper)
    {
        return subjectCreationRequestService.addSubjectTestORT(subjectCreationHelper);
    }

    //Using MODEL MAPPER
//    @ApiOperation(value="Create ORT final test", tags = { "Subject" })
//    @PostMapping("/subjectCreationRequestOFMAP")
//    public Subject subjectCreationRequestORTFinalMAPPER(@RequestBody SubjectDto subjectDto)
//    {
//        Subject subject = converterService.convertToEnity(subjectDto);
//
//        return subjectCreationRequestService.addFinalTestORTMAPPER(subject);
//    }
}

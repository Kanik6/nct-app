package com.ort.ortnct.controller;

import com.ort.ortnct.entity.Subject;
import com.ort.ortnct.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Api(value = "Subject", description = "REST API for Subject", tags = { "Subject" })
public class SubjectController
{
    @Autowired
    SubjectService subjectService;

    @ApiOperation(value="get ort final basic subjects ", tags = { "Subject" })
    @GetMapping("/subjectListOrtBasic")
    public List<Subject> getListOrtBasicSubjects()
    {
        return subjectService.getListSubjectOrtBasic();
    }

    @ApiOperation(value="get ort final additional subjects ", tags = { "Subject" })
    @GetMapping("/subjectListOrtAdd")
    public List<Subject> getListOrtAddSubjects()
    {
        return subjectService.getListSubjectOrtAdd();
    }

    @ApiOperation(value="get ort subject ", tags = { "Subject" })
    @GetMapping("/subjectListOrtSubjects")
    public List<Subject> getListOrtSubjects()
    {
        return subjectService.getListSubjectOrt();
    }


}

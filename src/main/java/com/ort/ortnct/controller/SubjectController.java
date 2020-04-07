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

    //==========================================NCT SUBJECT
    @ApiOperation(value="get nct subject with grade5", tags = { "Subject" })
    @GetMapping("/subjectListNctSubjects5")
    public List<Subject> getListNctSubjects5()
    {
        return subjectService.getListSubjectNct5();
    }

    @ApiOperation(value="get nct subject with grade6", tags = { "Subject" })
    @GetMapping("/subjectListNctSubjects6")
    public List<Subject> getListNctSubjects6()
    {
        return subjectService.getListSubjectNct6();
    }

    @ApiOperation(value="get nct subject with grade7", tags = { "Subject" })
    @GetMapping("/subjectListNctSubjects7")
    public List<Subject> getListNctSubjects7()
    {
        return subjectService.getListSubjectNct7();
    }

    @ApiOperation(value="get nct subject with grade8", tags = { "Subject" })
    @GetMapping("/subjectListNctSubjects8")
    public List<Subject> getListNctSubjects8()
    {
        return subjectService.getListSubjectNct8();
    }

    @ApiOperation(value="get nct subject with grade9", tags = { "Subject" })
    @GetMapping("/subjectListNctSubjects9")
    public List<Subject> getListNctSubjects9()
    {
        return subjectService.getListSubjectNct9();
    }

    @ApiOperation(value="get nct subject with grade10", tags = { "Subject" })
    @GetMapping("/subjectListNctSubjects10")
    public List<Subject> getListNctSubjects10()
    {
        return subjectService.getListSubjectNct10();
    }

    @ApiOperation(value="get nct subject with grade11", tags = { "Subject" })
    @GetMapping("/subjectListNctSubjects11")
    public List<Subject> getListNctSubjects11()
    {
        return subjectService.getListSubjectNct11();
    }


}

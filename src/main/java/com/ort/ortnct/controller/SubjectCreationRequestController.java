package com.ort.ortnct.controller;

import com.ort.ortnct.dto.CreateRequestDto;
import com.ort.ortnct.entity.Answer;
import com.ort.ortnct.entity.Subject;
import com.ort.ortnct.myHelper.SubjectCreationHelper;
import com.ort.ortnct.service.AnswerService;
import com.ort.ortnct.service.SubjectCreationRequestService;
//import com.ort.ortnct.util.ConverterService;
//import com.ort.ortnct.util.ConverterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Api(value = "Create Request Subject", description = "REST API for create request Subject", tags = { "Create Request Subject" })
public class SubjectCreationRequestController
{
    @Autowired
    SubjectCreationRequestService subjectCreationRequestService;


    //ADD FINAL TEST ORT
    @ApiOperation(value="Create ORT final test", tags = { "Create Request Subject" })
    @PostMapping("/subject/ort/final")
    public Subject subjectCreationRequestORTFinal(@RequestPart("fullSub") SubjectCreationHelper subjectCreationHelper,
                                                  @RequestPart MultipartFile qImage,
                                                  @RequestPart MultipartFile[] aImage)
    {
       return subjectCreationRequestService.addFinalTestORT(subjectCreationHelper, qImage, aImage);
    }

    //ADD SUBJECT TEST ORT
    @ApiOperation(value="Create ORT subject test", tags = { "Create Request Subject" })
    @PostMapping("/subject/ort/subject")
    public Subject subjectCreationRequestORTSubject(@RequestPart("fullSub") SubjectCreationHelper subjectCreationHelper,
                                                    @RequestPart MultipartFile qImage,
                                                    @RequestPart MultipartFile[] aImage)
    {
        return subjectCreationRequestService.addSubjectTestORT(subjectCreationHelper, qImage, aImage);

    }

    //ADD SUBJECT TEST ORT
    @ApiOperation(value="Create NCT subject test", tags = { "Create Request Subject" })
    @PostMapping("/subject/nct/subject")
    public Subject subjectCreationRequestNCTSubject(@RequestPart("fullSub") SubjectCreationHelper subjectCreationHelper,
                                                    @RequestPart("qImage") MultipartFile qImage,
                                                    @RequestPart("aImage") MultipartFile[] aImage) throws IOException
    {
        return subjectCreationRequestService.addSubjectTestNCT(subjectCreationHelper, qImage, aImage);

    }


//    Using MODEL MAPPER
//    @ApiOperation(value="Create ORT final test", tags = { "Subject" })
//    @PostMapping("/subjectCreationRequestOFMAP")
//    public Subject subjectCreationRequestORTFinalMAPPER(@RequestBody CreateRequestDto createRequestDto)
//    {
//        return subjectCreationRequestService.addFinalTestORTMAPPER(createRequestDto);
//    }
}

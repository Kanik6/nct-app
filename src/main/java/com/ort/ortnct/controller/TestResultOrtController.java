package com.ort.ortnct.controller;

import com.ort.ortnct.entity.TestResultOrt;
import com.ort.ortnct.service.TestResultOrtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@Api(value = "Test result ORT", description = "REST API for Test result ORT", tags = { "Test result ORT" })
@RestController
public class TestResultOrtController
{
    @Autowired
    TestResultOrtService testResultOrtService;

    @ApiOperation(value="Create test result", tags = { "Test result ORT" })
    @PostMapping("/testResultOrt")
    public TestResultOrt createTestResultOrt(@RequestBody TestResultOrt testResultOrt)
    {
        return testResultOrtService.createTestResultOrt(testResultOrt);
    }

    @ApiOperation(value="get Test result ORT", tags = { "Test result ORT" })
    @GetMapping("/testResultOrt")
    public List<TestResultOrt> readTestResultOrt()
    {
        return testResultOrtService.getListTestResultOrt();
    }

    @ApiOperation(value="update Test result ORT", tags = { "Test result ORT" })
    @PutMapping("/testResultOrt")
    public TestResultOrt updateTestResultOrt(@RequestBody TestResultOrt testResultOrt)
    {
        return testResultOrtService.createTestResultOrt(testResultOrt);
    }

    @ApiOperation(value="delete Test result ORT", tags = { "Test result ORT" })
    @DeleteMapping("/testResultOrt")
    public String createTestResultOrt(@PathVariable("id") Long id)
    {
        return testResultOrtService.deleteTestResultOrt(id);
    }
}

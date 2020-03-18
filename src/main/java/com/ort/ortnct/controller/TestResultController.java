package com.ort.ortnct.controller;

import com.ort.ortnct.entity.TestResult;
import com.ort.ortnct.service.TestResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Api(value = "Test result", description = "REST API for Test result", tags = { "Test result" })
public class TestResultController
{
    @Autowired
    TestResultService testResultService;
    //=======================================CREATE
    @ApiOperation(value="Create test result", tags = { "Test result" })
    @PostMapping("/testResult")
    public TestResult createTestResult(@RequestBody TestResult testResult)
    {
        return testResultService.createTestResultIndDB(testResult);
    }

    //=======================================GET LIST TEST RESULT
    @ApiOperation(value="Get test result List", tags = { "Test result" })
    @GetMapping("/testResult")
    public List<TestResult> getListTestResult()
    {
        return testResultService.getListTestResult();
    }

    //=======================================UPDATE
    @ApiOperation(value="Update test result", tags = { "Test result" })
    @PutMapping("/testResult")
    public TestResult updateTestResultById(@RequestBody TestResult testResult,@PathVariable("id") Long id)
    {
        return testResultService.updateTestResult(testResult, id);
    }
    //=======================================DELETE
    @ApiOperation(value="Delete test result by id", tags = { "Test result" })
    @DeleteMapping("/testResult")
    public String deleteTestResultById(@PathVariable("id") Long id)
    {
        return testResultService.deleteTestResult(id);
    }
}

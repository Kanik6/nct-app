package com.ort.ortnct.controller;

import com.ort.ortnct.entity.TestResultNct;
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
    public TestResultNct createTestResult(@RequestBody TestResultNct testResultNct)
    {
        return testResultService.createTestResultIndDB(testResultNct);
    }

    //=======================================GET LIST TEST RESULT
    @ApiOperation(value="Get test result List", tags = { "Test result" })
    @GetMapping("/testResult")
    public List<TestResultNct> getListTestResult()
    {
        return testResultService.getListTestResult();
    }

    //=======================================UPDATE
    @ApiOperation(value="Update test result", tags = { "Test result" })
    @PutMapping("/testResult")
    public TestResultNct updateTestResultById(@RequestBody TestResultNct testResultNct, @PathVariable("id") Long id)
    {
        return testResultService.updateTestResult(testResultNct, id);
    }
    //=======================================DELETE
    @ApiOperation(value="Delete test result by id", tags = { "Test result" })
    @DeleteMapping("/testResult")
    public String deleteTestResultById(@PathVariable("id") Long id)
    {
        return testResultService.deleteTestResult(id);
    }
}

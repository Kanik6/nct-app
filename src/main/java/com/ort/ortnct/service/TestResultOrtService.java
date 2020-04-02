package com.ort.ortnct.service;

import com.ort.ortnct.entity.Subject;
import com.ort.ortnct.entity.TestResultNct;
import com.ort.ortnct.entity.TestResultOrt;
import com.ort.ortnct.entity.Usr;
import com.ort.ortnct.repository.TestResultOrtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestResultOrtService
{
    @Autowired
    TestResultOrtRepository testResultOrtRepository;

    @Autowired
    UsrService usrService;

    //============================================CREATE

    public TestResultOrt createTestResultOrt(TestResultOrt testResultOrt)
    {

        Usr usr = usrService.getUsr1(testResultOrt.getUsrId());
        testResultOrt.setUsr(usr);

        TestResultOrt testResultOrt1 = testResultOrtRepository.findByUser_id(testResultOrt.getUsrId())
                .map(e ->
                {
                    e.setScore(testResultOrt.getScore());
                    return testResultOrtRepository.save(e);
                })
                .orElseGet(() -> {return testResultOrtRepository.save(testResultOrt);});
        return testResultOrt1;
    }
    //============================================READ

    public List<TestResultOrt> getListTestResultOrt()
    {
        return testResultOrtRepository.findAll();
    }
    //============================================UPDATE

    public TestResultOrt updateTestResultOrtInDB(TestResultOrt testResultOrt)
    {
        TestResultOrt testResultOrt1 = testResultOrtRepository.findById(testResultOrt.getId())
                .map(e ->
                {
                    e.setScore(testResultOrt.getScore());
                    e.setUsrId(testResultOrt.getUsrId());
                    return testResultOrtRepository.save(e);
                })
                .orElseGet(() -> {return testResultOrtRepository.save(testResultOrt);});
        return testResultOrt1;
    }
    //============================================DELETE
    public String deleteTestResultOrt(Long id)
    {
        testResultOrtRepository.deleteById(id);
        return "deleted";
    }

}

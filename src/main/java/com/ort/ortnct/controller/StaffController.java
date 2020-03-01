package com.ort.ortnct.controller;

import com.ort.ortnct.entity.Staff;
import com.ort.ortnct.service.StaffService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StaffController
{
    @Autowired
    StaffService staffService;

    @PostMapping("/createStaff")
    public Staff createStaff(@RequestBody Staff staff, Authentication authentication)
    {
       return staffService.createStaffInDB(staff, authentication);
    }

    @GetMapping("/getStaff")
    public List<Staff> createStaff()
    {
        return staffService.getStaffFromDB();
    }

}

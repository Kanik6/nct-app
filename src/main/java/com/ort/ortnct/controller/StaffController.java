package com.ort.ortnct.controller;

import com.ort.ortnct.entity.Staff;
import com.ort.ortnct.service.StaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Staff", description = "REST API for Staff", tags = { "Staff" })
public class StaffController
{
    @Autowired
    StaffService staffService;

    @ApiOperation(value="Create Staff", tags = { "Staff" })
    @PostMapping("/createStaff")
    public Staff createStaff(@RequestBody Staff staff, Authentication authentication)
    {
       return staffService.createStaffInDB(staff, authentication);
    }

    @ApiOperation(value="Get list of Staff", tags = { "Staff" })
    @GetMapping("/getStaff")
    public List<Staff> getStaff()
    {
        return staffService.getStaffFromDB();
    }

}

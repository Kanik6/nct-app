package com.ort.ortnct.controller;

import com.ort.ortnct.dto.StaffDto;
import com.ort.ortnct.entity.Staff;
//import com.ort.ortnct.util.ConverterService;
import com.ort.ortnct.service.StaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@Api(value = "Staff", description = "REST API for Staff", tags = { "Staff" })
public class StaffController
{
    @Autowired
    StaffService staffService;

//    @Autowired
//    ConverterService converterService;

    @ApiOperation(value="Create Staff", tags = { "Staff" })
    @PostMapping("/staff")
    public Staff createStaff(@RequestBody Staff staff, Authentication authentication)
    {
       return staffService.createStaffInDB(staff, authentication);
    }



//    @ApiOperation(value="Get list of Staff", tags = { "Staff" })
//    @GetMapping("/getStaff")
//    public List<StaffDto> getStaff()
//    {
//        return staffService.getStaffFromDB().stream().map(converterService::convertToDto).collect(Collectors.toList());
//    }
    @ApiOperation(value="Get list of Staff", tags = { "Staff" })
    @GetMapping("/staff")
    public List<Staff> getStaff()
    {
        return staffService.getListStaffFromDB();
    }

    @ApiOperation(value="Update Staff", tags = { "Staff" })
    @PutMapping("/staff")
    public Staff updateStaff(@RequestBody Staff staff,@RequestParam Long id,  Authentication authentication)
    {
        return staffService.updateStaffInDB(staff, id, authentication);
    }

    @ApiOperation(value="Delete Staff", tags = { "Staff" })
    @DeleteMapping("/staff")
    public String deleteStaff(@RequestParam Long id)
    {
        return staffService.deleteStaffInDB(id);
    }
}

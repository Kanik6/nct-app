package com.ort.ortnct.controller;

import com.ort.ortnct.entity.Usr;
import com.ort.ortnct.service.UsrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "User", description = "REST API for User", tags = { "User" })
public class UsrController
{
    @Autowired
    UsrService usrService;

    @ApiOperation(value="Create User", tags = { "User" })
    @PostMapping(value = "/createUser")
    public Usr createUser(@RequestBody Usr usr)
    {
        return usrService.createUser(usr);
    }

    @ApiOperation(value="Get User", tags = { "User" })
    @GetMapping("/getUser/{user_id}")
    private Boolean getUsers(@PathVariable("user_id") String user_id)
    {
        return usrService.getUsr(user_id);
    }
}

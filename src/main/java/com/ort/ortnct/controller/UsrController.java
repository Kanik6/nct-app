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
@CrossOrigin(origins = "*")
public class UsrController
{
    @Autowired
    UsrService usrService;
    //==========================================CREATE
    @ApiOperation(value="Create User", tags = { "User" })
    @PostMapping(value = "/user")
    public Usr createUser(@RequestBody Usr usr)
    {
        return usrService.createUser(usr);
    }

    //==========================================READ
    @ApiOperation(value="Get User by id", tags = { "User" })
    @GetMapping("/user/{user_id}")
    private Boolean getUserById(@PathVariable("user_id") String user_id)
    {
        return usrService.getUsr(user_id);
    }

    //==========================================READ
    @ApiOperation(value="Get all users", tags = { "User" })
    @GetMapping("/user")
    private List<Usr> getUsers(@PathVariable("user_id") String user_id)
    {
        return usrService.getListUsr();
    }

    //==========================================UPDATE
    @ApiOperation(value="Update User by id", tags = { "User" })
    @PutMapping("/user")
    private Usr updateUser(@RequestBody Usr usr, @PathVariable("id") String user_id)
    {
        return usrService.updateUser(usr, user_id);
    }

    //==========================================DELETE
    @ApiOperation(value="Delete User by id", tags = { "User" })
    @DeleteMapping("/user")
    private String deleteUserById(@PathVariable("id") String user_id)
    {
        return usrService.deleteUsrFromDB(user_id);
    }

}

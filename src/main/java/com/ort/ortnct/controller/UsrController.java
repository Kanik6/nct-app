package com.ort.ortnct.controller;

import com.ort.ortnct.entity.Usr;
import com.ort.ortnct.service.UsrService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsrController
{
    @Autowired
    UsrService usrService;

    @PostMapping("/createUser")
    public Usr createUser(@RequestBody Usr usr)
    {
        return usrService.createUser(usr);
    }

    @GetMapping("/getUser/{user_id}")
    private Boolean getUsers(@PathVariable("user_id") String user_id)
    {
        return usrService.getUsr(user_id);
    }
}

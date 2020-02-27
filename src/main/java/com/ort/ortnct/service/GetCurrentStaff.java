package com.ort.ortnct.service;

import com.ort.ortnct.entity.Staff;
import com.ort.ortnct.entity.Usr;
import com.ort.ortnct.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class GetCurrentStaff
{
    @Autowired
    StaffRepository staffRepository;

    public Staff getCurrentStaff(Authentication authentication)
    {
        User currentStaff = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        Staff staff = staffRepository.findByFirstName(currentStaff.getUsername()).get();

        return staff;
    }
}


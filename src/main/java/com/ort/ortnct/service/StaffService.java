package com.ort.ortnct.service;

import com.ort.ortnct.entity.Role;
import com.ort.ortnct.entity.Staff;
import com.ort.ortnct.exception.NoSuchRoleException;
import com.ort.ortnct.repository.RoleRepository;
import com.ort.ortnct.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StaffService implements UserDetailsService
{
    @Autowired
    StaffRepository staffRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    GetCurrentStaff getCurrentStaff;

    @Autowired
    RoleRepository roleRepository;

    //==============================================================
    public Staff createStaffInDB(Staff staff, Authentication authentication)
    {
        Staff currentStaff = getCurrentStaff.getCurrentStaff(authentication);
        staff.setRelatedCategory(currentStaff.getRelatedCategory());

        Role role = roleRepository.findByName(staff.getPosition()).orElseThrow(() -> new NoSuchRoleException("There is no role:"+staff.getPosition()));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        staff.setRoles(roles);
        return staffRepository.save(staff);
    }

    public List<Staff> getStaffFromDB()
    {
        return staffRepository.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        Staff staff = staffRepository.findByFirstName(s).orElseThrow(() -> new UsernameNotFoundException("User was not found!"));


        List<String> roles = new ArrayList<>();

        staff.getRoles().stream().forEach(r -> roles.add(r.getName()));

        roles.forEach(e -> System.out.println(e));

        return User
                .withUsername(staff.getFirstName())
                .password(passwordEncoder.encode(staff.getPassword()))
                .roles(roles.toArray(new String[roles.size()]))
                .build();
    }
}

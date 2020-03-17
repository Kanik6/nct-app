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

    //==============================================================CREATE
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
    //==============================================================READ
    public List<Staff> getListStaffFromDB()
    {
        return staffRepository.findAll();
    }

    //==============================================================UPDATE
    public Staff updateStaffInDB(Staff staff, Long id, Authentication authentication)
    {
        Staff currentStaff = getCurrentStaff.getCurrentStaff(authentication);
        Role role = roleRepository.findByName(staff.getPosition()).orElseThrow(() -> new NoSuchRoleException("There is no role:"+staff.getPosition()));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        Staff staff1 = staffRepository.findById(id)
                .map(e ->
                {
                    e.setLogin(staff.getLogin());
                    e.setPassword(staff.getPassword());
                    e.setBirthDate(staff.getBirthDate());
                    e.setEmail(staff.getEmail());
                    e.setFirstName(staff.getFirstName());
                    e.setLastName(staff.getLastName());
                    e.setMale(staff.getMale());
                    e.setPhoneNumber(staff.getPhoneNumber());
                    e.setPosition(staff.getPosition());
                    e.setRelatedCategory(currentStaff.getRelatedCategory());
                    e.setRoles(roles);
                    return staffRepository.save(e);
                })
                .orElseGet(() -> {return staffRepository.save(staff);});
        return staff1;
    }
    //==============================================================DELETE
    public String deleteStaffInDB(Long id)
    {
        staffRepository.deleteById(id);
        return "deleted";
    }

    //==============================================================FOR SECURITY
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        Staff staff = staffRepository.findByLogin(s).orElseThrow(() -> new UsernameNotFoundException("User was not found!"));


        List<String> roles = new ArrayList<>();

        staff.getRoles().stream().forEach(r -> roles.add(r.getName()));

        return User
                .withUsername(staff.getLogin())
                .password(passwordEncoder.encode(staff.getPassword()))
                .roles(roles.toArray(new String[roles.size()]))
                .build();
    }
}

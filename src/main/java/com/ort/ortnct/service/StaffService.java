package com.ort.ortnct.service;

import com.ort.ortnct.dto.StaffDto;
import com.ort.ortnct.entity.Role;
import com.ort.ortnct.entity.Staff;
import com.ort.ortnct.exception.NoSuchRoleException;
import com.ort.ortnct.repository.RoleRepository;
import com.ort.ortnct.repository.StaffRepository;
import com.ort.ortnct.util.ConverterService;
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
import java.util.stream.Collectors;

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

    @Autowired
    ConverterService converterService;

    //==============================================================CREATE
    public StaffDto createStaffInDB(StaffDto staffDto, Authentication authentication)
    {
        Staff currentStaff = getCurrentStaff.getCurrentStaff(authentication);

        Staff staff = converterService.convertToEntity(staffDto);
        staff.setRelatedCategory(currentStaff.getRelatedCategory());

        Role role = roleRepository.findByName(staff.getPosition()).orElseThrow(() -> new NoSuchRoleException("There is no role:"+staff.getPosition()));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        staff.setRoles(roles);

        return converterService.convertToDto(staffRepository.save(staff));
    }
    //==============================================================READ
    public List<StaffDto> getListStaffFromDB()
    {
        return staffRepository.findAll().stream().map(converterService::convertToDto).collect(Collectors.toList());
    }

    //==============================================================UPDATE
    public StaffDto updateStaffInDB(StaffDto staffDto, Long id, Authentication authentication)
    {
        Staff currentStaff = getCurrentStaff.getCurrentStaff(authentication);
        Staff staff = converterService.convertToEntity(staffDto);

        Role role = roleRepository.findByName(staff.getPosition()).orElseThrow(() -> new NoSuchRoleException("There is no role:"+staff.getPosition()));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        StaffDto staff1 = staffRepository.findById(id)
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
                    return converterService.convertToDto(staffRepository.save(e));
                })
                .orElseGet(() ->
                {
                    return converterService.convertToDto(staffRepository.save(staff));
                });
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

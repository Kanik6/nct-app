package com.ort.ortnct.service;

import com.ort.ortnct.entity.Usr;
import com.ort.ortnct.repository.UsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsrService
{
    @Autowired
    UsrRepository usrRepository;

    public Usr createUser(Usr usr)
    {
       return usrRepository.save(usr);
    }

    public Boolean getUsr(String user_id)
    {
        return usrRepository.findById(user_id).isPresent();
    }
}

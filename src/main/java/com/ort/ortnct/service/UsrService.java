package com.ort.ortnct.service;

import com.ort.ortnct.entity.Usr;
import com.ort.ortnct.repository.UsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsrService
{
    @Autowired
    UsrRepository usrRepository;
    //==========================================CREATE

    public Usr createUser(Usr usr)
    {
       return usrRepository.save(usr);
    }

    //==========================================Find single user y id
    public Boolean getUsr(String user_id)
    {
        return usrRepository.findById(user_id).isPresent();
    }

    //==========================================Get User List
    public List<Usr> getListUsr()
    {
        return usrRepository.findAll();
    }

    //==========================================UPDATE
    public Usr updateUser(Usr usr, String id)
    {
        Usr usr1 = usrRepository.findById(id)
                .map(e ->
                {
                    e.setId(usr.getId());
                    e.setAge(usr.getAge());
                    e.setGrade(usr.getGrade());
                    e.setRegion(usr.getRegion());
                    e.setResult(usr.getResult());
                    e.setUsrAnswer(usr.getUsrAnswer());
                    return usrRepository.save(e);
                })
                .orElseGet(() -> {return usrRepository.save(usr);});

        return usr1;
    }

    //==========================================DELETE
    public String deleteUsrFromDB(String id)
    {
        usrRepository.deleteById(id);
        return "deleted";
    }
}

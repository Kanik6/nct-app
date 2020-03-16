package com.ort.ortnct.service;

import com.ort.ortnct.entity.EduMaterial;
import com.ort.ortnct.repository.EduMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduMaterialService
{
    @Autowired
    EduMaterialRepository eduMaterialRepository;

    //==================================CREATE
    public EduMaterial createEduMaterial(EduMaterial eduMaterial)
    {
        return eduMaterialRepository.save(eduMaterial);
    }
    //==================================READ
    public List<EduMaterial> getListEduMaterial()
    {
        return eduMaterialRepository.findAll();
    }
    //==================================UPDATE
    public EduMaterial updateEduMaterial(EduMaterial eduMaterial, Long id)
    {
        EduMaterial eduMaterial1 = eduMaterialRepository.findById(id)
                .map( e ->
                {
                    e.setSubjectName(eduMaterial.getSubjectName());
                    e.setContent(eduMaterial.getContent());
                    return eduMaterialRepository.save(e);
                })
                .orElseGet(() -> { return eduMaterialRepository.save(eduMaterial);});

        return eduMaterial1;
    }
    //==================================DELETE
    public String deleteEduMaterial(Long id)
    {
        eduMaterialRepository.deleteById(id);
        return "deleted";
    }
}

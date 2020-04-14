package com.ort.ortnct.controller;

import com.ort.ortnct.entity.EduMaterial;
import com.ort.ortnct.service.EduMaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@Api(value = "educational material", description = "REST API for educational material", tags = { "educational material" })
@CrossOrigin(origins = "*")
public class EduMaterialController
{
    @Autowired
    EduMaterialService eduMaterialService;

    @PostMapping("/eduMaterial")
    @ApiOperation(value="Create educational material", tags = { "educational material" })
    public EduMaterial createEduMat(@RequestBody EduMaterial eduMaterial)
    {
        return eduMaterialService.createEduMaterial(eduMaterial);
    }

    @GetMapping("/eduMaterial/{id}")
    @ApiOperation(value="get educational material by id", tags = { "educational material" })
    public EduMaterial getEduMaterialById(@PathVariable("id") Long id)
    {
        return eduMaterialService.getEduMaterialById(id);
    }

    @GetMapping("/eduMaterial")
    @ApiOperation(value="get all educational material", tags = { "educational material" })
    public List<EduMaterial> getListEduMat()
    {
        Locale currentLocale = LocaleContextHolder.getLocale();

        System.out.println("-------------------------------------------------->>>>>>"+currentLocale.getDisplayLanguage());
        System.out.println("-------------------------------------------------->>>>>>"+currentLocale.getDisplayCountry());

        System.out.println("-------------------------------------------------->>>>>>"+currentLocale.getLanguage());
        System.out.println("-------------------------------------------------->>>>>>"+currentLocale.getCountry());
        return eduMaterialService.getListEduMaterial();
    }

    @PutMapping("/eduMaterial")
    @ApiOperation(value="Update educational material", tags = { "educational material" })
    public EduMaterial updateEduMat(@RequestBody EduMaterial eduMaterial,@RequestParam Long id)
    {
        return eduMaterialService.updateEduMaterial(eduMaterial, id);
    }

    @DeleteMapping("/eduMaterial")
    @ApiOperation(value="delete educational material", tags = { "educational material" })
    public String deleteEduMat(@RequestParam Long id)
    {
        return eduMaterialService.deleteEduMaterial(id);
    }
}

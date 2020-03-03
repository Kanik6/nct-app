package com.ort.ortnct.service;

import com.ort.ortnct.entity.SubCategory;
import com.ort.ortnct.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService
{
    @Autowired
    SubCategoryRepository subCategoryRepository;

    public SubCategory getSubCategory(String name)
    {
        return subCategoryRepository.findBySubCategoryName(name);
    }
}

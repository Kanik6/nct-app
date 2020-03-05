package com.ort.ortnct.service;

import com.ort.ortnct.entity.SubCategory;
import com.ort.ortnct.enums.SubCategories;
import com.ort.ortnct.exception.NoSuchSubCategoryException;
import com.ort.ortnct.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService
{
    @Autowired
    SubCategoryRepository subCategoryRepository;

    public SubCategory getSubCategory(SubCategories subCategories)
    {
        return subCategoryRepository.findBySubCategoryName(subCategories)
                .orElseThrow(() -> new NoSuchSubCategoryException("No such sub category name!"));
    }
}

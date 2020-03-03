package com.ort.ortnct.repository;

import com.ort.ortnct.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long>
{
    SubCategory findBySubCategoryName(String name);
}

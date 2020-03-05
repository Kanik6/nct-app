package com.ort.ortnct.repository;

import com.ort.ortnct.entity.SubCategory;
import com.ort.ortnct.enums.SubCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long>
{
    Optional<SubCategory> findBySubCategoryName(SubCategories subCategories);
}

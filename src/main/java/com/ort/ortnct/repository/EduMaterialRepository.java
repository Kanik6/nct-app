package com.ort.ortnct.repository;

import com.ort.ortnct.entity.EduMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EduMaterialRepository extends JpaRepository<EduMaterial, Long>
{

}

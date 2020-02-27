package com.ort.ortnct.repository;

import com.ort.ortnct.entity.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewRepository extends JpaRepository<View, Long>
{

}

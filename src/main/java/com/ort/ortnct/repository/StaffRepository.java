package com.ort.ortnct.repository;

import com.ort.ortnct.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long>
{
    Optional<Staff> findByFirstName(String name);
}

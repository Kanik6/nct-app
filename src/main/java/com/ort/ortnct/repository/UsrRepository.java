package com.ort.ortnct.repository;

import com.ort.ortnct.entity.Usr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsrRepository extends JpaRepository<Usr, String>
{
    Optional<Usr> findById(String user_id);
}

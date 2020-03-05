package com.ort.ortnct.repository;

import com.ort.ortnct.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>
{
//    Optional<Subject> findByName(String name);
    @Query(value = "select * from subjects s" +
            " join subject_sub_category ssc on ssc.subject_id=s.subject_id" +
            " join sub_categories sc on sc.sub_category_id=ssc.sub_category_id" +
            " where s.subject_name = :subjectName and sc.sub_category_name = :subCategoryName", nativeQuery = true)
    Optional<Subject> findSubjectByNameAndSubCategory(@Param("subjectName") String subjectName, @Param("subCategoryName") String subCategoryName);
}

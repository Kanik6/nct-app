package com.ort.ortnct.repository;

import com.ort.ortnct.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    @Query(value = "select * from subjects s" +
            " join subject_sub_category ssc on ssc.subject_id=s.subject_id" +
            " join sub_categories sc on sc.sub_category_id=ssc.sub_category_id" +
            " where sc.sub_category_name = 'ORT_BASIC'", nativeQuery = true)
    Optional<List<Subject>> findAllOrtFinalBasicSubjects();

    @Query(value = "select * from subjects s" +
            " join subject_sub_category ssc on ssc.subject_id=s.subject_id" +
            " join sub_categories sc on sc.sub_category_id=ssc.sub_category_id" +
            " where sc.sub_category_name = 'ORT_ADD'", nativeQuery = true)
    Optional<List<Subject>> findAllOrtFinalAddSubjects();

    @Query(value = "select * from subjects s" +
            " join subject_sub_category ssc on ssc.subject_id=s.subject_id" +
            " join sub_categories sc on sc.sub_category_id=ssc.sub_category_id" +
            " where sc.sub_category_name = 'ORT_SUB'", nativeQuery = true)
    Optional<List<Subject>> findAllOrtSubjects();

    @Query(value = "select * from subjects s" +
            " join subject_sub_category ssc on ssc.subject_id=s.subject_id" +
            " join sub_categories sc on sc.sub_category_id=ssc.sub_category_id" +
            " where sc.sub_category_name = 'ORT_GRADE5'", nativeQuery = true)
    Optional<List<Subject>> findAllNctSubjectsGrade5();

    @Query(value = "select * from subjects s" +
            " join subject_sub_category ssc on ssc.subject_id=s.subject_id" +
            " join sub_categories sc on sc.sub_category_id=ssc.sub_category_id" +
            " where sc.sub_category_name = 'ORT_GRADE6'", nativeQuery = true)
    Optional<List<Subject>> findAllNctSubjectsGrade6();

    @Query(value = "select * from subjects s" +
            " join subject_sub_category ssc on ssc.subject_id=s.subject_id" +
            " join sub_categories sc on sc.sub_category_id=ssc.sub_category_id" +
            " where sc.sub_category_name = 'ORT_GRADE7'", nativeQuery = true)
    Optional<List<Subject>> findAllNctSubjectsGrade7();

    @Query(value = "select * from subjects s" +
            " join subject_sub_category ssc on ssc.subject_id=s.subject_id" +
            " join sub_categories sc on sc.sub_category_id=ssc.sub_category_id" +
            " where sc.sub_category_name = 'ORT_GRADE8'", nativeQuery = true)
    Optional<List<Subject>> findAllNctSubjectsGrade8();

    @Query(value = "select * from subjects s" +
            " join subject_sub_category ssc on ssc.subject_id=s.subject_id" +
            " join sub_categories sc on sc.sub_category_id=ssc.sub_category_id" +
            " where sc.sub_category_name = 'ORT_GRADE9'", nativeQuery = true)
    Optional<List<Subject>> findAllNctSubjectsGrade9();

    @Query(value = "select * from subjects s" +
            " join subject_sub_category ssc on ssc.subject_id=s.subject_id" +
            " join sub_categories sc on sc.sub_category_id=ssc.sub_category_id" +
            " where sc.sub_category_name = 'ORT_GRADE10'", nativeQuery = true)
    Optional<List<Subject>> findAllNctSubjectsGrade10();

    @Query(value = "select * from subjects s" +
            " join subject_sub_category ssc on ssc.subject_id=s.subject_id" +
            " join sub_categories sc on sc.sub_category_id=ssc.sub_category_id" +
            " where sc.sub_category_name = 'ORT_GRADE11'", nativeQuery = true)
    Optional<List<Subject>> findAllNctSubjectsGrade11();



}

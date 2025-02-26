package com.example.SrpingTestCourse.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query ("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);


    @Query("DELETE FROM Student s WHERE s.id = ?1")
    Optional<Student> deleteStudentById(Long id);
}



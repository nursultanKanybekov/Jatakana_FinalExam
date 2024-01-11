package com.jatakana.jatakana.repository;

import com.jatakana.jatakana.model.StudentsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepo extends JpaRepository<StudentsModel, Long> {
    @Query(value = "SELECT * FROM students_info ORDER BY point DESC LIMIT :limit", nativeQuery = true)
    List<StudentsModel> findByPoint(@Param("limit") int limit);

    @Query(value = "SELECT * FROM students_info ORDER BY point DESC", nativeQuery = true)
    List<StudentsModel> findByPoint();

}

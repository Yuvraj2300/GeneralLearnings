package com.lrn.springrestex_1.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lrn.springrestex_1.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}

package com.Test.RestDB.Reps;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Test.RestDB.entity.Student;

@Repository
public interface StudentRep extends	JpaRepository<Student, Serializable>{

}

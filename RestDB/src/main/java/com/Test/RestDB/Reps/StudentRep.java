package com.Test.RestDB.Reps;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Test.RestDB.entity.Student;

public interface StudentRep extends	JpaRepository<Student, Serializable>{

}

package com.neosoft.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.security.model.Student;


@Repository
public interface HomeRepository extends CrudRepository<Student, Integer>{

}

package com.neosoft.security.service;

import java.util.List;

import com.neosoft.security.model.Student;

public interface HomeService {


	public List<Student> listAll();
        
    public void saveAll(Student student);
     
    public Student get(int id);
	
}

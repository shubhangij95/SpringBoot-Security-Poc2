package com.neosoft.security.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.security.model.Student;
import com.neosoft.security.model.User;
import com.neosoft.security.service.HomeService;
import com.neosoft.security.service.UserServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class HomeController {
	
	
	@Autowired
	private HomeService hs;

	@Autowired
	private UserServiceImpl us;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getAll")
	public List<Student> getAll() {
		return hs.listAll();
	}

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@PostMapping("/saveall")
	public String saveStudent(@RequestBody Student student) {
		hs.saveAll(student);
		
		return "Student saved";

	}
	
	@PostMapping("/saveuser")
	public User saveUser(@RequestBody User u)
	{
		return us.SaveUser(u);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getsingle/{id}")
	public Student getSingle(@PathVariable int id) {
		return hs.get(id);

	}

	/*
	 * @RequestMapping("/") public String viewHomePage(Model model) { List<Student>
	 * slist = hs.listAll(); model.addAttribute("slist", slist);
	 * 
	 * return "index"; }
	 * 
	 * @RequestMapping("/new")
	 * 
	 * public String showNewStudentPage(Model model) {
	 * 
	 * Student student = new Student();
	 * 
	 * Projects proj=new Projects(); student.setProj((Set<Projects>) proj);
	 * 
	 * model.addAttribute("student", student);
	 * 
	 * return "new_student";
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * @RequestMapping(value = "/save", method = RequestMethod.POST) public String
	 * saveStudent(@ModelAttribute("student") Student student) {
	 * 
	 * hs.save(student);
	 * 
	 * return "redirect:/"; }
	 */

}

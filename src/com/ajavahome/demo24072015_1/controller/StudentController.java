package com.ajavahome.demo24072015_1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.servlet.ModelAndView;

import com.ajavahome.demo24072015_1.dto.request.StudentForm;
import com.ajavahome.demo24072015_1.dto.response.StudentFormRes;
import com.ajavahome.demo24072015_1.service.StudentService;


@RequestMapping("/oprations")
@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/addNumbers.htm")
	public String addNumbers() {
		return "transaction/add";
	}

	@RequestMapping(value = "/addNubersOpration.htm")
	public String addNumbersOpration(@RequestParam(value = "fno") int fno,
			@RequestParam(value = "sno") int sno, Model model) {
		int answer = fno + sno;
		model.addAttribute("ans", answer);
		model.addAttribute("fno", fno);
		model.addAttribute("sno", sno);
		System.out.println(fno + sno + answer);
		return "transaction/add";
	}

	@RequestMapping(value = "/addStudent.htm")
	public String addStudent() {
		return "transaction/addStudent";
	}

	@RequestMapping(value = "/addStudentOpration.htm")
	public ModelAndView addStudentOpration(Model model,
			HttpServletRequest request, HttpServletResponse response){
		ModelAndView modelAndView = null;
		try {
			modelAndView = new ModelAndView("transaction/addStudent");
			StudentForm studentForm=new StudentForm();
			studentForm.setsId("123");
			studentForm.setsName("Vivek");
			studentForm.setsAge("25");
			modelAndView.addObject("studentForm", studentForm);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}
	
/*	@RequestMapping(value = "/addStudentOprationForMVC.htm",method = RequestMethod.POST)
	public String addStudentOprationForMVC(@ModelAttribute("studentForm") StudentForm studentForm){
		String view = null;
		studentService.addStudent(studentForm);
		view = "redirect:/oprations/addStudentOpration.htm";
		return view;
	}*/
	
	@RequestMapping(value = "/addStudentOprationForMVC.htm", method = RequestMethod.POST)
	public ModelAndView addStudentOprationForMVC(
			@ModelAttribute("studentForm") StudentForm studentForm,
			@ModelAttribute("studentFormRes") StudentFormRes studentFormRes) {
		ModelAndView modelAndView = null;
		studentFormRes = studentService.addStudent(studentForm);
		modelAndView = new ModelAndView("transaction/addStudent2");
		modelAndView.addObject("studentFormRes", studentFormRes);
		return modelAndView;
	}
	
}

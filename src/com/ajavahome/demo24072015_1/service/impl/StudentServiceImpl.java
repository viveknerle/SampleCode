package com.ajavahome.demo24072015_1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajavahome.demo24072015_1.dao.StudentDao;
import com.ajavahome.demo24072015_1.dto.request.StudentForm;
import com.ajavahome.demo24072015_1.dto.response.StudentFormRes;
import com.ajavahome.demo24072015_1.service.StudentService;

@Service("StudentService")
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao studentDao;
	public StudentDao getStudentDao() {
		return studentDao;
	}
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public StudentFormRes addStudent(StudentForm studentForm) {
		
		studentForm.setsId("1001");
		studentForm.setsName("Vishal");
		studentForm.setsAge("21");
		StudentFormRes studentFormRes=studentDao.addStudent(studentForm);
		return studentFormRes;
	}

}

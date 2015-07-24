package com.ajavahome.demo24072015_1.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ajavahome.demo24072015_1.common.CommonSessionFactory;
import com.ajavahome.demo24072015_1.dao.StudentDao;
import com.ajavahome.demo24072015_1.dto.request.StudentForm;
import com.ajavahome.demo24072015_1.dto.response.StudentFormRes;

@Repository("StudentDao")
public class StudentDaoImpl extends CommonSessionFactory implements StudentDao{

	@Override
	public StudentFormRes addStudent(StudentForm studentForm) {
		StudentFormRes studentFormRes=new StudentFormRes();
		studentFormRes.setsId(studentForm.getsId());
		studentFormRes.setsName(studentForm.getsName());
		studentFormRes.setsAge("1000");
		
		Session session = null;
		session = getSession();
		
		return studentFormRes;
	}

}

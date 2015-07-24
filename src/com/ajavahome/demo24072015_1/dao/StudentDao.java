package com.ajavahome.demo24072015_1.dao;

import com.ajavahome.demo24072015_1.dto.request.StudentForm;
import com.ajavahome.demo24072015_1.dto.response.StudentFormRes;

public interface StudentDao {
	StudentFormRes addStudent(StudentForm studentForm);

}

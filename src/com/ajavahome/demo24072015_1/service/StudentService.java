package com.ajavahome.demo24072015_1.service;

import com.ajavahome.demo24072015_1.dto.request.StudentForm;
import com.ajavahome.demo24072015_1.dto.response.StudentFormRes;

public interface StudentService {
	StudentFormRes addStudent(StudentForm studentForm);

}

package com.gts.base.platform.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;
import com.gts.base.platform.dao.StudentDao;
import com.gts.base.platform.dao.entity.Student;
import com.gts.base.platform.service.StudentService;
import com.gts.base.platform.service.base.BaseService;
import com.gts.base.platform.service.bo.StudentBo;
import com.gts.framework.log.annotation.DigestLogAnnotated;
import com.gts.framework.log.enums.LoggerLevel;

@Service 
public class StudentServiceImpl extends BaseService implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	@DigestLogAnnotated(digestIdentificationCode = "gts", logFileName = "DEFAULT.DIG", loggerLevel = LoggerLevel.INFO)
	public int insertStudent(Student student) {
		try {
			return studentDao.insertStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	@DigestLogAnnotated(digestIdentificationCode = "gts", logFileName = "DEFAULT.DIG", loggerLevel = LoggerLevel.INFO)
	public int updateStudent(Student student) {
		try {
			return studentDao.updateStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	@DigestLogAnnotated(digestIdentificationCode = "gts", logFileName = "DEFAULT.DIG", loggerLevel = LoggerLevel.INFO)
	public List<StudentBo> listPageStudent(Student studentBo) {
		List<StudentBo> listBo = Lists.newArrayList();
		List<Student> list;
		try {
			list = studentDao.listPageStudent(studentBo);
			for(Student student : list){
				listBo.add((StudentBo) student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBo;
	}

	@Override
	@DigestLogAnnotated(digestIdentificationCode = "gts", logFileName = "DEFAULT.DIG", loggerLevel = LoggerLevel.INFO)
	public List<StudentBo> queryStudent(Student studentBo) {
		List<StudentBo> listBo = Lists.newArrayList();
		List<Student> list;
		try {
			list = studentDao.queryStudent(studentBo);
			for(Student student : list){
				listBo.add((StudentBo) student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBo;
	}

	@Override
	@DigestLogAnnotated(digestIdentificationCode = "gts", logFileName = "DEFAULT.DIG", loggerLevel = LoggerLevel.INFO)
	public StudentBo getStudent(String studentId) {
		try {
			return (StudentBo) studentDao.getStudent(studentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

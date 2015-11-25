package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.TeacherStudent;

/**
 * @Description: 教师-学生 关联关系多对多 信息数据访问接口
 * @ClassName: TeacherStudentDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:12:27
 */ 
public interface TeacherStudentDao {
	
	public int insertTeacherStudent(TeacherStudent teacherStudent) throws Exception;
	
	public int updateTeacherStudent(TeacherStudent teacherStudent) throws Exception;
	
	public List<TeacherStudent> listPageTeacherStudent(TeacherStudent teacherStudent) throws Exception;
	
	public List<TeacherStudent> queryTeacherStudent(TeacherStudent teacherStudent) throws Exception;
	
	public TeacherStudent getTeacherStudent(String id) throws Exception;
	
}

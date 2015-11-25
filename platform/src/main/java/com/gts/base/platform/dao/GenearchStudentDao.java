package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.GenearchStudent;

/**
 * @Description: 家长-学生 关联关系 数据访问接口
 * @ClassName: GenearchStudentDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:11:00
 */ 
public interface GenearchStudentDao {
	
	public int insertGenearchStudent(GenearchStudent genearchStudent) throws Exception;
	
	public int updateGenearchStudent(GenearchStudent genearchStudent) throws Exception;
	
	public List<GenearchStudent> listPageGenearchStudent(GenearchStudent genearchStudent) throws Exception;
	
	public List<GenearchStudent> queryGenearchStudent(GenearchStudent genearchStudent) throws Exception;
	
	public GenearchStudent getGenearchStudent(String id) throws Exception;
	
}

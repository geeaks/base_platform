package com.gts.base.platform.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gts.base.platform.dao.TestDao;
import com.gts.base.platform.dao.entity.Test_table;
import com.gts.base.platform.service.TestService;
import com.gts.framework.log.annotation.DigestLogAnnotated;
import com.gts.framework.log.enums.LoggerLevel;

@Service 
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestDao testDao;
	
	@DigestLogAnnotated(digestIdentificationCode = "gts", logFileName = "DEFAULT.DIG", loggerLevel = LoggerLevel.INFO)
	public int insertTest(Test_table test) throws Exception {
		return testDao.insertTest(test);
	}
	
	@DigestLogAnnotated(digestIdentificationCode = "gts", logFileName = "DEFAULT.DIG", loggerLevel = LoggerLevel.INFO)
	public List<Test_table> listPageTest(Test_table test) throws Exception {
		return testDao.listPageTest(test);
	}
	
}

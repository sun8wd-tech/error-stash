package com.celloud.errorstash;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.celloud.errorstash.model.Error;
import com.celloud.errorstash.model.QueryError;
import com.celloud.errorstash.service.ErrorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Autowired
	private ErrorService errorService;

	@Test
	public void contextLoads() {
		
		QueryError queryError=new QueryError();
		queryError.setUserId(12);
		queryError.setUsername("sunwd");
		queryError.setModule("errorStash");
		
		
		List<Error> list = errorService.findByQuery(queryError);
		
		System.out.println("***********"+list.size()+"*************");
		for (Error error : list) {
			System.out.println(error.getCreateTime());
		}
		
	}
	
	

}

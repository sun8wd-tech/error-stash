package com.celloud.errorstash;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.celloud.errorstash.model.Error;
import com.celloud.errorstash.model.QueryVo;
import com.celloud.errorstash.service.ErrorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Autowired
	private ErrorService errorService;

	@Test
	public void contextLoads() {
		
		QueryVo queryVo=new QueryVo();
	     queryVo.setUserId(12);
	     queryVo.setUsername("sunwd");
		queryVo.setModule("errorStash");
		queryVo.setStartTime("2017-12-19 12:20:18");
		queryVo.setEndTime("2017-12-19 12:45:32");
		List<Error> list = errorService.findByQuery(queryVo);
		
		System.out.println("***********"+list.size()+"*************");
		for (Error error : list) {
			System.out.println(error.getBrowser());
		}
		
	}
	
	

}

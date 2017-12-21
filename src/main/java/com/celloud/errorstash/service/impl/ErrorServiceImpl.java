package com.celloud.errorstash.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.celloud.errorstash.config.StringToDateConverter;
import com.celloud.errorstash.model.Error;
import com.celloud.errorstash.model.QueryVo;
import com.celloud.errorstash.repository.ErrorRepository;
import com.celloud.errorstash.service.ErrorService;


/**
 * 异常信息的服务实现类
 *
 * @author <a href="mailto:sunwendong@celloud.cn">sunwd</a>
 * @create 2017/12/19 上午11:20
 */
@Service
public class ErrorServiceImpl implements ErrorService {
    @Autowired
    private ErrorRepository errorRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Page<Error> findAll(int page, int size) {
        return errorRepository.findAll(new PageRequest(page, size));
    }

	@Override
	public Error findOne(String id) {
		
		return errorRepository.findOne(id);
		
	}

	@Override
	public List<Error> findByQuery(QueryVo queryVo) {
		
		//对日期进行转换
		StringToDateConverter timeConverter=new StringToDateConverter();
		Query query=new Query();
		
		Criteria criteria=new Criteria();
		//根据输入的不同条件进行查询
		if(queryVo.getUserId()!=null){
			criteria.andOperator(criteria.where("userId").is(queryVo.getUserId()));
			
		}
		if(StringUtils.isNotBlank(queryVo.getUsername())){
			criteria.and("username").is(queryVo.getUsername());
			
		}
		if(StringUtils.isNotBlank(queryVo.getModule())){
			criteria.and("module").is(queryVo.getModule());
		}
		if(StringUtils.isNotBlank(queryVo.getStartTime())&& StringUtils.isNotBlank(queryVo.getEndTime())){
			
			Date start = timeConverter.convert(queryVo.getStartTime());
			Date end = timeConverter.convert(queryVo.getEndTime());
			criteria.and("createTime").gte(start).lte(end);
		}
	
		
		query.addCriteria(criteria);

		List<Error> list = mongoTemplate.find(query, Error.class);
		return list;
	}
}

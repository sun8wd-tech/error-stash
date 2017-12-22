package com.celloud.errorstash.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.celloud.errorstash.config.StringToDateConverter;
import com.celloud.errorstash.model.Error;
import com.celloud.errorstash.model.QueryError;
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
	public List<Error> findByQuery(QueryError queryError) {
		Query query=new Query();
		Criteria criteria=new Criteria();
		//根据输入的不同条件进行查询
		if(queryError.getUserId()!=null){
			criteria.andOperator(criteria.where("userId").is(queryError.getUserId()));
			
		}
		if(StringUtils.isNotBlank(queryError.getUsername())){
			criteria.and("username").is(queryError.getUsername());
			
		}
		if(StringUtils.isNotBlank(queryError.getModule())){
			criteria.and("module").is(queryError.getModule());
		}
		
		if(queryError.getStartTime()!=null&& queryError.getEndTime()!=null){
			
			criteria.and("createTime").gte(queryError.getStartTime()).lte(queryError.getEndTime());
		}else if(queryError.getStartTime()!=null){
			criteria.and("createTime").gte(queryError.getStartTime());
		}else if(queryError.getEndTime()!=null){
			criteria.and("createTime").lte(queryError.getEndTime());
			
		}
		
		query.addCriteria(criteria);

		List<Error> list = mongoTemplate.find(query, Error.class);
		return list;
	}
}

package com.celloud.errorstash.repository;

import com.celloud.errorstash.model.Error;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author <a href="mailto:sunwendong@celloud.cn">sunwd</a>
 * @create 2017/12/19 上午11:02
 */
public interface ErrorRepository extends MongoRepository<Error, String> {
}

package com.celloud.errorstash.service;

import com.celloud.errorstash.model.Error;
import com.celloud.errorstash.model.QueryVo;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 异常信息的服务层接口
 *
 * @author <a href="mailto:sunwendong@celloud.cn">sunwd</a>
 * @create 2017/12/19 上午11:20
 */
public interface ErrorService {
    /**
     * 分页查询所有的异常
     *
     * @param page
     * @param size
     * @return
     */
    Page<Error> findAll(int page, int size);

	Error  findOne(String id);

	List<Error> findByQuery(QueryVo queryVo);
}

package com.celloud.errorstash.service.impl;

import com.celloud.errorstash.model.Error;
import com.celloud.errorstash.repository.ErrorRepository;
import com.celloud.errorstash.service.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


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

    @Override
    public Page<Error> findAll(int page, int size) {
        return errorRepository.findAll(new PageRequest(page, size));
    }
}

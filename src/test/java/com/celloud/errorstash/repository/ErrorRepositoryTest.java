package com.celloud.errorstash.repository;

import com.celloud.errorstash.model.Error;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * error dao的单元测试
 *
 * @author <a href="mailto:sunwendong@celloud.cn">sunwd</a>
 * @create 2017/12/19 上午11:34
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ErrorRepositoryTest {
    @Autowired
    private ErrorRepository errorRepository;

    @Test
    public void addTest() {
        for (int i = 0; i < 100; i++){
            Error error = new Error();
            error.setAddress("北京");
            error.setBrowser("谷歌");
            error.setCreateTime(new Date());
            error.setHttpMethod("get");
            error.setIp("192.168.22.2");
            error.setMessage("空指针");
            error.setModule("errorStash");
            error.setOs("mac");
            error.setStackTrace("空指针空指针");
            error.setUsername("sunwd");
            error.setUrl("https://www.celloud.cn/sss/aasdf");
            error.setUserId(12);
            error.setUserAgent("asdfasdf");
            errorRepository.save(error);
        }

    }
}

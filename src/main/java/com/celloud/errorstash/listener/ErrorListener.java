package com.celloud.errorstash.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:sunwendong@celloud.cn">sunwd</a>
 * @create 2017/12/19 下午12:46
 */
@Component
public class ErrorListener {
    private static final Logger logger = LoggerFactory.getLogger(ErrorListener.class);

    @KafkaListener(topics = {"errors"})
    public void process(ConsumerRecords<String, String> records) {
        records.forEach(record -> {
            logger.info("收到消息：topic={},key={},value={}", record.topic(), record.key(), record.value());
        });
    }
}

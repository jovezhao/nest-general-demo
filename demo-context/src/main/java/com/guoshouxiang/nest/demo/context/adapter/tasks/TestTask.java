package com.guoshouxiang.nest.demo.context.adapter.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestTask {

    @Scheduled(cron = "3 0/2 * * * *")
    public void printS() {
        Logger logger = LoggerFactory.getLogger(TestTask.class);
        logger.warn("当前时间：" + new Date());
    }
}

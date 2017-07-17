package com.example.task.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ningcs on 17/3/27.
 */

@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Integer count0 = 1;
    private Integer count1 = 1;
    private Integer count2 = 1;

    /**
     *  只需在这里调用service即可。
     *
     * 每隔十秒进行一次
     */
    @Scheduled(cron ="*/10 * * * * *")
    public void reportCurrentTime() throws InterruptedException {
        logger.info("业务层代码");
        logger.info(String.format("---第%s次执行，当前时间为：%s", count0++, dateFormat.format(new Date())));
    }


    /**
     *  只需在这里调用service即可。
     *
     * 每隔1秒进行一次
     */
    @Scheduled(fixedRate=1000)
    public void getCurrentTime() throws InterruptedException {
        logger.info("1秒执行一次");
        logger.info(String.format("---第%s次执行，当前时间为：%s", count0++, dateFormat.format(new Date())));
    }

    /**
     *  只需在这里调用service即可。
     *
     *执行 1秒后秒进行一次
     */
    @Scheduled(fixedDelay=1000)
    public void CurrentTime() throws InterruptedException {
        Thread.sleep(5000);
        logger.info("执行完1秒后秒进行一次");
        logger.info(String.format("---第%s次执行，当前时间为：%s", count0++, dateFormat.format(new Date())));
    }







}
package com.example.mongodb;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Date;

/**
 * description： 自定义Appender，记录日志到mongodb
 *
 * @author: zhaomeinan
 * date: 2018/6/19 14:32
 */
public class MongoDbAppender extends
        UnsynchronizedAppenderBase<ILoggingEvent> {

    @Override
    protected void append(ILoggingEvent eventObject) {
        /*for(int i=0;i<100000;i++){
            i = 1;
        }*/

        System.out.println("sys "+ eventObject.getLevel().toString() + " appender");

        MongoTemplate mongoTemplate = ApplicationContextProvider.getBean(MongoTemplate.class);
        if (mongoTemplate != null) {
            SysLog sysLog = new SysLog();
            sysLog.setLevel(eventObject.getLevel().toString());
            sysLog.setLoggerName(eventObject.getLoggerName());
            sysLog.setThreadName(eventObject.getThreadName());
            sysLog.setMessage(eventObject.getFormattedMessage());
            sysLog.setTimeStamp(eventObject.getTimeStamp());
            sysLog.setDate(new Date());
            mongoTemplate.insert(sysLog, "log");
        }
    }

}

package com.example.mongodb;

import java.io.Serializable;
import java.util.Date;

/**
 * description： TODO
 *
 * @author: zhaomeinan
 * date: 2018/6/19 14:26
 */
public class SysLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date date;

    private String loggerName;

    private String level;

    private String message;

    private String formattedMessage;

    private String threadName;

    private long timeStamp;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFormattedMessage() {
        return formattedMessage;
    }

    public void setFormattedMessage(String formattedMessage) {
        this.formattedMessage = formattedMessage;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}

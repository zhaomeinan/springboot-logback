package com.example.mongodb;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * description： 查询mongodb log中的数据
 *
 * @author: zhaomeinan
 * date: 2018/6/20 10:23
 */
@Component
public class SysLogHandler{

    private final String collectionName = "log";

    private MongoTemplate mongoTemplate = ApplicationContextProvider.getBean(MongoTemplate.class);

    /**
     * description： 根据message的值精确查询，同时加入时间限制，按照时间降序排列
     * @author: zhaomeinan
     * date: 2018/6/20 10:59
     */
    public List<SysLog> getRegexMessage(String message,String starttime,String endtime){
        Query query = new Query();

        query.addCriteria(Criteria.where("message").regex(message));

        Date start = this.getTime(starttime+" 00:00:00");
        Date end = this.getTime(endtime+" 23:59:59");

        if(start != null && endtime != null){
            query.addCriteria(Criteria.where("date").gte(start).lte(end));
        }else if(start != null){
            query.addCriteria(Criteria.where("date").gte(start));
        }else if(end != null){
            query.addCriteria(Criteria.where("date").lte(end));
        }

        query.with(new Sort(Sort.Direction.DESC,   "date"));

        return mongoTemplate.find(query,SysLog.class,collectionName);
    }

    /**
     * description： 字符串转日期
     * @author: zhaomeinan
     * date: 2018/6/20 11:22
     */
    public Date getTime(String date){
        if(StringUtils.isEmpty(date)) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return format.parse(date);
        } catch (ParseException e) {
           return null;
        }
    }
}

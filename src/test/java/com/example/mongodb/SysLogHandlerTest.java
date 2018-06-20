package com.example.mongodb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * description： 查询mongodb log中的数据  测试类
 *
 * @author: zhaomeinan
 * date: 2018/6/20 10:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysLogHandlerTest {

    @Autowired
    private SysLogHandler sysLogHandler;

    @Test
    public void getRegexMessage() throws Exception {
        List<SysLog> list = sysLogHandler.getRegexMessage("汉字","2018-06-20","2018-06-20");
        System.out.println(list);
    }

}
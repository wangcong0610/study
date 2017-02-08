package com.zp.web;

import com.zp.web.mapper.UserMapper;
import com.zp.web.mapper.UserRoleMapper;
import com.zp.web.po.UserRole;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Zhang Peng on 2016/9/26.
 */
@ContextConfiguration({"classpath:META-INF/spring/applicationContext.xml"})
public class UserRoleTest extends AbstractTestNGSpringContextTests {

    Logger logger = Logger.getLogger(UserRoleTest.class);

    @Autowired
    UserRoleMapper userRoleDAO;
    @Autowired
    UserMapper userDAO;

    @Test
    public void queryListTest() {
//        List<UserRole> list = userRoleDAO.selectByUserID(3L);
//        logger.info(list.size());
//        for (int i = 0; i<list.size(); i++) {
//            logger.info(list.get(i).getRoleId());
//        }

        List<UserRole> list = userRoleDAO.selectByUserID(3L);
        logger.info(list.size());
        for (int i = 0; i<list.size(); i++) {
            logger.info(list.get(i).getRoleId());
        }
    }

//    public void test(){
//        Map map = new TreeMap();
//        map.put()
//    }
}
